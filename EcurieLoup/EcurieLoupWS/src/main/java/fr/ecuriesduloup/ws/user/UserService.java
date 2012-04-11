package fr.ecuriesduloup.ws.user;

import java.util.Collection;
import java.util.List;

import donnees.Role;
import donnees.User;

public interface UserService {
	public List<SuggestListItem> getItemSuggestList();
	public Collection<Role> getRolesOfConnectedUser();
	public User getCurrentUser();
	public User getUserByLogin(String login);
}
