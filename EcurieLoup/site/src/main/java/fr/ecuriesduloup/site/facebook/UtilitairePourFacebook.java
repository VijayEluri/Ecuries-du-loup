package fr.ecuriesduloup.site.facebook;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import donnees.Role;

public class UtilitairePourFacebook {

	public static void forceConnexion(donnees.User utilisateur) {
		// on créé le tableau de role
		GrantedAuthority[] arrayAuths = new GrantedAuthority[utilisateur
				.getRoles().size()];
		int i = 0;
		for (Role role : utilisateur.getRoles()) {
			arrayAuths[i] = new GrantedAuthorityImpl(role.getRole());
			i++;
		}
		// fin de la création et instantiation du tableau de rôle
		User acegiUser = new User(utilisateur.getLogin(), utilisateur
				.getPassword(), utilisateur.isEnabled(), true, true, true,
				arrayAuths);

		Authentication authentication = new UsernamePasswordAuthenticationToken(
				acegiUser, null, arrayAuths);
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
	}
}
