package integration;

import java.awt.Event;
import java.util.HashSet;
import java.util.Set;

import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;

public class EventInBase {
	

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
	
	public static TypeEvenement getTypeEvent(){
		TypeEvenement typeEvent = new TypeEvenement();
		typeEvent.setId(1);
		typeEvent.setNom("type Evenement Test");
		typeEvent.setDescription("Ba voila la superbe description");
		typeEvent.setCouleur("#123123");
		
		return typeEvent;
		
	}
	
	public static Evenement getEvent(){
		Evenement event = new Evenement();
		event.setId(1);
		event.setDescription("evenement de test");
		event.setDate(1254158848362l);
		event.setTypeEvenement(EventInBase.getTypeEvent());
		return event;
	}



}
