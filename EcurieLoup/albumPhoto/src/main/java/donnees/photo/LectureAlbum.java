package donnees.photo;

import donnees.User;

public class LectureAlbum {
	private long id;
	
	private Media mediaVu;
	private User utilisateur;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	public Media getMediaVu() {
		return mediaVu;
	}
	public void setMediaVu(Media mediaVu) {
		this.mediaVu = mediaVu;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
	
	
}
