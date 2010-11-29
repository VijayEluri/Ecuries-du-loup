package forum.donnees;

import donnees.User;

public class DernierPost {
	private long id;
	private User posteur;
	private long datePostage;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getPosteur() {
		return posteur;
	}
	public void setPosteur(User posteur) {
		this.posteur = posteur;
	}
	public long getDatePostage() {
		return datePostage;
	}
	public void setDatePostage(long datePostage) {
		this.datePostage = datePostage;
	}
}
