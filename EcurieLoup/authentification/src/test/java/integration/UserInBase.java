package integration;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import donnees.Role;
import donnees.RoleEnum;
import donnees.User;

public class UserInBase {

    public static User getUtilisateurToutDroit() {
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

    public static User getUtilisateurSansDroit() {
	// TODO : rajouté date
	User user = new User();
	user.setLogin("loulou");
	user.setPassword("loulou445");
	user.setNom("Bourny");
	user.setPrenom("Louise");
	user.setEmail("trucmuse@truc.fr");
	user.setEnabled(true);
	user.setIdentifiantFacebook(null);
	// 2009-03-03 00:00:00.0
	user.setCreationDate(new Date(1236034800000l));
	// 2009-07-13 00:00:00.0
	user.setLastAccessDate(new Date(1247436000000l));

	Set<Role> roles = new HashSet<Role>();

	Role roleAuth = new Role();
	roleAuth.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
	roles.add(roleAuth);

	user.setRoles(roles);
	return user;
    }

}
