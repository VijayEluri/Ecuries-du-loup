package mvc.calendrier;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.calendrier.CalendrierManager;
import donnees.calendrier.TypeEvenement;

@Controller
public class FormulaireTypeEvenementController{
	@Autowired
	@Qualifier("calendrierManager")
	private CalendrierManager calendrierManager;

	public void setCalendrierManager(CalendrierManager calendrierManager) {
		this.calendrierManager = calendrierManager;
	}

	@ModelAttribute("typeEvenement")
	protected TypeEvenement formBackingObject(HttpServletRequest request){

		String param = request.getParameter("typeEvenement");
		if (param == null)
			return new TypeEvenement();

		int idTypeEvenement = Integer.parseInt(param);
		TypeEvenement typeEvenement = this.calendrierManager
				.getTypeEvent(idTypeEvenement);

		return typeEvenement;
	}
	
	@RequestMapping(value="/calendrier/administration/formulaireTypeEvenement.do", method= RequestMethod.GET)
	public String showForm(){
		return "calendrier/formulaireTypeEvenement";
	}

	@RequestMapping(value="/calendrier/administration/formulaireTypeEvenement.do", method= RequestMethod.POST)
	protected String onSubmit(@ModelAttribute("typeEvenement")TypeEvenement eventType, BindingResult result ){
		
		new EvenementValidateur().validate(eventType, result);
		if(result.hasErrors()){
			return this.showForm();
		}
		
		if (this.estUneModificationTypeEvenement(eventType)) {
			this.calendrierManager.update(eventType);
		} else {
			this.calendrierManager.add(eventType);
		}
		return "redirect:affichageTypeEvenement.do";

	}

	private boolean estUneModificationTypeEvenement(TypeEvenement typeEvenement) {
		return typeEvenement.getId() != 0;
	}

}
