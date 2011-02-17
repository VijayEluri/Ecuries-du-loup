package fr.ecuriesduloup.siteoptions;

import static org.junit.Assert.assertEquals;
import fr.ecuriesduloup.siteoptions.data.Option;

public class OptionTestUtil {


	public static void compareJUnit(Option option1, Option option2) {
		assertEquals(option1.getId(), option2.getId());
		assertEquals(option1.getUser(), option2.getUser());
		assertEquals(option1.getName(), option2.getName());
		assertEquals(option1.getValue(), option2.getValue());

	}

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
