package donnees.news;

import donnees.User;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;
/**
 * Classe de réprésentation d'une news
 * 
 * @author Krack
 *
 */
public class Nouvelle extends DataWtihLongIdAbstract<Nouvelle> implements DataWithLongId{
	private String titre;
	private String contenu;
	private User auteur;
	private long dateCreation;
	private long dateDerniereModification;

	
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public User getAuteur() {
		return auteur;
	}
	public void setAuteur(User auteur) {
		this.auteur = auteur;
	}
	public long getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(long dateCreation) {
		this.dateCreation = dateCreation;
	}
	public long getDateDerniereModification() {
		return dateDerniereModification;
	}
	public void setDateDerniereModification(long dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}

	public String toString(){
		String nouvelleEnString = "";

		nouvelleEnString += "========================\n";
		nouvelleEnString += this.id+" "+this.titre+"\n";
		if(this.auteur!=null){
			nouvelleEnString += "auteur : "+this.auteur.getLogin()+"\n";
		}
		nouvelleEnString += "creation : "+this.dateCreation+"\n";
		nouvelleEnString += "modification : "+this.dateDerniereModification+"\n";

		nouvelleEnString += this.contenu+"\n";
		nouvelleEnString += "========================";
		return nouvelleEnString;
	}
	
	
	public boolean equals(Nouvelle obj) {
		return this.id == obj.id;
		
		
	
	}
}
