package mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.VracManager;
import service.smiley.SmileyManager;
import donnees.Vrac;
import donnees.smiley.CategorieSmiley;
@Controller
public class FormulaireVracController{
	@Autowired
	@Qualifier("vracManager")
	private VracManager vracManager;
	@Autowired
	@Qualifier("smileyManager")
	private SmileyManager smileyManager;

	public void setVracManager(VracManager vracManager) {
		this.vracManager = vracManager;
	}

	public void setSmileyManager(SmileyManager smileyManager) {
		this.smileyManager = smileyManager;
	}

	@ModelAttribute("vrac")
	public Object formBackingObject(HttpServletRequest request){
		String idVrac = request.getParameter("vrac");
		Vrac vrac = this.vracManager.recupererVrac(idVrac);
		return vrac;
	}

	@ModelAttribute("categoriesSmiley")
	public List<CategorieSmiley> referenceData(){
		return this.smileyManager.recupererToutesLesCategoriesSmiley();
	}

	@RequestMapping(value="/administration/formulaireVrac.do", method= RequestMethod.GET)
	public String showForm() {
		return "/formulaireVrac";
	}
	@RequestMapping(value="/administration/formulaireVrac.do", method= RequestMethod.POST)
	public String onSubmit(@ModelAttribute("vrac")Vrac vrac, BindingResult result) {
		this.vracManager.modifierVrac(vrac);
		return "/formulaireVrac";
	}

}
