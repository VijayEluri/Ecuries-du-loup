package forum.donnees;

import donnees.User;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Message extends DataWtihLongIdAbstract<Message> implements DataWithLongId{
	private Topic topic;
	private User auteur;
	private String contenu;
	private long datePostage;
	private long dateModification;
	
	
	public void setId(long id) {
		this.id = id;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public User getAuteur() {
		return auteur;
	}
	public void setAuteur(User auteur) {
		this.auteur = auteur;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public long getDatePostage() {
		return datePostage;
	}
	public void setDatePostage(long datePostage) {
		this.datePostage = datePostage;
	}
	public long getDateModification() {
		return dateModification;
	}
	public void setDateModification(long dateModification) {
		this.dateModification = dateModification;
	}
	
	@Override
	public String toString(){
		String messageEnString ="";
		
		messageEnString += "===== Message =====\n";
		messageEnString += "ID : "+this.id+"\n";
		messageEnString += "message : "+this.contenu+"\n";
		messageEnString += "Auteur : "+((this.auteur == null)? null :this.auteur.getLogin())+"\n";
		messageEnString += "Postage : "+this.datePostage+"\n";
		messageEnString += "Modification : "+this.dateModification+"\n";
		messageEnString += "Topic : "+this.topic.getId()+"\n";
		messageEnString += "===== Fin Message =====\n";
		
		return messageEnString;
	}
}
