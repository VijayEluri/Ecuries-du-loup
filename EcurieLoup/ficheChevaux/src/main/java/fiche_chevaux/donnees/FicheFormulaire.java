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
    private Media photoCorps;
    private String description;
    private List<String> surnoms;
    private String owner;
    private long category;

    public FicheFormulaire() {
	this.photoCorps = new Media();
    }

    public long getId() {
	return this.id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getNom() {
	return this.nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public boolean isEstDateNaissanceChoisi() {
	return this.estDateNaissanceChoisi;
    }

    public void setEstDateNaissanceChoisi(boolean estDateNaissanceChoisi) {
	this.estDateNaissanceChoisi = estDateNaissanceChoisi;
    }

    public long getDateNaissance() {
	return this.dateNaissance;
    }

    public void setDateNaissance(long dateNaissance) {
	this.dateNaissance = dateNaissance;
    }

    public int getAnneeNaissance() {
	return this.anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
	this.anneeNaissance = anneeNaissance;
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public List<String> getSurnoms() {
	return this.surnoms;
    }

    public void setSurnoms(List<String> surnoms) {
	this.surnoms = surnoms;
    }

    public Robe getRobe() {
	return this.robe;
    }

    public void setRobe(Robe robe) {
	this.robe = robe;
    }

    public Race getRace() {
	return this.race;
    }

    public void setRace(Race race) {
	this.race = race;
    }

    public Sexe getSexe() {
	return this.sexe;
    }

    public void setSexe(Sexe sexe) {
	this.sexe = sexe;
    }

    public Media getPhotoCorps() {
	return this.photoCorps;
    }

    public void setPhotoCorps(Media photoCorps) {
	this.photoCorps = photoCorps;
    }

    public String getOwner() {
	return this.owner;
    }

    public void setOwner(String owner) {
	this.owner = owner;
    }

    public long getCategory() {
	return this.category;
    }

    public void setCategory(long category) {
	this.category = category;
    }

}
