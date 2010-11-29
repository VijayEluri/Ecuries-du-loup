package security;

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

/**
 * Permet de charger un user de manière "manuelle"
 * 
 * @author Krack
 * 
 */
public class UserDetailsServiceImpl implements UserDetailsService {
	private UtilisateurManager utilisateurManager;

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		String sauvUsername = username;
		
		username = username.toLowerCase();
		donnees.User utilisateur = this.utilisateurManager.getById(username);
		
		User acegiUser = null;
		if (utilisateur != null) {
			// on met a jour sa date d'accès
			utilisateur.setLastAccessDate(new Date());
			this.utilisateurManager.update(utilisateur);

		

			// on créé le tableau de role
			GrantedAuthority[] arrayAuths = new GrantedAuthority[utilisateur
					.getRoles().size()];
			int i = 0;
			for (Role role : utilisateur.getRoles()) {
				arrayAuths[i] = new GrantedAuthorityImpl(role.getRole());
				i++;
			}
			// fin de la création et instantiation du tableau de rôle
			acegiUser = new User(sauvUsername, utilisateur
					.getPassword(), utilisateur.isEnabled(), true, true, true,
					arrayAuths);
		}

		return acegiUser;
	}
	
	
}
