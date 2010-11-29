package forum.donnees;

import java.util.ArrayList;
import java.util.List;

import donnees.User;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Topic extends DataWtihLongIdAbstract<Topic> implements Comparable<Topic>, DataWithLongId{
	private Categorie categorie;
	private String titre;
	private boolean ouvert;
	private User createur;
	//TODO : voir sa!! ca n'a aucun sens un set :s
	private List<Message> messages;
	private Message dernierMessage;
	private Message premierMessageNonLu;
	private long dateLecture;
	
	public Topic(){
		this.messages = new ArrayList<Message>();
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public boolean isOuvert() {
		return ouvert;
	}
	public void setOuvert(boolean ouvert) {
		this.ouvert = ouvert;
	}
	
	public User getCreateur() {
		return createur;
	}
	public void setCreateur(User createur) {
		this.createur = createur;
	}
	
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
		//TODO : faire en sorte de ne pas avoir a géré sa :
		while(this.messages.contains(null)){
			this.messages.remove(null);
		}
	}
	
	
	
	public Message getDernierMessage() {
		return dernierMessage;
	}

	public void setDernierMessage(Message dernierMessage) {
		this.dernierMessage = dernierMessage;
	}

	public long getDateLecture() {
		return dateLecture;
	}

	public void setDateLecture(long dateLecture) {
		this.dateLecture = dateLecture;
	}

	public Message getPremierMessageNonLu() {
		return premierMessageNonLu;
	}

	public void setPremierMessageNonLu(Message premierMessageNonLu) {
		this.premierMessageNonLu = premierMessageNonLu;
	}

	@Override
	public String toString(){
		String topicEnString = "";
		topicEnString += "=====TOPIC====\n";
		topicEnString += "Id : "+this.id+"\n";
		topicEnString += "Titre : "+this.titre+"\n";
		topicEnString += "Ouvert : "+this.ouvert+"\n";
		topicEnString += "Categorie : "+((this.categorie == null)? null :this.categorie.getTitre())+"\n";
		topicEnString += "Messages : ["+this.messages+"}\n";
		topicEnString += "=====FIN TOPIC====\n";
		
		return topicEnString;
		
	}

	@Override
	public int compareTo(Topic o) {
		if(o.getDernierMessage() == null){
			return 1;
		}
		
		if(this.getDernierMessage() == null){
			return -1;
		}
		if(o.getDernierMessage().getDatePostage() > this.getDernierMessage().getDatePostage()){
			return 1;
		}else if(o.getDernierMessage().getDatePostage() == this.getDernierMessage().getDatePostage()){
			return 0;
		}else{
			return -1;
		}
	}	
}
