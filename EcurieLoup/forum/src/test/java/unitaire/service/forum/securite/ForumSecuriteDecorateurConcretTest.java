package unitaire.service.forum.securite;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import service.UtilisateurManager;
import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import forum.donnees.Categorie;
import forum.donnees.Message;
import forum.donnees.Topic;
import forum.service.ForumManager;
import forum.service.securite.ForumSecuriteDecorateurConcret;

public class ForumSecuriteDecorateurConcretTest {
	private UtilisateurManager utilisateurManager;
	private ForumManager forumManager;
	private ForumSecuriteDecorateurConcret forumSecuriteDecorateur;
	private User utilisateurCourant;

	@Before
	public void setUp() throws Exception {
		this.forumManager = EasyMock.createMock(ForumManager.class);
		this.utilisateurManager = EasyMock.createMock(UtilisateurManager.class);

		this.forumSecuriteDecorateur = new ForumSecuriteDecorateurConcret();
		this.forumSecuriteDecorateur.setForumManager(this.forumManager);
		this.forumSecuriteDecorateur.setUtilisateurManager(this.utilisateurManager);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	private User  placeRetourUtilisateurAvecDroitForum () {
		Set<Role> roles = new HashSet<Role>();
		Role role = new Role();
		role.setRole(RoleEnum.ROLE_ADMINISTRATEUR_FORUM.toString());
		roles.add(role);

		Role roleAuth = new Role();
		roleAuth.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
		roles.add(roleAuth);

		this.utilisateurCourant = new User();
		utilisateurCourant.setLogin("user courant");
		utilisateurCourant.setRoles(roles);

		EasyMock.expect(this.utilisateurManager.getUtilisateurCourant()).andReturn(utilisateurCourant);

		return utilisateurCourant;
	}

	private User  placeRetourUtilisateurSansDroitForum () {
		Set<Role> roles = new HashSet<Role>();

		Role roleAuth = new Role();
		roleAuth.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
		roles.add(roleAuth);

		User utilisateurCourant = new User();
		utilisateurCourant.setLogin("user courant");
		utilisateurCourant.setRoles(roles);

		EasyMock.expect(this.utilisateurManager.getUtilisateurCourant()).andReturn(utilisateurCourant);

		return utilisateurCourant;
	}

	

	@Test
	public void testCreerCategorieAvecDoitForum() {
		this.placeRetourUtilisateurAvecDroitForum();
		
		Categorie categorie = new Categorie();
		int id = (int) (Math.random()*10000);
		categorie.setId(id);

		this.forumManager.add(categorie);

	
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.add(categorie);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerCategorieSansDoitForum() {
		this.placeRetourUtilisateurSansDroitForum();
		
		Categorie categorie = new Categorie();
		int id = (int) (Math.random()*10000);
		categorie.setId(id);

		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.add(categorie);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerMessage() {
		
		Topic topic = new Topic();
		int idTopic = (int) (Math.random()*10000);
		topic.setId(idTopic);
		topic.setOuvert(true);
		
		Message message = new Message();
		int id = (int) (Math.random()*10000);
		message.setId(id);
		message.setTopic(topic);

		this.forumSecuriteDecorateur.add(message);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.add(message);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testCreerTopic() {
		
		Topic topic = new Topic();
		int idTopic = (int) (Math.random()*10000);
		topic.setId(idTopic);

		Message message = new Message();
		int idMessage = (int) (Math.random()*10000);
		message.setId(idMessage);

		

		this.forumManager.add(topic, message);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.add(topic, message);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierCategorieAvecDroitForum() {
		this.placeRetourUtilisateurAvecDroitForum();
		
		Categorie categorie = new Categorie();
		int id = (int) (Math.random()*10000);
		categorie.setId(id);

		this.forumManager.update(categorie);

		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.update(categorie);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierCategorieSansDroitForum() {
		this.placeRetourUtilisateurSansDroitForum();
		
		Categorie categorie = new Categorie();
		int id = (int) (Math.random()*10000);
		categorie.setId(id);

		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.update(categorie);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierMessageAvecDroitForum() {
		this.placeRetourUtilisateurAvecDroitForum();
		
		Message message = new Message();
		int id = (int) (Math.random()*10000);
		message.setId(id);
		User auteur = new User();
		auteur.setLogin("utilisateur auteur");
		message.setAuteur(auteur);

		

		this.forumManager.update(message);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.update(message);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierMessageSansDroitForumMaisAuteur() {
		User utilisateurCourant = this.placeRetourUtilisateurSansDroitForum();
		
		Message message = new Message();
		int id = (int) (Math.random()*10000);
		message.setId(id);
		message.setAuteur(utilisateurCourant);

		this.forumManager.update(message);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.update(message);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierMessageAvecDroitForumEtAuteur() {
		User utilisateurCourant = this.placeRetourUtilisateurAvecDroitForum();
		
		Message message = new Message();
		int id = (int) (Math.random()*10000);
		message.setId(id);
		message.setAuteur(utilisateurCourant);

		this.forumManager.update(message);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.update(message);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierMessageSansDroitForumEtAuteur() {
		this.placeRetourUtilisateurSansDroitForum();
		
		Message message = new Message();
		int id = (int) (Math.random()*10000);
		message.setId(id);
		User auteur = new User();
		auteur.setLogin("utilisateur auteur");
		message.setAuteur(auteur);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.update(message);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testModifierTopicAvecDroitForumSansCreateur() {
		this.placeRetourUtilisateurAvecDroitForum();
		
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		
		User createur = new User();
		createur.setLogin("utilisateur createur");
		topic.setCreateur(createur);

		
		this.forumManager.update(topic);

		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.update(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testModifierTopicSansDroitForumAvecCreateur() {
		User utilisateurCourant = this.placeRetourUtilisateurSansDroitForum();
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		topic.setCreateur(utilisateurCourant);
		
		this.forumManager.update(topic);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.update(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testModifierTopicAvecDroitForumEtCreateur() {
		User utilisateurCourant = this.placeRetourUtilisateurAvecDroitForum();
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);topic.setCreateur(utilisateurCourant);
		
		this.forumManager.update(topic);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.update(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testModifierTopicSansDroitForumEtCreateur() {
		this.placeRetourUtilisateurSansDroitForum();
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		User createur = new User();
		createur.setLogin("utilisateur createur");
		topic.setCreateur(createur);
	
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.update(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererCategorie() {
		
		Categorie categorie = new Categorie();
		int id = (int) (Math.random()*10000);
		categorie.setId(id);

		EasyMock.expect(this.forumManager.getCategorie(id)).andReturn(categorie);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		Categorie categorieRecuperer = this.forumSecuriteDecorateur.getCategorie(id);

		assertEquals(categorieRecuperer, categorie);
		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererMessage() {
		
		Message message = new Message();
		int id = (int) (Math.random()*10000);
		message.setId(id);

		EasyMock.expect(this.forumManager.getMessage(id)).andReturn(message);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		Message messageRecuperer = this.forumSecuriteDecorateur.getMessage(id);

		assertEquals(messageRecuperer, message);
		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererMessagesTopic() {
		
		int id = (int) (Math.random()*10000);
		List<Message> listeMessage = new ArrayList<Message>();
		for(int i = 0; i < 4; i++){
			Message message = new Message();
			int idMessage = (int) (Math.random()*10000);
			message.setId(idMessage);
			listeMessage.add(message);
		}
		EasyMock.expect(this.forumManager.getAllMessagesTopic(id)).andReturn(listeMessage);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);
		
		List<Message> listeMessageRecuperer = this.forumSecuriteDecorateur.getAllMessagesTopic(id);
		
		assertEquals(listeMessageRecuperer, listeMessage);
		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererTopic() {
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);

		EasyMock.expect(this.forumManager.getTopic(id)).andReturn(topic);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		Topic topicRecuperer = this.forumSecuriteDecorateur.getTopic(id);

		assertEquals(topicRecuperer, topic);
		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererTopicCategories() {
		
		int id = (int) (Math.random()*10000);
		List<Topic> listeTopic = new ArrayList<Topic>();
		for(int i = 0; i < 4; i++){
			Topic topic = new Topic();
			int idTopic = (int) (Math.random()*10000);
			topic.setId(idTopic);
			listeTopic.add(topic);
		}
		EasyMock.expect(this.forumManager.getAllTopicCategories(id)).andReturn(listeTopic);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);
		
		List<Topic> listeTopicRecuperer = this.forumSecuriteDecorateur.getAllTopicCategories(id);
		
		assertEquals(listeTopicRecuperer, listeTopic);
		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	@Test
	public void testRecupererToutesCategories() {
		
		List<Categorie> listeCategorie = new ArrayList<Categorie>();
		for(int i = 0; i < 4; i++){
			Categorie categorie = new Categorie();
			int idCategorie = (int) (Math.random()*10000);
			categorie.setId(idCategorie);
			listeCategorie.add(categorie);
		}
		EasyMock.expect(this.forumManager.getAllCategories()).andReturn(listeCategorie);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);
		
		List<Categorie> listeCategorieRecuperer = this.forumSecuriteDecorateur.getAllCategories();
		
		assertEquals(listeCategorieRecuperer, listeCategorie);
		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}

	
	@Test
	public void testFermerTopicAvecDroitForumSansCreateur() {
		this.placeRetourUtilisateurAvecDroitForum();
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		User createur = new User();
		createur.setLogin("utilisateur createur");
		topic.setCreateur(createur);
		topic.setOuvert(true);

		this.forumManager.fermerTopic(topic);

	
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.fermerTopic(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testFermerTopicSansDroitForumAvecCreateur() {
		User utilisateurCourant = this.placeRetourUtilisateurSansDroitForum();
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		topic.setOuvert(true);

		topic.setCreateur(utilisateurCourant);
		
		this.forumManager.fermerTopic(topic);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.fermerTopic(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testFermerTopicAvecDroitForumEtCreateur() {
		User utilisateurCourant = this.placeRetourUtilisateurAvecDroitForum();
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		topic.setOuvert(true);
		topic.setCreateur(utilisateurCourant);
		
		this.forumManager.fermerTopic(topic);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.fermerTopic(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testFermerTopicSansDroitForumEtCreateur() {
		this.placeRetourUtilisateurSansDroitForum();
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		topic.setOuvert(true);
		User createur = new User();
		createur.setLogin("utilisateur createur");
		topic.setCreateur(createur);
		

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.fermerTopic(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	

	
	@Test
	public void testOuvrirTopicAvecDroitForumSansCreateur() {
		this.placeRetourUtilisateurAvecDroitForum();
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		User createur = new User();
		createur.setLogin("utilisateur createur");
		topic.setCreateur(createur);
		topic.setOuvert(false);

		
		this.forumManager.ouvrirTopic(topic);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.ouvrirTopic(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testOuvrirTopicSansDroitForumAvecCreateur() {
		User utilisateurCourant = this.placeRetourUtilisateurSansDroitForum();
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		topic.setOuvert(false);
		topic.setCreateur(utilisateurCourant);
		
		this.forumManager.ouvrirTopic(topic);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.ouvrirTopic(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testOuvrirTopicAvecDroitForumEtCreateur() {
		User utilisateurCourant = this.placeRetourUtilisateurAvecDroitForum();
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		topic.setCreateur(utilisateurCourant);
		
		this.forumManager.ouvrirTopic(topic);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.ouvrirTopic(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testOuvrirTopicSansDroitForumEtCreateur() {
		this.placeRetourUtilisateurSansDroitForum();
		
		Topic topic = new Topic();
		int id = (int) (Math.random()*10000);
		topic.setId(id);
		topic.setOuvert(false);
		User createur = new User();
		createur.setLogin("utilisateur createur");
		topic.setCreateur(createur);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.ouvrirTopic(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testCreerMessageTopicFermer() {
		
		Topic topic = new Topic();
		int idTopic = (int) (Math.random()*10000);
		topic.setId(idTopic);
		topic.setOuvert(false);
		
		Message message = new Message();
		int id = (int) (Math.random()*10000);
		message.setId(id);
		message.setTopic(topic);

		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.add(message);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
	}
	
	@Test
	public void testSupprimerCategorieSansDroit(){
		this.placeRetourUtilisateurSansDroitForum();
		
		Categorie categorie = new Categorie();
		int id = (int) (Math.random()*10000);
		categorie.setId(id);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.delete(categorie);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
		
	}
	
	@Test
	public void testSupprimerCategorieAvecDroit(){
		this.placeRetourUtilisateurAvecDroitForum();
		
		Categorie categorie = new Categorie();
		int id = (int) (Math.random()*10000);
		categorie.setId(id);
		
		this.forumManager.delete(categorie);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.delete(categorie);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
		
	}
	
	@Test
	public void testSupprimerMessageSansDroit(){
		this.placeRetourUtilisateurSansDroitForum();
		
		Message message = new Message();
		int id = (int) (Math.random()*10000);
		message.setId(id);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.delete(message);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
		
	}
	
	@Test
	public void testSupprimerMessageAvecDroit(){
		this.placeRetourUtilisateurAvecDroitForum();
		
		Message message = new Message();
		int id = (int) (Math.random()*10000);
		message.setId(id);
		
		this.forumManager.delete(message);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.delete(message);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
		
	}
	
	@Test
	public void testSupprimerTopicSansDroit(){
		this.placeRetourUtilisateurSansDroitForum();
		
		Topic topic = new Topic();
		int idTopic = (int) (Math.random()*10000);
		topic.setId(idTopic);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.delete(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
		
	}
	
	@Test
	public void testSupprimerTopicAvecDroit(){
		this.placeRetourUtilisateurAvecDroitForum();
		
		Topic topic = new Topic();
		int idTopic = (int) (Math.random()*10000);
		topic.setId(idTopic);
		
		this.forumManager.delete(topic);
		
		EasyMock.replay(this.utilisateurManager);
		EasyMock.replay(this.forumManager);

		this.forumSecuriteDecorateur.delete(topic);

		EasyMock.verify(this.forumManager);
		EasyMock.verify(this.utilisateurManager);
		
	}
	
}
