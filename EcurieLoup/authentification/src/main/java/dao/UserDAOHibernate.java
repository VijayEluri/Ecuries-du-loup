package dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import donnees.User;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdStringBySpringDao;

/**
 * Classe implémentant UserDAO pour la gestion en base de données de User<br />
 * Utilisation de hibernate pour la gestion de données conjointement à spring 
 * @author Krack
 *
 */
public class UserDAOHibernate extends HibernateIdStringBySpringDao<User> implements UserDAO {

	
	

	@Override
	public User getUserFacebook(String identifiantFacebook) {
		String requete = "SELECT u FROM User as u WHERE u.identifiantFacebook='"+identifiantFacebook+"'";
		List retour = this.getHibernateTemplate().find(requete);
		if(retour.isEmpty()){
			return null;
		}else{
			return (User) retour.get(0);
		}
	}
	@Override
	public List<User> getUserBorn(int month, int day) {
		List<User> users = this.findAll();
		
		List<User> usersBorn = new ArrayList<User>();
		
		for(User user : users){
			if(user.getBirthDate() != 0){
				Calendar birthDate = Calendar.getInstance();
				birthDate.setTimeInMillis(user.getBirthDate());
				if(
						month == (birthDate.get(Calendar.MONTH) +1 )
					&& day == (birthDate.get(Calendar.DAY_OF_MONTH))	
				){
					usersBorn.add(user);				
				}
			}
		}
		return usersBorn;
	}
	@Override
	public List<User> getAllUser(String usernamePatern) {
		String requete = "SELECT u FROM User as u WHERE u.login LIKE '"+usernamePatern+"'";
		return this.getHibernateTemplate().find(requete);
	}

}
