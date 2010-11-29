package mvc.forum.administration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.smiley.SmileyManager;
import donnees.smiley.CategorieSmiley;
import donnees.smiley.CategorieSmileyLight;

@Controller
public class FormulaireGestionCategorieController{
	@Autowired
	@Qualifier("smileyManager")
	private SmileyManager smileyManager;

	public void setSmileyManager(SmileyManager smileyManager) {
		this.smileyManager = smileyManager;
	}

	@ModelAttribute("categorieSmiley")
	protected Object formBackingObject(HttpServletRequest request){
		String param = request.getParameter("categorie");

		if(param==null){
			return new CategorieSmileyLight();
		}
		int idCategorie = Integer.parseInt(param);
		CategorieSmiley categorie = this.smileyManager.recupererCategorieSmiley(idCategorie);

		CategorieSmileyLight light = new CategorieSmileyLight();
		light.setId(categorie.getId());
		light.setNom(categorie.getNom());

		return light;
	}
	
	@RequestMapping(value="/forum/administration/formulaireCategorieSmiley.do", method=RequestMethod.GET)
	public String showForm(){
		return "forum/administration/formulaireCategorieSmiley";
	}
	
	@RequestMapping(value="/forum/administration/formulaireCategorieSmiley.do", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("categorieSmiley")CategorieSmileyLight light, BindingResult result){
		
		new CategorieSmileyValidateur().validate(light, result);
		if(result.hasErrors()){
			return this.showForm();
		}
	
		if(this.estUneModification(light)){
			CategorieSmiley categorie = this.smileyManager.recupererCategorieSmiley(light.getId());

			categorie.setNom(light.getNom());

			this.smileyManager.modifierCategorieSmiley(categorie);
		}else{
			CategorieSmiley categorie = new CategorieSmiley();

			categorie.setNom(light.getNom());

			this.smileyManager.creerCategorieSmiley(categorie);
		}
		
		return "redirect:gestionCategorieSmiley.do";

	}

	private boolean estUneModification(CategorieSmileyLight light){
		return light.getId() != 0;
	}
}
