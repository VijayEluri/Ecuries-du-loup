package forum.donnees;

public class MessageLight {
	private long id;
	private long topic;
	private String auteur;
	private String contenu;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getTopic() {
		return topic;
	}
	public void setTopic(long topic) {
		this.topic = topic;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
}
