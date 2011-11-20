package fiche_chevaux.mvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import album_photo.editor.LongToPhotoEditor;
import donnees.photo.Media;
import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.donnees.FicheFormulaire;
import fiche_chevaux.donnees.Owner;
import fiche_chevaux.donnees.Race;
import fiche_chevaux.donnees.Robe;
import fiche_chevaux.donnees.Sexe;
import fiche_chevaux.donnees.Surnom;
import fiche_chevaux.editor.RaceEditor;
import fiche_chevaux.editor.RobeEditor;
import fiche_chevaux.editor.SexeEditor;
import fiche_chevaux.service.FicheChevauxManager;
@Controller
public class FormulaireFicheChevalController{
	@Autowired
	@Qualifier("ficheChevauxManager")
	private FicheChevauxManager ficheChevauxManager;
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;
	@Autowired
	private SexeEditor sexeEditor;
	@Autowired
	private RaceEditor raceEditor;
	@Autowired
	private RobeEditor robeEditor;
	@Autowired
	private LongToPhotoEditor longToPhotoEditor;

	

	@InitBinder
	public void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(Sexe.class, this.sexeEditor);
		binder.registerCustomEditor(Race.class, this.raceEditor);
		binder.registerCustomEditor(Robe.class, this.robeEditor);
		binder.registerCustomEditor(Media.class, this.longToPhotoEditor);
	}

	@ModelAttribute("fiche")
	public Object formBackingObject(HttpServletRequest request){
		String param = request.getParameter("id");
		if (param == null) {
			FicheFormulaire ficheFormulaire = new FicheFormulaire();
			return ficheFormulaire;
		}
		int idFiche = Integer.parseInt(param);
		Fiche fiche = this.ficheChevauxManager.recupererFiche(idFiche);
		return this.ficheToFicheFormulaire(fiche);
	}

	

	private FicheFormulaire ficheToFicheFormulaire(Fiche fiche) {
		FicheFormulaire ficheFormulaire = new FicheFormulaire();

		ficheFormulaire.setId(fiche.getId());
		ficheFormulaire.setNom(fiche.getNom());
		ficheFormulaire.setRobe(fiche.getRobe());
		ficheFormulaire.setRace(fiche.getRace());
		ficheFormulaire.setSexe(fiche.getSexe());
		if (fiche.getDateNaissance() == 0) {
			ficheFormulaire.setEstDateNaissanceChoisi(false);
			ficheFormulaire.setDateNaissance(0);
			ficheFormulaire.setAnneeNaissance(fiche.getAnneeNaissance());
		} else {
			ficheFormulaire.setEstDateNaissanceChoisi(true);
			ficheFormulaire.setDateNaissance(fiche.getDateNaissance());
			ficheFormulaire.setAnneeNaissance(0);
		}
		if (fiche.getPhotoCorps() != null) {
			ficheFormulaire.setPhotoCorps(fiche.getPhotoCorps());
		}else{
			ficheFormulaire.setPhotoCorps(new Media());
		}

		if (fiche.getPhotoTete() != null) {
			ficheFormulaire.setPhotoTete(fiche.getPhotoTete());
		}else{
			ficheFormulaire.setPhotoTete(new Media());
		}


		ficheFormulaire.setDescription(fiche.getDescription());

		List<String> surnoms = new ArrayList<String>();
		for (Surnom surnom : fiche.getSurnoms()) {
			if (surnom != null) {
				surnoms.add(surnom.getSurnom());
			}
		}
		ficheFormulaire.setSurnoms(surnoms);
		if(fiche.getOwner() != null){

			ficheFormulaire.setOwner(fiche.getOwner().getName());
		}else{
			ficheFormulaire.setOwner("");
		}

		return ficheFormulaire;
	}

	@ModelAttribute("listeRobes")
	public List<Robe> getRobesList(){
		return this.ficheChevauxManager.recupererToutesLesRobes();
	}
	@ModelAttribute("listeRaces")
	public List<Race> getRacesList(){
		return this.ficheChevauxManager.recupererToutesLesRaces();
	}
	@ModelAttribute("listeSexes")
	public List<Sexe> getSexsList(){
		return this.ficheChevauxManager.recupererTousLesSexes();
	}
	
	@RequestMapping(value="/ficheChevaux/administration/formulaireFiche.do", method= RequestMethod.GET)
	public String showForm(){
		return "/ficheChevaux/formulaireFicheCheval";
	}

	@RequestMapping(value="/ficheChevaux/administration/formulaireFiche.do", method= RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("fiche")FicheFormulaire ficheFormulaire ){

		if (this.estUneModificationFiche(ficheFormulaire)) {
			Fiche fiche = this.ficheFormulaireToFicheExistante(ficheFormulaire);
			this.gestionSurnom(fiche, ficheFormulaire);

			this.ficheChevauxManager.modifierFicheChevaux(fiche);
		} else {
			Fiche fiche = this.ficheFormulaireToFiche(ficheFormulaire);
			this.ficheChevauxManager.creerFicheChevaux(fiche);

			this.gestionSurnom(fiche, ficheFormulaire);
		}
		String redirect = "";
		if (this.estUneModificationFiche(ficheFormulaire)) {
			redirect = "redirect:/ficheChevaux/affichageFiche.do?id="
				+ ficheFormulaire.getId();
		} else {
			redirect = "redirect:/ficheChevaux/affichage.do";
		}

		return new ModelAndView(redirect);
	}

	private boolean estUneModificationFiche(FicheFormulaire ficheFormulaire) {
		return ficheFormulaire.getId() != 0;
	}

	private Fiche ficheFormulaireToFicheExistante(
			FicheFormulaire ficheFormulaire) {
		Fiche fiche = this.ficheChevauxManager.recupererFiche((int) ficheFormulaire.getId());

		this.remplirFiche(fiche, ficheFormulaire);

		return fiche;
	}

	private Fiche ficheFormulaireToFiche(FicheFormulaire ficheFormulaire) {
		Fiche fiche = new Fiche();

		this.remplirFiche(fiche, ficheFormulaire);

		return fiche;
	}

	private void remplirFiche(Fiche fiche, FicheFormulaire ficheFormulaire) {
		fiche.setNom(ficheFormulaire.getNom());
		
		fiche.setRobe(ficheFormulaire.getRobe());
		fiche.setRace(ficheFormulaire.getRace());
		fiche.setSexe(ficheFormulaire.getSexe());
		fiche.setDescription(ficheFormulaire.getDescription());
		
		if (ficheFormulaire.isEstDateNaissanceChoisi()) {
			fiche.setDateNaissance(ficheFormulaire.getDateNaissance());
			fiche.setAnneeNaissance(0);
		} else {
			fiche.setDateNaissance(0);
			fiche.setAnneeNaissance(ficheFormulaire.getAnneeNaissance());
		}
		
		fiche.setPhotoCorps(ficheFormulaire.getPhotoCorps());
		fiche.setPhotoTete(ficheFormulaire.getPhotoTete());
		
		String owner = ficheFormulaire.getOwner().trim();
		if(owner.equals("")){
			fiche.setOwner(null);
		}else{
			if(fiche.getOwner()==null){
				Owner newOwner = new Owner();
				newOwner.setName(owner);
				newOwner.setUser(this.utilisateurManager.getById(owner));
				
				this.ficheChevauxManager.creerOwnerCheval(newOwner);
				fiche.setOwner(newOwner);
			}else{
				fiche.getOwner().setName(owner);
				fiche.getOwner().setUser(this.utilisateurManager.getById(owner));
				
				this.ficheChevauxManager.modifierOwnerCheval(fiche.getOwner());
			}
		}
	}

	private void gestionSurnom(Fiche fiche, FicheFormulaire ficheFormulaire) {
		for (String surnomString : ficheFormulaire.getSurnoms()) {
			if (!surnomString.trim().equals("")) {
				Surnom surnom = this.ficheChevauxManager.recupererSurnom(surnomString, fiche);
				if (surnom == null) {
					surnom = new Surnom();
					surnom.setSurnom(surnomString);
					surnom.setFiche(fiche);
					this.ficheChevauxManager.creerSurnom(surnom);
				}

			}

		}

		this.supprimerSurnomPlusUtiliser(fiche, ficheFormulaire);

	}

	private void supprimerSurnomPlusUtiliser(Fiche fiche,
			FicheFormulaire ficheFormulaire) {
		List<Surnom> surnomDejaDansBase = this.ficheChevauxManager
		.recupererSurnoms(fiche);
		for (Surnom surnom : surnomDejaDansBase) {
			if (!ficheFormulaire.getSurnoms().contains(surnom.getSurnom())) {
				this.ficheChevauxManager.supprimerSurnom(surnom);
			}
		}
	}

}
