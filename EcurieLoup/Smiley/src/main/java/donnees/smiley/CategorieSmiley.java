package donnees.smiley;

import java.util.ArrayList;
import java.util.List;

import fr.ecurie_du_loup.generique_util.type.DataOrdonner;


public class CategorieSmiley implements DataOrdonner{
	private long id;
	private String nom;
	private int ordre;
	private List<Smiley> smileys;
	public CategorieSmiley() {
		this.smileys = new ArrayList<Smiley>();
	}
	@Override
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
	@Override
	public int getOrdre() {
		return ordre;
	}
	@Override
	public void setOrdre(int ordre) {
		this.ordre = ordre;
	}
	public List<Smiley> getSmileys() {
		return smileys;
	}
	public void setSmileys(List<Smiley> smileys) {
		this.smileys = smileys;
		while(this.smileys.contains(null)){
			this.smileys.remove(null);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof CategorieSmiley)){
			return false;
		}
		CategorieSmiley categorieSmiley = (CategorieSmiley) obj;
		return categorieSmiley.id == this.id;
	}
	
	
}
