package fiche_chevaux.donnees;

import java.util.List;

import donnees.photo.Media;


public class FicheFormulaire {
	private long id;
	private String nom;
	private Robe robe;
	private Race race;
	private Sexe sexe;
	private boolean estDateNaissanceChoisi;
	private long dateNaissance;
	private int anneeNaissance;
	private Media photoTete;
	private Media photoCorps;
	private String description;
	private List<String> surnoms;
	private String owner;
	
	public FicheFormulaire() {
		this.photoCorps = new Media();
		this.photoTete = new Media();
	}
	public long getId() {
		return id;
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
	
	
	public boolean isEstDateNaissanceChoisi() {
		return estDateNaissanceChoisi;
	}
	public void setEstDateNaissanceChoisi(boolean estDateNaissanceChoisi) {
		this.estDateNaissanceChoisi = estDateNaissanceChoisi;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getSurnoms() {
		return surnoms;
	}
	public void setSurnoms(List<String> surnoms) {
		this.surnoms = surnoms;
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
	public Sexe getSexe() {
		return sexe;
	}
	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}
	public Media getPhotoTete() {
		return photoTete;
	}
	public void setPhotoTete(Media photoTete) {
		this.photoTete = photoTete;
	}
	public Media getPhotoCorps() {
		return photoCorps;
	}
	public void setPhotoCorps(Media photoCorps) {
		this.photoCorps = photoCorps;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
