package fr.ecuriesduloup.siteoptions;

import fr.ecuriesduloup.siteoptions.data.Option;

public class OptionTestUtil {

	public static Option getNewOption() {
		Option option = new Option();
		long id = (long) (Math.random()*10000);
		option.setId(id);
		option.setUser(UserInBase.getUtilisateurToutDroit());
		option.setName("name_test");
		option.setValue("value_test");

		return option;
	}

	public static void modificationObject(Option option) {
		option.setValue("value_test_modifier");

	}

	
}
