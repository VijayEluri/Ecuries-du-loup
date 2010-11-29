package mvc.forum;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import forum.donnees.Categorie;
import forum.service.ForumManager;

@Controller
public class FormulaireCategorieForumController{
	@Autowired
	@Qualifier("forumManager")
	private ForumManager forumManager;

	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}



	@ModelAttribute("categorie")
	public Categorie formBackingObject(HttpServletRequest request){
		String param = request.getParameter("categorie");
		if(param==null)
			return new Categorie();

		int idCategorie = Integer.parseInt(param);
		Categorie categorie = this.forumManager.getCategorie(idCategorie);

		return categorie;
	}
	@RequestMapping(value="/forum/administration/formulaireCategorie.do", method=RequestMethod.GET)
	public String showForm(){
		return "forum/formulaireCategorie";
	}

	@RequestMapping(value="/forum/administration/formulaireCategorie.do", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("categorie")Categorie categorie, BindingResult result) {
		

		new CategorieForumValidateur().validate(categorie, result);
		if(result.hasErrors()){
			return this.showForm();
		}
		
		if(this.estUneModificationCategorie(categorie)){
			this.forumManager.update(categorie);
		}else{
			this.forumManager.add(categorie);
		}
		
		return "redirect:../affichage.do";
	}

	private boolean estUneModificationCategorie(Categorie categorie) {
		return categorie.getId()!=0;
	}
}
