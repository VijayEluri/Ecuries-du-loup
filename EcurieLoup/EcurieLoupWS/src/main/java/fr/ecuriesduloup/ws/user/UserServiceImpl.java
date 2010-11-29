package fr.ecuriesduloup.ws.user;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.UtilisateurManager;
import donnees.Role;
import donnees.User;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UtilisateurManager utilisateurManager;
	
	@Override
	public Collection<Role> getRolesOfConnectedUser() {
		User user = this.getCurrentUser();
		return user.getRoles();
	}

	@Override
	public User getCurrentUser() {
		return this.utilisateurManager.getUtilisateurCourant();
	}

}
