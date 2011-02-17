package fr.ecuriesduloup.siteoptions.service;

import service.UtilisateurManager;
import donnees.User;
import fr.ecuriesduloup.siteoptions.dao.OptionsDao;
import fr.ecuriesduloup.siteoptions.data.Option;

public class OptionsServiceImpl implements OptionsService {

	private OptionsDao optionsDao;
	private UtilisateurManager userManager;
	
	
	public void setOptionsDao(OptionsDao optionsDao) {
		this.optionsDao = optionsDao;
	}
	
	

	public void setUserManager(UtilisateurManager userManager) {
		this.userManager = userManager;
	}



	@Override
	public Option get(String name) {
		User user = this.userManager.getUtilisateurCourant();
		return this.optionsDao.getOption(user, name);

	}

	@Override
	public void save(String name, String value) {
		User user = this.userManager.getUtilisateurCourant();
		Option option = this.optionsDao.getOption(user, name);
		if(option == null){
			option = new Option();
			option.setUser(user);
			option.setName(name);
			option.setValue(value);			
			this.optionsDao.add(option);
		}else{
			option.setValue(value);
			this.optionsDao.update(option);		
		}
	}

}
