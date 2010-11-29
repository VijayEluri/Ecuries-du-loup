package fiche_chevaux.donnees;

import java.util.ArrayList;
import java.util.List;

import donnees.photo.Photo;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Fiche extends DataWtihLongIdAbstract<Fiche> implements DataWithLongId{
	private String nom;
	private Robe robe;
	private Race race;
	private Sexe sexe;
	private long dateNaissance;
	private int anneeNaissance;
	private Photo photoTete;
	private Photo photoCorps;
	private String description;
	private List<Surnom> surnoms;
	private Owner owner;
	
	public Fiche(){
		this.surnoms = new ArrayList<Surnom>();
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Robe getRobe() {
		return robe;
	}
	public void setRobe(Robe robe) {
		this.robe = robe;
	}
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}
	public long getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(long dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public int getAnneeNaissance() {
		return anneeNaissance;
	}
	public void setAnneeNaissance(int anneeNaissance) {
		this.anneeNaissance = anneeNaissance;
	}
	public Sexe getSexe() {
		return sexe;
	}
	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}
	public Photo getPhotoTete() {
		return photoTete;
	}
	public void setPhotoTete(Photo photoTete) {
		this.photoTete = photoTete;
	}
	public Photo getPhotoCorps() {
		return photoCorps;
	}
	public void setPhotoCorps(Photo photoCorps) {
		this.photoCorps = photoCorps;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Surnom> getSurnoms() {
		return surnoms;
	}
	public void setSurnoms(List<Surnom> surnoms) {
		this.surnoms = surnoms;
		while(this.surnoms.contains(null)){
			this.surnoms.remove(null);
		}
	}
	
	
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
}
