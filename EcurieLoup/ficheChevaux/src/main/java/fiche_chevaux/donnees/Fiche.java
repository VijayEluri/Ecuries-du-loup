package fiche_chevaux.donnees;

import java.util.ArrayList;
import java.util.List;

import donnees.photo.Media;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Fiche extends DataWtihLongIdAbstract<Fiche> implements DataWithLongId {
    private String nom;
    private Robe robe;
    private Race race;
    private Sexe sexe;
    private long dateNaissance;
    private int anneeNaissance;
    private Media photo;
    private String description;
    private List<Surnom> surnoms;
    private Owner owner;
    private Category category;

    public Fiche() {
	this.surnoms = new ArrayList<Surnom>();
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

    public Sexe getSexe() {
	return this.sexe;
    }

    public void setSexe(Sexe sexe) {
	this.sexe = sexe;
    }

    public Media getPhoto() {
	return this.photo;
    }

    public void setPhoto(Media photo) {
	this.photo = photo;
    }

    public String getDescription() {
	return this.description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public List<Surnom> getSurnoms() {
	return this.surnoms;
    }

    public void setSurnoms(List<Surnom> surnoms) {
	this.surnoms = surnoms;
	while (this.surnoms.contains(null)) {
	    this.surnoms.remove(null);
	}
    }

    public Owner getOwner() {
	return this.owner;
    }

    public void setOwner(Owner owner) {
	this.owner = owner;
    }

    public Category getCategory() {
	return this.category;
    }

    public void setCategory(Category category) {
	this.category = category;
    }

}
