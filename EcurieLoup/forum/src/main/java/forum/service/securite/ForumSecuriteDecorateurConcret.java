package forum.service.securite;

import java.util.List;

import service.UtilisateurManager;
import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import forum.donnees.Categorie;
import forum.donnees.Message;
import forum.donnees.Topic;

public class ForumSecuriteDecorateurConcret extends ForumSecuriteDecorateur {

	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	private boolean aDroitForum(User utilisateur){
		Role roleForum = new Role();
		roleForum.setRole(RoleEnum.ROLE_ADMINISTRATEUR_FORUM.toString());
		for(Role roleCompare : utilisateur.getRoles()){
			if(roleCompare.equals(roleForum)){
				return true;
			}
		}

		return false;
	}

	@Override
	public void add(Categorie categorie) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitForum(utilisateur)){
			this.forumManager.add(categorie);
		}

	}


	@Override
	public void add(Message message) {

		//TODO: gérér que on puise pas créé dans un topic d'une catégorie qu'on a pas les droits
		if(message.getTopic().isOuvert()){
			this.forumManager.add(message);
		}
	}

	@Override
	public void add(Topic topic, Message premierMessage) {
		//TODO: gérér que on puise pas créé dans une catégorie qu'on a pas les droits
		this.forumManager.add(topic, premierMessage);

	}

	@Override
	public void update(Categorie categorie) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(this.aDroitForum(utilisateur)){
			this.forumManager.update(categorie);
		}
	}

	@Override
	public void update(Message message) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(utilisateur.equals(message.getAuteur())){
			this.forumManager.update(message);
			//TODO: voir pour la modif de message que le mec aurait perdu les droits sur la catégorie du topic
		}else if(this.aDroitForum(utilisateur)){
			this.forumManager.update(message);
		}
	}

	@Override
	public void update(Topic topic) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(utilisateur.equals(topic.getCreateur())){
			this.forumManager.update(topic);
			//TODO:  voir pour les créateurs de sujet qui ont perdu les droit sur la catégorie les contenants
		}else if(this.aDroitForum(utilisateur)){
			this.forumManager.update(topic);
		}
	}

	@Override
	public Categorie getCategorie(long idCategorie) {
		//TODO: interfire si on a pas les droits sur la catégorie
		return this.forumManager.getCategorie(idCategorie);
	}

	@Override
	public Message getMessage(long idMessage) {
		return this.forumManager.getMessage(idMessage);
	}

	@Override
	public List<Message> getAllMessagesTopic(long topicDesMessages) {
		//TODO: interfire si on a pas les droits sur la catégorie du topic des messages
		return this.forumManager.getAllMessagesTopic(topicDesMessages);
	}

	@Override
	public Topic getTopic(long idTopic) {
		return this.forumManager.getTopic(idTopic);
	}

	@Override
	public List<Topic> getAllTopicCategories(int categorieDesTopics) {
		//TODO: interfire si on a pas les droits sur la catégorie
		return this.forumManager.getAllTopicCategories(categorieDesTopics);
	}

	@Override
	public List<Categorie> getAllCategories() {
		//TODO: viré les catégories dont on a pas les droits
		return this.forumManager.getAllCategories();
	}


	@Override
	public void fermerTopic(Topic topicOuvert) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(utilisateur.equals(topicOuvert.getCreateur())){
			this.forumManager.fermerTopic(topicOuvert);
			//TODO:  voir pour les créateurs de sujet qui ont perdu les droit sur la catégorie les contenants
		}else if(this.aDroitForum(utilisateur)){
			this.forumManager.fermerTopic(topicOuvert);
		}

	}


	@Override
	public void ouvrirTopic(Topic topicFermer) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();
		if(utilisateur.equals(topicFermer.getCreateur())){
			this.forumManager.ouvrirTopic(topicFermer);
			//TODO:  voir pour les créateurs de sujet qui ont perdu les droit sur la catégorie les contenants
		}else if(this.aDroitForum(utilisateur)){
			this.forumManager.ouvrirTopic(topicFermer);
		}
	}


	@Override
	public void delete(Categorie categorie) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();

		if(this.aDroitForum(utilisateur)){
			this.forumManager.delete(categorie);
		}
	}


	@Override
	public void delete(Message message) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();

		if(this.aDroitForum(utilisateur)){
			this.forumManager.delete(message);
		}
	}


	@Override
	public void delete(Topic topic) {
		User utilisateur = this.utilisateurManager.getUtilisateurCourant();

		if(this.aDroitForum(utilisateur)){
			this.forumManager.delete(topic);
		}
	}

	@Override
	public void lectureTopic(Topic topic) {
		this.forumManager.lectureTopic(topic);
	}

	@Override
	public boolean hasNouveauxMessages() {
		return this.forumManager.hasNouveauxMessages();
	}

	@Override
	public int getNombreNouveauxMessages() {
		return this.forumManager.getNombreNouveauxMessages();
	}

	@Override
	public List<Topic> recupererTopicAvecMessageNonLu() {
		return this.forumManager.recupererTopicAvecMessageNonLu();
	}

	@Override
	public Message getLastMessage() {
		return this.forumManager.getLastMessage();
	}


}
