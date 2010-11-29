package security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import service.UtilisateurManager;
import donnees.Role;


public class UserDetailsServiceBasicImpl implements UserDetailsService {

	private Collection<Character> charactersWithAccent;

	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public UserDetailsServiceBasicImpl(){
		this.charactersWithAccent = new ArrayList<Character>();
		this.charactersWithAccent.add('a');
		this.charactersWithAccent.add('e');
		this.charactersWithAccent.add('i');
		this.charactersWithAccent.add('o');
		this.charactersWithAccent.add('u');
		this.charactersWithAccent.add('y');
	}

	@Override
	public UserDetails loadUserByUsername(String username)
	throws UsernameNotFoundException, DataAccessException {
		username = username.toLowerCase();
		donnees.User utilisateur = this.utilisateurManager.getById(username);

		this.updateLastAccessDate(utilisateur);
		
		User acegiUser = this.manageUser(utilisateur);
		if (acegiUser == null) {
			for(Character c : this.charactersWithAccent){
				username = username.replace(c, '?');
			}
			Collection<donnees.User> users = this.utilisateurManager.getAllUser(username);

			for(donnees.User user : users){
				acegiUser = this.manageUser(user);
				if(acegiUser != null){
					return acegiUser;
				}
			}
		}
		return acegiUser;
	}
	
	private void updateLastAccessDate(donnees.User user){
		user.setLastAccessDateNotifier(new Date().getTime());
		this.utilisateurManager.update(user);
	}

	private User manageUser(donnees.User user){
		User acegiUser = null;
		if(user != null){
			if(!user.getRoles().isEmpty()){
				acegiUser = new User(user.getLogin(), user.getPassword(), 
						user.isEnabled(), true, true, true,
						this.getRoleSpringSecurity(user));
			}
		}
		return acegiUser;

	}

	private Collection<GrantedAuthority> getRoleSpringSecurity(donnees.User user){

		// on créé le tableau de role
		Collection<GrantedAuthority> arrayAuths = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			arrayAuths.add(new GrantedAuthorityImpl(role.getRole()));
		}

		return arrayAuths;
	}
}
