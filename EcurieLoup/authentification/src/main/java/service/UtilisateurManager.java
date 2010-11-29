package service;

import java.util.List;

import donnees.Role;
import donnees.User;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithStringId;


public interface UtilisateurManager extends DataBaseServiceWithStringId<User>{

	

	public User rechercheUtilisateurFacebook(String identifiantFacebook);

	public User getUtilisateurCourant();

	
	@Override
	public void add(User t);

	public List<Role> recupererListeRole();
	
	public List<User> getAllUser(String usernamePatern);

}
