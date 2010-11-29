package mvc.forum.administration;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import service.smiley.SmileyManager;
import donnees.smiley.CategorieSmiley;
import donnees.smiley.Smiley;
import donnees.smiley.SmileyLight;

@Controller
public class FormulaireSmileyController{
	@Autowired
	@Qualifier("smileyManager")
	private SmileyManager smileyManager;

	public void setSmileyManager(SmileyManager smileyManager) {
		this.smileyManager = smileyManager;
	}

	@ModelAttribute("smiley")
	public SmileyLight formBackingObject(HttpServletRequest request){
		String categorieString = request.getParameter("categorie");
		int categorie = Integer.parseInt(categorieString);

		SmileyLight smileyLight =new SmileyLight();
		smileyLight.setCategorieSmiley(categorie);

		return smileyLight;
	}
	@InitBinder
	public void initBinder(HttpServletRequest request,ServletRequestDataBinder binder){
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}
	
	@RequestMapping(value="/forum/administration/formulaireSmiley.do", method = RequestMethod.GET)
	public String showForm(){
		return "forum/administration/formulaireSmiley";
	}	

	@RequestMapping(value="/forum/administration/formulaireSmiley.do", method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("smiley")SmileyLight light, BindingResult result, HttpServletRequest request){
	
		new SmileyValidateur().validate(light, result);
		if(result.hasErrors()){
			return this.showForm();
		}
		
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile fichierImage = multipartRequest.getFile("image");

		if (fichierImage.isEmpty()) {
			result.rejectValue("image", "", "fichier vide");
			return this.showForm();
		}
		

		Smiley smiley = new Smiley();
		smiley.setCode(light.getCode());
		CategorieSmiley categorieSmiley = this.smileyManager.recupererCategorieSmiley(light.getCategorieSmiley());
		smiley.setCategorieSmiley(categorieSmiley);

		String chemin ="tmp";
		chemin+="smiley";
		chemin+="_"+new Date().getTime();
		chemin+=(int) (Math.random()*10000);
		
		File imageSmiley = new File(chemin);
		try {
			fichierImage.transferTo(imageSmiley);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.smileyManager.creerSmiley(smiley, imageSmiley);

		imageSmiley.delete();
		
		return "redirect:gestionSmiley.do?categorie="+smiley.getCategorieSmiley().getId();
		
	}
}
