package forum.donnees;

public class TopicNouveau {
	private long id;
	private long idCategorie;
	private String titre;
	private String Contenu;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdCategorie() {
		return idCategorie;
	}
	public void setIdCategorie(long idCategorie) {
		this.idCategorie = idCategorie;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return Contenu;
	}
	public void setContenu(String contenu) {
		Contenu = contenu;
	}
}
