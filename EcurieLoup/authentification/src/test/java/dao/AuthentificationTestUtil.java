package dao;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import donnees.Role;
import donnees.User;

public class AuthentificationTestUtil {

	
	public static User getNewObject() {
		Set<Role> roles = new HashSet<Role>();
		
		User utilisateur = new User();
		utilisateur.setLogin("utilisateur creer "+new Date().getTime()+" test");
		utilisateur.setPassword("test Password");
		utilisateur.setNom("nom bidon");
		utilisateur.setPrenom("prénom bidon");
		utilisateur.setEmail("emailBidon");
		utilisateur.setRoles(roles);
		utilisateur.setCreationDate(new Date(1236034800000l));
		utilisateur.setLastAccessDate(new Date(1247436000000l));
		utilisateur.setLastAccessDateNotifier(new Date().getTime());
		utilisateur.setEnabled(true);
		
		return utilisateur;
	}
	
	public static void modificationObject(User t) {
		t.setEmail("new@email.com");
		
	}
}
