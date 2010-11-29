package fr.ecuriesduloup.ws.user;

import java.util.Collection;

import donnees.Role;
import donnees.User;

public interface UserService {
	public Collection<Role> getRolesOfConnectedUser();
	public User getCurrentUser();
}
