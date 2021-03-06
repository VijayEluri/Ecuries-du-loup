package integration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import forum.donnees.Categorie;
import forum.donnees.Message;
import forum.donnees.Topic;

public class ForumInBase {
	public static List<Categorie> getCatergories(){
		List<Categorie> categoriesInBase = new ArrayList<Categorie>();

		{
			Categorie categorie = new Categorie();

			categorie.setId(1);
			categorie.setTitre("titre de la categorie");
			categorie.setDescription("description de la categorie");

			categoriesInBase.add(categorie);
		}

		return categoriesInBase;
	}

	public static Categorie getCatergorie(){
		Categorie categorie = new Categorie();

		categorie.setId(1);
		categorie.setTitre("titre de la categorie");
		categorie.setDescription("description de la categorie");
		categorie.setRoleAutoriser(new HashSet<Role>());
		return categorie;
	}

	public static Topic getTopic(){
		Topic topic = new Topic();

		topic.setId(1);
		topic.setTitre("titre topic");
		topic.setCategorie(ForumInBase.getCatergorie());
		topic.setCreateur(UserInBase.getUtilisateurToutDroit());
		topic.setOuvert(true);
		return topic;
	}

	public static List<Topic> getTopics(){
		List<Topic> topicsInBase = new ArrayList<Topic>();

		topicsInBase.add(ForumInBase.getTopic());

		return topicsInBase;
	}

	public static Message getMessage() {
		Message message = new Message();
		message.setId(1);
		message.setContenu("contenu ajouter");
		message.setAuteur(UserInBase.getUtilisateurToutDroit());
		message.setDateModification(0);
		message.setDatePostage(123456789);
		message.setTopic(ForumInBase.getTopic());

		return message;
	}

	public static User getUtilisateurToutDroit(){
		User user = new User();
		user.setLogin("krack");

		Set<Role> roles = new HashSet<Role>();

		Role roleAuth = new Role();
		roleAuth.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
		roles.add(roleAuth);

		Role roleForum = new Role();
		roleForum.setRole(RoleEnum.ROLE_ADMINISTRATEUR_FORUM.toString());
		roles.add(roleForum);

		user.setRoles(roles);
		return user;
	}
	
	public static User getUtilisateurSansDroit(){
		User user = new User();
		user.setLogin("loulou");

		return user;
	}

	public static List<Message> getMessages() {
		List<Message> topicsInBase = new ArrayList<Message>();

		topicsInBase.add(ForumInBase.getMessage());

		return topicsInBase;
	}


}
