package fiche_chevaux.donnees;

import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Surnom extends DataWtihLongIdAbstract<Surnom> implements DataWithLongId {
	private String surnom;
	private Fiche fiche;
	
	
	public void setId(long id) {
		this.id = id;
	}
	public String getSurnom() {
		return surnom;
	}
	public void setSurnom(String surnom) {
		this.surnom = surnom;
	}
	public Fiche getFiche() {
		return fiche;
	}
	public void setFiche(Fiche fiche) {
		this.fiche = fiche;
	}
	
	public String toString(){
		String toString = "---\nSurnom";
		
		toString+= "id : "+this.id+" \n";
		toString+= "id : "+this.surnom+" \n";
		toString+= "id : "+this.fiche.getId()+" \n";
		
		return toString;
	}	
}
