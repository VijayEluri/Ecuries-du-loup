package dao;

import java.util.List;

import donnees.User;
import fr.ecurie_du_loup.generique_util.dao.DaoIdStringUtil;

/**
 * Interface de gestion en base de donnée d'un utilisateur
 * @author Krack
 *
 */
public interface UserDAO extends DaoIdStringUtil<User>{

	public User getUserFacebook(String identifiantFacebook);
	
	public List<User> getUserBorn(int month, int day);
	
	public List<User> getAllUser(String usernamePatern);
}
