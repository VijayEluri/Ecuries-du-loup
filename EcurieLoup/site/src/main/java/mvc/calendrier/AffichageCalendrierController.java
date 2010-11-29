package mvc.calendrier;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.calendrier.CalendrierManager;
import donnees.calendrier.Evenement;
@Controller
public class AffichageCalendrierController {
	@Autowired
	@Qualifier("calendrierManager")
	private CalendrierManager calendrierManager;

	public void setCalendrierManager(CalendrierManager calendrierManager) {
		this.calendrierManager = calendrierManager;
	}

	@RequestMapping("/calendrier/affichage.do")
	public ModelAndView handleRequest(@RequestParam(value = "jour", required= false)String paramJour, @RequestParam(value = "mois", required= false)String paramMois, @RequestParam(value = "annee", required= false)String paramAnnee) throws Exception {
		Map<String, Object> renvoyer = new HashMap<String, Object>();

		Calendar calendar = Calendar.getInstance();

		
		//détermine le jour en cours
		if (this.estUnaffichageParPassageParametre(paramMois, paramAnnee)) {
			int paramMoisValeur = Integer.parseInt(paramMois) - 1;
			int paramAnneeValeur = Integer.parseInt(paramAnnee);

			if (paramMoisValeur == 1) {
				calendar.set(Calendar.DAY_OF_MONTH, 1);
			}

			calendar.set(Calendar.MONTH, paramMoisValeur);
			calendar.set(Calendar.YEAR, paramAnneeValeur);

			Calendar now = Calendar.getInstance();
			if ((now.get(Calendar.MONTH) == calendar.get(Calendar.MONTH))
					&& (now.get(Calendar.YEAR) == calendar.get(Calendar.YEAR))) {
				int jour = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
				renvoyer.put("jourEncour", jour);
			}

		} else if (this.estUnaffichageSansPassageParametre(paramMois,
				paramAnnee)) {
			int jour = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
			renvoyer.put("jourEncour", jour);
		}
		//fin de détermine le jours en corus
		int annee = calendar.get(Calendar.YEAR);
		int numeroMois = calendar.get(Calendar.MONTH) + 1;

		List<Evenement> listeEvenement = null;
		if (paramJour != null) {
			int numeroJour = Integer.parseInt(paramJour);
			listeEvenement = this.calendrierManager.getAllEventOfDay(annee,
					numeroMois, numeroJour);
		} else {
			listeEvenement = new ArrayList<Evenement>();
		}

		int nombreJourMois = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int nombreJourVide = this.getNombreJourVide(calendar);
		String nomMois = calendar.getDisplayName(Calendar.MONTH, Calendar.LONG,
				Locale.getDefault());

		renvoyer.put("listeEvenement", listeEvenement);
		renvoyer.put("nomMois", nomMois);
		renvoyer.put("numeroMois", numeroMois);
		renvoyer.put("annee", annee);
		renvoyer.put("jourVide", nombreJourVide);
		renvoyer.put("jourMois", nombreJourMois);

		renvoyer.put("mapEvenement", this.calendrierManager
				.getAllEventsByMonthByDay(annee, numeroMois));

		return new ModelAndView("/calendrier/affichageCalendrier", renvoyer);
	}

	private boolean estUnaffichageParPassageParametre(String paramMois,
			String paramAnnee) {
		return (paramMois != null) && (paramAnnee != null);
	}

	private boolean estUnaffichageSansPassageParametre(String paramMois,
			String paramAnnee) {
		return (paramMois == null) && (paramAnnee == null);
	}

	private int getNombreJourVide(Calendar referenceMoisAnnee) {
		Calendar calendarPremierJour = (Calendar) referenceMoisAnnee.clone();
		calendarPremierJour.set(Calendar.DAY_OF_MONTH, 1);

		int nombreJour = calendarPremierJour.get(Calendar.DAY_OF_WEEK) - 2;

		nombreJour = (nombreJour == -1) ? 6 : nombreJour;

		return nombreJour;
	}
}