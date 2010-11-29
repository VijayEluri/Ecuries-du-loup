package dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import donnees.Role;
import donnees.User;

public class AuthentificationTestUtil {

	
	public static void compareJUnit(User utilisateur1, User utilisateur2) {
		assertEquals(utilisateur1.getLogin(), utilisateur2.getLogin());

		assertEquals(utilisateur1.getPassword(), utilisateur2.getPassword());

		assertEquals(utilisateur1.getEmail(), utilisateur2.getEmail());
		assertEquals(utilisateur1.getNom(), utilisateur2.getNom());
		assertEquals(utilisateur1.getPrenom(), utilisateur2.getPrenom());

	//	assertEquals(utilisateur1.getCreationDate(), utilisateur2.getCreationDate());
	//	assertEquals(utilisateur1.getLastAccessDate(), utilisateur2.getLastAccessDate());

		assertEquals(utilisateur1.isEnabled(), utilisateur2.isEnabled());


		for(Role role : utilisateur1.getRoles()){
			boolean estDedant = false;
			for(Role r2 : utilisateur2.getRoles()){
				if(role.equals(r2)){
					estDedant = true;
				}
			}
			assertTrue(estDedant);
		}

		for(Role role : utilisateur2.getRoles()){
			boolean estDedant = false;
			for(Role r2 : utilisateur1.getRoles()){
				if(role.equals(r2)){
					estDedant = true;
				}
			}
			assertTrue(estDedant);
		}
		
	}
	
	public static User getNewObject() {
		Set<Role> roles = new HashSet<Role>();
		
		User utilisateur = new User();
		utilisateur.setLogin("utilisateur creer "+new Date().getTime()+" test");
		utilisateur.setPassword("test Password");
		utilisateur.setNom("nom bidon");
		utilisateur.setPrenom("prénom bidon");
		utilisateur.setEmail("emailBidon");
		utilisateur.setRoles(roles);
		utilisateur.setCreationDate(new Date());
		utilisateur.setLastAccessDate(new Date());
		utilisateur.setLastAccessDateNotifier(new Date().getTime());
		utilisateur.setEnabled(true);
		
		return utilisateur;
	}
	
	public static void modificationObject(User t) {
		t.setEmail("new@email.com");
		
	}
}
