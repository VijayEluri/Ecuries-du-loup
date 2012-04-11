package fr.ecuriesduloup.ws.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import service.UtilisateurManager;
import donnees.Role;
import donnees.User;
import fiche_chevaux.donnees.Fiche;
import fiche_chevaux.service.FicheChevauxManager;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UtilisateurManager utilisateurManager;
	@Autowired
	@Qualifier("ficheChevauxManager")
	private FicheChevauxManager horseManager;
	
	@Override
	public Collection<Role> getRolesOfConnectedUser() {
		User user = this.getCurrentUser();
		return user.getRoles();
	}

	@Override
	public User getCurrentUser() {
		return this.utilisateurManager.getUtilisateurCourant();
	}

	@Override
	public List<SuggestListItem> getItemSuggestList() {
		List<User> users = this.utilisateurManager.getAll();
		
		List<SuggestListItem> items = new ArrayList<SuggestListItem>();
		for(User user : users){
			SuggestListItem item = new SuggestListItem();
			item.setId(user.getId());
			item.setValue(user.getPrenom()+" "+user.getNom());
			item.setType("human");
			
			items.add(item);
		}
		
		List<Fiche> fiches = this.horseManager.recupererToutesLesFiches();
		for(Fiche fiche : fiches){
			SuggestListItem item = new SuggestListItem();
			item.setId(""+fiche.getId());
			item.setValue(fiche.getNom());
			item.setType("horse");
			
			items.add(item);
		}
		
		Collections.sort(items);
		
		return items;
	}

	@Override
	public User getUserByLogin(String login) {
		User user = this.utilisateurManager.getById(login);
		return user;
	}

}
