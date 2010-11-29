package integration;

import java.util.HashSet;
import java.util.Set;

import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import donnees.news.Nouvelle;
public class NewsInBase {
	


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
	
	public static Nouvelle getNouvelle(){
		Nouvelle nouvelle = new Nouvelle();
		nouvelle.setId(1);
		nouvelle.setTitre("titre de la nouvelle in base");
		nouvelle.setAuteur(UserInBase.getUtilisateurSansDroit());
		nouvelle.setContenu("contenu de la nouvelle in base");
		nouvelle.setDateCreation(123456789);
		nouvelle.setDateDerniereModification(0);
		return nouvelle;
	}

}
