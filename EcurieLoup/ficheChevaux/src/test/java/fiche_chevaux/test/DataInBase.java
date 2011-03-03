package fiche_chevaux.test;

import java.util.ArrayList;
import java.util.List;

import donnees.User;
import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.donnees.Owner;
import fiche_chevaux.donnees.Race;
import fiche_chevaux.donnees.Robe;
import fiche_chevaux.donnees.Sexe;
import fiche_chevaux.donnees.Surnom;

public class DataInBase {
	private static Fiche fiche ;
	private static Race race;
	private static Sexe sexe;
	private static Robe robe;
	private static Fiche fiche2;

	public static Fiche getFiche(){
		if(DataInBase.fiche == null){
			DataInBase.fiche = new Fiche();
			fiche.setId(1);
			fiche.setNom("nom dada");
			fiche.setAnneeNaissance(2005);
			fiche.setDescription("description du dada");
			fiche.setRace(DataInBase.getRace());
			fiche.setRobe(DataInBase.getRobe());
			fiche.setSexe(DataInBase.getSexe());
			List<Surnom> surnoms = new ArrayList<Surnom>();
			surnoms.add(DataInBase.getSurnom());
			fiche.setSurnoms(surnoms);
			fiche.setOwner(DataInBase.getOwner());
		}
		return DataInBase.fiche;
	}
	public static Fiche getFiche2(){
		if(DataInBase.fiche2 == null){
			DataInBase.fiche2 = new Fiche();
			fiche2.setId(2);
			fiche2.setNom("nom dada");
			fiche2.setAnneeNaissance(2005);
			fiche2.setDescription("description du dada");
			fiche2.setRace(DataInBase.getRace());
			fiche2.setRobe(DataInBase.getRobe());
			fiche2.setSexe(DataInBase.getSexe());
			
		}
		return DataInBase.fiche2;
	}

	public static Race getRace(){
		if(DataInBase.race == null){
			DataInBase.race = new Race();
			race.setId(1);
			race.setNom("nom Race");
		}

		return race;
	}
	public static Robe getRobe(){
		if(DataInBase.robe == null){
			DataInBase.robe = new Robe();
			DataInBase.robe.setId(1);
			DataInBase.robe.setNom("nom Robe");
		}

		return robe;
	}

	public static Sexe getSexe(){
		if(DataInBase.sexe == null){
			DataInBase.sexe = new Sexe();
			sexe.setId(1);
			sexe.setNom("nom Sexe");
		}

		return sexe;
	}

	public static Surnom getSurnom(){
		Surnom surnom = new Surnom();
		surnom.setId(1);
		surnom.setSurnom("nom Surnom");
		surnom.setFiche(DataInBase.getFiche());
		return surnom;
	}
	
	public static User getUser(){
		User user = new User();
		user.setId("krack");
		return user;
	}
	
	public static Owner getOwner(){
		Owner owner = new Owner();
		owner.setId(1);
		owner.setName("krack");
		owner.setUser(DataInBase.getUser());
		return owner;
	}
}
