package fiche_chevaux.donnees;

import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public abstract class Choix<T extends DataWithLongId> extends DataWtihLongIdAbstract<T> implements DataWithLongId{
	
	private String nom;
	
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
}
