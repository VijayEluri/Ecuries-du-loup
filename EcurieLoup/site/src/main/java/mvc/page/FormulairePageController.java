package mvc.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.page.PageManager;
import service.smiley.SmileyManager;
import donnees.page.Page;
import donnees.smiley.CategorieSmiley;

@Controller
public class FormulairePageController {
	@Autowired
	@Qualifier("pageManager")
	private PageManager pageManager;
	
	@Autowired
	@Qualifier("smileyManager")
	private SmileyManager smileyManager;

	public void setPageManager(PageManager pageManager) {
		this.pageManager = pageManager;
	}

	public void setSmileyManager(SmileyManager smileyManager) {
		this.smileyManager = smileyManager;
	}

	@ModelAttribute("page")
	public Page formBackingObject(HttpServletRequest request) {
		String param = request.getParameter("page");
		if (param == null)
			return new Page();

		int idPage = Integer.parseInt(param);
		Page page = this.pageManager.getById(idPage);

		page.setContenu(this.gestionCaractereSpeciaux(page.getContenu()));
		return page;
	}

	private String gestionCaractereSpeciaux(String chaine) {

		chaine = chaine.replace("€", "&euro;");
		return chaine;
	}

	@ModelAttribute("categoriesSmiley")
	public List<CategorieSmiley> referenceData(){
		return  smileyManager.recupererToutesLesCategoriesSmiley();
	}

	@RequestMapping(value="/page/formulairePages.do", method= RequestMethod.GET)
	public String showForm(){
		return "page/formulairePage";
		
	}
	@RequestMapping(value="/page/formulairePages.do", method= RequestMethod.POST)
	public String onSubmit(@ModelAttribute("page")Page page, BindingResult result){

		new PageValidateur().validate(page, result);
		if(result.hasErrors()){
			return "page/formulairePage";
		}
		if (this.isModificationPage(page)) {
			this.pageManager.update(page);
		} else {
			this.pageManager.add(page);
		}
		return "redirect:administrationPages.do";
	}

	private boolean isModificationPage(Page page) {
		return page.getId() != 0;
	}
}
