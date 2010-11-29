package service;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import dao.RoleDAO;
import dao.UserDAO;
import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoAndStringId;

/**
 * Implémentation de UtilisateurManager
 * @author Krack
 *
 */
public class UtilisateurManagerImpl extends DataBaseServiceWithDaoAndStringId<User> implements UtilisateurManager {

	private RoleDAO roleDAO;

	public void setRoleDAO(RoleDAO roleDAO){
		this.roleDAO = roleDAO;
	}


	@Override
	public void add(User user) {
		//on substring le pseudo
		user.setLogin(user.getLogin().toLowerCase());
		
		if(this.canBeAdded(user)){
			if(!user.getLogin().contains("'")){
				//il n'existe pas, donc on le créé
				Date maintenant = new Date();
		
				//on lui ajoute la date de création
				user.setCreationDate(maintenant);
		
				//on lui met sa dernière connexion à cette date
				user.setLastAccessDate(maintenant);
				//on ajoute le role de base (ROLE_AUTHENTIFIER)
				Role roleAuthentifier = this.roleDAO.getRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
	
				user.getRoles().add(roleAuthentifier);
		
				//TODO : retiré l'accès autorisé directement et le faire passé par une activation par email
				user.setEnabled(true);
		
		
				super.add(user);
			}	
		}
	}
	@Override
	public User getUtilisateurCourant() {
		try{
			//on récupère le contexte de ageci security
			SecurityContext securityContext = SecurityContextHolder.getContext();
			String search = "";
			try{
				org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)securityContext.getAuthentication().getPrincipal();
				search = user.getUsername();
			}catch(ClassCastException e){
				search = (String) securityContext.getAuthentication().getPrincipal();
			}
			//on retour l'utilisateur a partir du nom de celui du contexteageci
			return this.getById(search);
		}catch (NullPointerException e) {
			return null;
		}
	}

	@Override
	public User rechercheUtilisateurFacebook(String identifiantFacebook) {
		return ((UserDAO) this.dao).getUserFacebook(identifiantFacebook);
	}

	@Override
	public List<Role> recupererListeRole() {

		return this.roleDAO.getAllRole();
	}


	@Override
	public List<User> getAllUser(String usernamePatern) {
		usernamePatern = usernamePatern.replace('?', '_');
		usernamePatern = usernamePatern.replace('*', '%');
		return ((UserDAO)this.dao).getAllUser(usernamePatern);
	}
	
}
