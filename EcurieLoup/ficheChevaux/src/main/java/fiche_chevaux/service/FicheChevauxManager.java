package fiche_chevaux.service;

import java.util.List;

import fiche_chevaux.donnees.Category;
import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.donnees.Owner;
import fiche_chevaux.donnees.Race;
import fiche_chevaux.donnees.Robe;
import fiche_chevaux.donnees.Sexe;
import fiche_chevaux.donnees.Surnom;

public interface FicheChevauxManager {

	public Fiche recupererFiche(long idFiche);
	public List<Fiche> recupererToutesLesFiches();
	public List<Fiche> recupererChevauxWith(Robe robe);
	public List<Fiche> recupererChevauxWith(Sexe sexe);
	public List<Fiche> recupererChevauxWith(Race race);
	
	public void creerFicheChevaux(Fiche fiche);
	public void modifierFicheChevaux(Fiche fiche);
	public void supprimerFicheChevaux(Fiche fiche);
	
	public List<Robe> recupererToutesLesRobes();
	public Robe recupererRobe(long idRobe);
	
	public void modifierRobeCheval(Robe robe);
	public void creerRobeCheval(Robe robe);
	public void supprimerRobeCheval(Robe robe)throws ExistFicheWithThisRobeException;
	
	
	public List<Race> recupererToutesLesRaces();
	public Race recupererRace(long idRace);
	
	public void creerRaceCheval(Race race);
	public void modifierRaceCheval(Race race);
	public void supprimerRaceCheval(Race race) throws ExistFicheWithThisRaceException;

	
	public List<Sexe> recupererTousLesSexes();
	public Sexe recupererSexe(long idSexe);
	
	public void creerSexeCheval(Sexe sexe);
	public void modifierSexeCheval(Sexe sexe);
	public void supprimerSexeCheval(Sexe sexe) throws ExistFicheWithThisSexeException;
	
	
	//public Photo recupererPhoto(long idPhoto);
	
	
	public Surnom recupererSurnom(long id);
	public Surnom recupererSurnom(String surnom, Fiche fiche);
	public List<Surnom> recupererSurnoms(Fiche fiche);
	public void supprimerSurnom(Surnom surnom);
	public void creerSurnom(Surnom surnom);
	
	
	
	public List<Owner> recupererTousLesOwners();
	public Owner recupererOwner(long idOwner);
	
	public void creerOwnerCheval(Owner owner);
	public void modifierOwnerCheval(Owner owner);
	public void supprimerOwnerCheval(Owner owner);
	
	
	public Category getCategory(long idCategory);
	public List<Category> getAllCategorys();
	public void deleteCategory(long idCategory);
	public void updateCategory(Category category);
	public void createCategory(Category category);
	
	public List<Fiche> getHorseCardCategory(long idCategory);
	
}
