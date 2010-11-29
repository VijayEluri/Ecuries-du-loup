package donnees.photo;

import donnees.User;

public class LectureAlbum {
	private long id;
	
	private Album albumVu;
	private User utilisateur;
	private long heureLecture;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Album getAlbumVu() {
		return albumVu;
	}
	public void setAlbumVu(Album albumVu) {
		this.albumVu = albumVu;
	}
	public User getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
	public long getHeureLecture() {
		return heureLecture;
	}
	public void setHeureLecture(long heureLecture) {
		this.heureLecture = heureLecture;
	}
	
	
	
}
