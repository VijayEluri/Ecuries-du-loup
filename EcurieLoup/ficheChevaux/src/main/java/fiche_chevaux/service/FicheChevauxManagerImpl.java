package fiche_chevaux.service;

import java.util.List;

import fiche_chevaux.dao.CategoryChevauxDAO;
import fiche_chevaux.dao.FicheChevauxDAO;
import fiche_chevaux.dao.OwnerChevauxDAO;
import fiche_chevaux.dao.RaceChevauxDAO;
import fiche_chevaux.dao.RobeChevauxDAO;
import fiche_chevaux.dao.SexeChevauxDAO;
import fiche_chevaux.dao.SurnomsChevauxDAO;
import fiche_chevaux.donnees.Category;
import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.donnees.Owner;
import fiche_chevaux.donnees.Race;
import fiche_chevaux.donnees.Robe;
import fiche_chevaux.donnees.Sexe;
import fiche_chevaux.donnees.Surnom;

public class FicheChevauxManagerImpl implements FicheChevauxManager {
    private FicheChevauxDAO ficheChevauxDAO;
    private RobeChevauxDAO robeChevauxDAO;
    private RaceChevauxDAO raceChevauxDAO;
    private SexeChevauxDAO sexeChevauxDAO;
    // private AlbumPhotoManager albumPhotoManager;
    private SurnomsChevauxDAO surnomsChevauxDAO;
    private OwnerChevauxDAO ownerChevauxDAO;
    private CategoryChevauxDAO categoryChevauxDAO;

    public void setFicheChevauxDAO(FicheChevauxDAO ficheChevauxDAO) {
	this.ficheChevauxDAO = ficheChevauxDAO;
    }

    public void setRobeChevauxDAO(RobeChevauxDAO robeChevauxDAO) {
	this.robeChevauxDAO = robeChevauxDAO;
    }

    public void setRaceChevauxDAO(RaceChevauxDAO raceChevauxDAO) {
	this.raceChevauxDAO = raceChevauxDAO;
    }

    public void setSexeChevauxDAO(SexeChevauxDAO sexeChevauxDAO) {
	this.sexeChevauxDAO = sexeChevauxDAO;
    }

    public void setOwnerChevauxDAO(OwnerChevauxDAO ownerChevauxDAO) {
	this.ownerChevauxDAO = ownerChevauxDAO;
    }

    public void setCategoryChevauxDAO(CategoryChevauxDAO categoryChevauxDAO) {
	this.categoryChevauxDAO = categoryChevauxDAO;
    }

    /*
     * public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) { this.albumPhotoManager = albumPhotoManager; }
     */

    public void setSurnomsChevauxDAO(SurnomsChevauxDAO surnomsChevauxDAO) {
	this.surnomsChevauxDAO = surnomsChevauxDAO;
    }

    @Override
    public void creerFicheChevaux(Fiche fiche) {
	this.ficheChevauxDAO.add(fiche);
    }

    @Override
    public void modifierFicheChevaux(Fiche fiche) {
	this.ficheChevauxDAO.update(fiche);
    }

    @Override
    public Fiche recupererFiche(long idFiche) {
	Fiche fiche = this.ficheChevauxDAO.findById(idFiche);
	return fiche;
    }

    @Override
    public List<Fiche> recupererToutesLesFiches() {
	List<Fiche> fiches = this.ficheChevauxDAO.findAll();

	return fiches;
    }

    @Override
    public void supprimerFicheChevaux(Fiche fiche) {
	for (Surnom surnom : fiche.getSurnoms()) {
	    if (surnom != null) {
		this.surnomsChevauxDAO.remove(surnom);
	    }
	}
	this.ficheChevauxDAO.remove(fiche);
    }

    // /////////////////////////////////////////////////////////
    @Override
    public Robe recupererRobe(long idRobe) {
	return this.robeChevauxDAO.findById(idRobe);
    }

    @Override
    public List<Robe> recupererToutesLesRobes() {
	return this.robeChevauxDAO.findAll();
    }

    @Override
    public void creerRobeCheval(Robe robe) {
	this.robeChevauxDAO.add(robe);
    }

    @Override
    public void modifierRobeCheval(Robe robe) {
	this.robeChevauxDAO.update(robe);

    }

    @Override
    public void supprimerRobeCheval(Robe robe) throws ExistFicheWithThisRobeException {
	if (this.recupererChevauxWith(robe).isEmpty()) {
	    this.robeChevauxDAO.remove(robe);
	} else {
	    throw new ExistFicheWithThisRobeException();
	}

    }

    // ///////////////////////////////////////////////////////////
    @Override
    public Race recupererRace(long idRace) {
	return this.raceChevauxDAO.findById(idRace);
    }

    @Override
    public List<Race> recupererToutesLesRaces() {
	return this.raceChevauxDAO.findAll();
    }

    @Override
    public void creerRaceCheval(Race race) {
	this.raceChevauxDAO.add(race);
    }

    @Override
    public void modifierRaceCheval(Race race) {
	this.raceChevauxDAO.update(race);
    }

    @Override
    public void supprimerRaceCheval(Race race) throws ExistFicheWithThisRaceException {
	if (this.recupererChevauxWith(race).isEmpty()) {
	    this.raceChevauxDAO.remove(race);
	} else {
	    throw new ExistFicheWithThisRaceException();
	}

    }

    @Override
    public Sexe recupererSexe(long idSexe) {
	return this.sexeChevauxDAO.findById(idSexe);
    }

    // ///////////////////////////////////////////////////////////////////////////////////
    @Override
    public List<Sexe> recupererTousLesSexes() {
	return this.sexeChevauxDAO.findAll();
    }

    @Override
    public void creerSexeCheval(Sexe sexe) {
	this.sexeChevauxDAO.add(sexe);

    }

    @Override
    public void modifierSexeCheval(Sexe sexe) {
	this.sexeChevauxDAO.update(sexe);

    }

    @Override
    public void supprimerSexeCheval(Sexe sexe) throws ExistFicheWithThisSexeException {
	if (this.recupererChevauxWith(sexe).isEmpty()) {
	    this.sexeChevauxDAO.remove(sexe);
	} else {
	    throw new ExistFicheWithThisSexeException();
	}
    }

    /*
     * @Override public Photo recupererPhoto(long idPhoto) { return this.albumPhotoManager.recupererPhoto(idPhoto); }
     */
    // ///////////////////////////////////////////////////////////////////////////////
    @Override
    public void creerSurnom(Surnom surnom) {
	this.surnomsChevauxDAO.add(surnom);

    }

    @Override
    public Surnom recupererSurnom(long id) {
	return this.surnomsChevauxDAO.findById(id);
    }

    @Override
    public Surnom recupererSurnom(String surnom, Fiche fiche) {
	return this.surnomsChevauxDAO.getSurnom(surnom, fiche);
    }

    @Override
    public void supprimerSurnom(Surnom surnom) {
	this.surnomsChevauxDAO.remove(surnom);

    }

    @Override
    public List<Surnom> recupererSurnoms(Fiche fiche) {
	return this.surnomsChevauxDAO.getSurnoms(fiche);
    }

    @Override
    public List<Fiche> recupererChevauxWith(Sexe sexe) {
	return this.ficheChevauxDAO.getFichesChevaux(sexe);
    }

    @Override
    public List<Fiche> recupererChevauxWith(Robe robe) {
	return this.ficheChevauxDAO.getFichesChevaux(robe);
    }

    @Override
    public List<Fiche> recupererChevauxWith(Race race) {
	return this.ficheChevauxDAO.getFichesChevaux(race);
    }

    @Override
    public void creerOwnerCheval(Owner owner) {
	this.ownerChevauxDAO.add(owner);
    }

    @Override
    public void modifierOwnerCheval(Owner owner) {
	this.ownerChevauxDAO.update(owner);

    }

    @Override
    public Owner recupererOwner(long idOwner) {
	return this.ownerChevauxDAO.findById(idOwner);
    }

    @Override
    public List<Owner> recupererTousLesOwners() {
	return this.ownerChevauxDAO.findAll();
    }

    @Override
    public void supprimerOwnerCheval(Owner owner) {
	this.ownerChevauxDAO.remove(owner);

    }

    @Override
    public Category getCategory(long idCategory) {
	return this.categoryChevauxDAO.findById(idCategory);
    }

    @Override
    public List<Category> getAllCategorys() {
	List<Category> categorys = this.categoryChevauxDAO.findAll();
	Category categoryNotClassed = new Category();
	categoryNotClassed.setId(0);
	categoryNotClassed.setName("non classé");
	categorys.add(categoryNotClassed);

	for (Category category : categorys) {
	    List<Fiche> horseCards = this.getHorseCardCategory(category.getId());
	    category.setEmptyCategory(horseCards.isEmpty());
	    if (!horseCards.isEmpty()) {
		long mediaId = 0;
		if (horseCards.get(0).getPhoto() != null) {
		    mediaId = horseCards.get(0).getPhoto().getId();
		}
		category.setMediaId(mediaId);
	    }
	}
	return categorys;
    }

    @Override
    public List<Fiche> getHorseCardCategory(long idCategory) {
	return this.ficheChevauxDAO.getFichesChevauxCategory(idCategory);
    }

    @Override
    public void deleteCategory(long idCategory) {
	this.reinitCategoryHorseCardOfOneCategory(idCategory);
	Category category = this.categoryChevauxDAO.findById(idCategory);
	this.categoryChevauxDAO.remove(category);
    }

    public void reinitCategoryHorseCardOfOneCategory(long idCategory) {
	List<Fiche> horseCardOfCategory = this.getHorseCardCategory(idCategory);
	for (Fiche fiche : horseCardOfCategory) {
	    fiche.setCategory(null);
	    this.modifierFicheChevaux(fiche);
	}
    }

    @Override
    public void updateCategory(Category category) {
	this.categoryChevauxDAO.update(category);

    }

    @Override
    public void createCategory(Category category) {
	this.categoryChevauxDAO.add(category);
    }
}
