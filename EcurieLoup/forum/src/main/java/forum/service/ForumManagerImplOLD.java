/*package forum.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import service.UtilisateurManager;
import donnees.User;
import forum.dao.ForumDAO;
import forum.donnees.Categorie;
import forum.donnees.Message;
import forum.donnees.Topic;

public class ForumManagerImplOLD implements ForumManager {
	


	
	private void remplirCategorie(List<Categorie> categories){
		for(Categorie categorie : categories){
			this.remplirTopic( categorie.getTopics(), this.utilisateurManager.getUtilisateurCourant());
		}
	}
	@Override
	public List<Topic> recupererTopicCategories(int categorieDesTopics) {
		User utilisateurConnecte = this.utilisateurManager.getUtilisateurCourant();
		//List<Topic> ensembleTopic = this.forumDAO.getCategorie(categorieDesTopics).getTopics();
		List<Topic> ensembleTopic = this.forumDAO.getTopicsCatgeries(categorieDesTopics);
		this.remplirTopic(ensembleTopic, utilisateurConnecte);
		this.orderByPostageDernierMessage(ensembleTopic);
		return this.retireNull(ensembleTopic);
	}

	private void orderByPostageDernierMessage(List<Topic> ensembleTopic) {
		Collections.sort(ensembleTopic);

		
	}


	private void remplirTopic(List<Topic> topics, User utilisateurConnecte){

		for(Topic topic : topics) {
			this.remplirTopic(topic, utilisateurConnecte);
		}

	}
	
	private void remplirTopic(Topic topic, User utilisateurConnecte){
		if(topic != null){
			Message message = this.forumDAO.getLastMessage(topic);
			topic.setDernierMessage(message);
				
			long dateLecture = this.forumDAO.getDateLecture(topic, utilisateurConnecte);
			topic.setDateLecture(dateLecture);
			
			Message messageNonLu = this.forumDAO.getPremierMessageNonLu(topic, utilisateurConnecte);
			topic.setPremierMessageNonLu(messageNonLu);
		}

	}

	private List<Topic> retireNull(List<Topic> topics){
		List<Topic> topicsNonNull = new ArrayList<Topic>();

		for(Topic topic : topics) {
			if(topic != null){
				topicsNonNull.add(topic);
			}
		}

		return topicsNonNull;
	}



	//TODO : trier par date de dernière ajout
	/*private List<Topic> miseEnOrdreDuSetDansListParID(List<Topic> ensembleTopic){
		List<Topic> listeDesTopicsCategorie = new ArrayList<Topic>();


		for(Topic topic : ensembleTopic){
			boolean add = false;
			for(int i = 0; !add && i < listeDesTopicsCategorie.size(); i++){
				if(this.estPlusVieu(topic, listeDesTopicsCategorie.get(i))){
					listeDesTopicsCategorie.add(i, topic);
					add = true;
				}
			}
			if(!add){
				listeDesTopicsCategorie.add(topic);
			}
		}
		return listeDesTopicsCategorie;
	}*/

	/*private boolean estPlusVieu(Topic topic1, Topic topic2){
		if(topic1.getId() < topic2.getId()){
			return true;
		}else{
			return false;
		}
	}*/
/*
	@Override
	public List<Message> recupererMessagesTopic(long topicDesMessages) {

		Set<Message> ensembleMessage = this.forumDAO.getTopic(topicDesMessages).getMessages();

		return this.ordonneSetMessageParDate(ensembleMessage);
	}

	private List<Message> ordonneSetMessageParDate(Set<Message> ensembleMessage){
		List<Message> listeDesMessagesCategorie = new ArrayList<Message>();

		//TODO: trier par ordre de postage
		for(Message message : ensembleMessage){
			boolean messageAjouterAListe = false;

			for(int i = 0; !messageAjouterAListe && i < listeDesMessagesCategorie.size();i++){
				if(this.estPlusVieu(message, listeDesMessagesCategorie.get(i))){
					listeDesMessagesCategorie.add(i, message);
					messageAjouterAListe = true;
				}
			}
			if(!messageAjouterAListe){
				listeDesMessagesCategorie.add(message);
			}
		}

		return listeDesMessagesCategorie;	
	}

	private boolean estPlusVieu(Message message1, Message message2){
		if(message1.getDatePostage() < message2.getDatePostage()){
			return true;
		}else{
			return false;
		}
	}
	

	@Override
	public Topic recupererTopic(long idTopic) {
		User utilisateurConnecte = this.utilisateurManager.getUtilisateurCourant();
		Topic topic = this.forumDAO.getTopic(idTopic);
		this.remplirTopic(topic, utilisateurConnecte);
		return topic;
	}

	

	@Override
	public void supprimerCategorie(Categorie categorie) {
		for(Topic topic : categorie.getTopics()){
			this.supprimerTopic(topic);
		}
		this.forumDAO.delete(categorie);

	}



	@Override
	public void supprimerTopic(Topic topic) {
		if(topic != null){
			for(Message message : topic.getMessages()){
				this.supprimerMessage(message);
			}
			this.forumDAO.delete(topic);
		}
	}

	@Override
	public void lectureTopic(Topic topic) {
		User utilisateurConnecte = this.utilisateurManager.getUtilisateurCourant();
		this.forumDAO.lectureTopic(topic, utilisateurConnecte);
		
	}


	


	@Override
	public int getNombreNouveauxMessages() {
		User utilisateurConnecte = this.utilisateurManager.getUtilisateurCourant();
		return this.forumDAO.getNombreNouveauxMessage(utilisateurConnecte);
	}


	@Override
	public List<Topic> recupererTopicAvecMessageNonLu() {
		List<Topic> topicsNonLu = new ArrayList<Topic>();
		for(Categorie categorie : this.recupererToutesCategories()){
			topicsNonLu.addAll(categorie.getTopicNonLu());
		
		}
		return topicsNonLu;
	}
}*/
