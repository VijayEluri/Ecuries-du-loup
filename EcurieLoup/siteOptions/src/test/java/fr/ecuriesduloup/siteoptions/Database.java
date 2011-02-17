package fr.ecuriesduloup.siteoptions;

import fr.ecuriesduloup.siteoptions.data.Option;

public class Database {

	public static Option getOption(){
		Option option = new Option();
		option.setId(1);
		option.setUser(UserInBase.getUtilisateurToutDroit());
		option.setName("name_database");
		option.setValue("value_database");
		return option;
	}
}
