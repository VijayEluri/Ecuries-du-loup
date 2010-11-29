package mvc.calendrier;

import java.util.List;

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

import service.calendrier.CalendrierManager;
import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;

@Controller
public class FormulaireEvenementController{
	@Autowired
	@Qualifier("calendrierManager")
	private CalendrierManager calendrierManager;
	@Autowired
	private TypeEventEditor typeEventEditor;

	public void setCalendrierManager(CalendrierManager calendrierManager) {
		this.calendrierManager = calendrierManager;
	}

	public void setTypeEventEditor(TypeEventEditor typeEventEditor) {
		this.typeEventEditor = typeEventEditor;
	}

	@ModelAttribute("evenement")
	protected Evenement formBackingObject(HttpServletRequest request){

		String param = request.getParameter("evenement");
		if (param == null)
			return new Evenement();

		long idEvenement = Long.parseLong(param);
		Evenement evenement = this.calendrierManager.getEvent(idEvenement);

		return evenement;
	}

	@ModelAttribute("listeTypeEvenement")
	protected List<TypeEvenement> getTypeEventList() {
			return this.calendrierManager.getAllTypeEvents();
	}

	@InitBinder
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {

		binder.registerCustomEditor(TypeEvenement.class, this.typeEventEditor);
	}

	@RequestMapping(value="/calendrier/administration/formulaireEvenement.do", method= RequestMethod.GET)
	public String showForm(){
		return "calendrier/formulaireEvenement";
	}
	
	@RequestMapping(value="/calendrier/administration/formulaireEvenement.do", method= RequestMethod.POST)
	protected String onSubmit(@ModelAttribute("evenement")Evenement event, BindingResult result ){

		new EvenementValidateur().validate(event, result);
		
		if(result.hasErrors()){
			return this.showForm();
		}
		
		if (this.estUneModificationEvenement(event)) {

			this.calendrierManager.update(event);
		} else {

			this.calendrierManager.add(event);
		}

		return "redirect:../affichage.do";
	}

	private boolean estUneModificationEvenement(Evenement evenement) {
		return evenement.getId() != 0;
	}
}
