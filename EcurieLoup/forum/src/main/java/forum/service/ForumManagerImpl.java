package forum.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import service.UtilisateurManager;
import donnees.User;
import forum.donnees.Categorie;
import forum.donnees.Message;
import forum.donnees.Topic;

public class ForumManagerImpl implements ForumManager{
	private CategorieManager categorieManager;
	private TopicManager topicManager;
	private MessageManager messageManager;
	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public void setCategorieManager(CategorieManager categorieManager) {
		this.categorieManager = categorieManager;
	}

	public void setTopicManager(TopicManager topicManager) {
		this.topicManager = topicManager;
	}

	public void setMessageManager(MessageManager messageManager) {
		this.messageManager = messageManager;
	}

	@Override
	public void add(Categorie categorie) {
		this.categorieManager.add(categorie);

	}

	@Override
	public void add(Topic topic, Message firstMessage) {
		this.topicManager.add(topic);
		this.messageManager.add(firstMessage);

	}

	@Override
	public void add(Message message) {
		this.messageManager.add(message);		
	}

	@Override
	public void delete(Categorie categorie) {
		for(Topic topic : categorie.getTopics()){
			this.delete(topic);
		}
		this.categorieManager.delete(categorie);

	}

	@Override
	public void delete(Topic topic) {
		for(Message message : topic.getMessages()){
			this.delete(message);
		}
		this.topicManager.delete(topic);

	}

	@Override
	public void delete(Message message) {
		this.messageManager.delete(message);
	}

	@Override
	public void fermerTopic(Topic topicOuvert) {
		topicOuvert.setOuvert(false);
		this.topicManager.update(topicOuvert);
	}

	@Override
	public List<Categorie> getAllCategories() {
		List<Categorie> categories = this.categorieManager.getAll();
		this.remplirCategorie(categories);
		return categories;
	}
	private void remplirCategorie(List<Categorie> categories){
		for(Categorie categorie : categories){
			this.remplirTopic( categorie.getTopics(), this.utilisateurManager.getUtilisateurCourant());
		}
	}
	private void remplirTopic(List<Topic> topics, User utilisateurConnecte){

		for(Topic topic : topics) {
			this.remplirTopic(topic, utilisateurConnecte);
		}

	}
	private void remplirTopic(Topic topic, User connectedUser){
		if(topic != null){
			Message message = this.topicManager.getLastMessage(topic);
			topic.setDernierMessage(message);
				
			long dateLecture = this.topicManager.getReadingDate(topic, connectedUser);
			topic.setDateLecture(dateLecture);
			
			Message messageNonLu = this.topicManager.getFirtstMessageNotRead(topic, connectedUser);
			topic.setPremierMessageNonLu(messageNonLu);
		}

	}

	@Override
	public List<Message> getAllMessagesTopic(long topicDesMessages) {
		
		//FIXME
		return this.topicManager.getById(topicDesMessages).getMessages();
	}
	

	@Override
	public List<Topic> getAllTopicCategories(int categorieDesTopics) {
		
		User utilisateurConnecte = this.utilisateurManager.getUtilisateurCourant();
		List<Topic> ensembleTopic = this.getCategorie(categorieDesTopics).getTopics();
		this.remplirTopic(ensembleTopic, utilisateurConnecte);
		this.orderByPostageDernierMessage(ensembleTopic);
		return this.retireNull(ensembleTopic);
		
	}
	
	private void orderByPostageDernierMessage(List<Topic> ensembleTopic) {
		Collections.sort(ensembleTopic);

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

	@Override
	public Categorie getCategorie(long idCategorie) {
		return this.categorieManager.getById(idCategorie);
	}

	@Override
	public Message getMessage(long idMessage) {
		return this.messageManager.getById(idMessage);
	}

	@Override
	public int getNombreNouveauxMessages() {
		User utilisateurConnecte = this.utilisateurManager.getUtilisateurCourant();
		return this.categorieManager.countNewMessage(utilisateurConnecte);

	}

	@Override
	public Topic getTopic(long idTopic) {
		Topic topic = this.topicManager.getById(idTopic);
		User connectedUser = this.utilisateurManager.getUtilisateurCourant();
		this.remplirTopic(topic, connectedUser);
		return topic;
	}

	
	@Override
	public boolean hasNouveauxMessages() {
		boolean hasNouveauMessage = false;

		List<Categorie> categories= this.getAllCategories();
		for(Categorie categorie : categories){
			if(categorie.isTopicNonLu()){
				hasNouveauMessage = true;
				break;
			}
		}
		return hasNouveauMessage;
	}

	@Override
	public void lectureTopic(Topic topic) {
		User utilisateurConnecte = this.utilisateurManager.getUtilisateurCourant();
		this.topicManager.readTopic(topic, utilisateurConnecte);

	}

	@Override
	public void ouvrirTopic(Topic topicFermer) {
		topicFermer.setOuvert(true);
		this.topicManager.update(topicFermer);

	}

	@Override
	public List<Topic> recupererTopicAvecMessageNonLu() {
		List<Topic> topicsNonLu = new ArrayList<Topic>();
		for(Categorie categorie : this.getAllCategories()){
			topicsNonLu.addAll(categorie.getTopicNonLu());
		
		}
		return topicsNonLu;
	}

	@Override
	public void update(Categorie categorie) {
		this.categorieManager.update(categorie);

	}

	@Override
	public void update(Topic topic) {
		this.topicManager.update(topic);
	}

	@Override
	public void update(Message message) {
		this.messageManager.update(message);
	}

	@Override
	public Message getLastMessage() {
		return this.messageManager.getLastMessage();
	}

}
