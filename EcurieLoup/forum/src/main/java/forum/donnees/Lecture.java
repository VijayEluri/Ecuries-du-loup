package forum.donnees;

import donnees.User;

public class Lecture {
	private long id;
	
	private Topic topicLu;
	private User utilisateur;
	private long heureLecture;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Topic getTopicLu() {
		return topicLu;
	}
	public void setTopicLu(Topic topicLu) {
		this.topicLu = topicLu;
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
