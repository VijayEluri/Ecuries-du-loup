package donnees.calendrier;

import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class TypeEvenement  extends DataWtihLongIdAbstract<TypeEvenement>  implements DataWithLongId{
	private String nom;
	private String description;
	private String couleur;
	private String urlJspView;
	private boolean permanent;
	
	public TypeEvenement() {
		this.urlJspView = "";
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public String getUrlJspView() {
		return urlJspView;
	}
	public void setUrlJspView(String urlJspView) {
		this.urlJspView = urlJspView;
	}
	
	
	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}
}
