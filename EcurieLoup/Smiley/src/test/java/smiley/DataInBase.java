package smiley;

import java.util.HashSet;
import java.util.Set;

import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import donnees.smiley.CategorieSmiley;
import donnees.smiley.Smiley;

public class DataInBase {

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

	Set<Role> roles = new HashSet<Role>();

	Role roleAuth = new Role();
	roleAuth.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
	roles.add(roleAuth);

	user.setRoles(roles);
	return user;
    }

    public static CategorieSmiley getCategorieSmiley() {
	CategorieSmiley categorieSmiley = new CategorieSmiley();
	categorieSmiley.setId(1);
	categorieSmiley.setNom("nom de la categorie de test");
	categorieSmiley.setOrdre(1);
	return categorieSmiley;
    }

    public static Smiley getSmiley() {
	Smiley smiley = new Smiley();
	smiley.setId(1);
	smiley.setCode("code pour ");
	smiley.setCategorieSmiley(DataInBase.getCategorieSmiley());
	smiley.setOrdre(1);
	return smiley;
    }
}
