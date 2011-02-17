package fr.ecuriesduloup.siteoptions.dao;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import donnees.User;

import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;
import fr.ecuriesduloup.siteoptions.ContextManager;
import fr.ecuriesduloup.siteoptions.Database;
import fr.ecuriesduloup.siteoptions.OptionTestUtil;
import fr.ecuriesduloup.siteoptions.data.Option;


public class OptionsDaoImplTest extends DaoIdLongUtilTest<Option>{

	@Before
	public void setUp() throws Exception {
		this.dao = (OptionsDao) ContextManager.getContext().getBean("optionsDaoTest");
		
	}
	@Override
	protected void compareJUnit(Option option1, Option option2) {
		OptionTestUtil.compareJUnit(option1, option2);
		
	}

	@Override
	protected Option getNewObject() {
		return OptionTestUtil.getNewOption();
	}

	@Override
	protected Option getObjectInBase() {
		return Database.getOption();
	}

	@Override
	protected void modificationObject(Option option) {
		OptionTestUtil.modificationObject(option);		
	}
	
	@Test
	public void getOptionExistTest(){
		Option optionInDatabase = Database.getOption();
		Option option = ((OptionsDao)this.dao).getOption(optionInDatabase.getUser(), optionInDatabase.getName());
		assertNotNull(option);
		OptionTestUtil.compareJUnit(optionInDatabase, option);
	}
	
	@Test
	public void getOptionNotExistNameTest(){
		Option optionInDatabase = Database.getOption();
		Option option = ((OptionsDao)this.dao).getOption(optionInDatabase.getUser(), "name_not_exist");
		assertNull(option);
	}
	
	@Test
	public void getOptionNotExistUserTest(){
		Option optionInDatabase = Database.getOption();
		User user = new User();
		user.setLogin("login_not_exist");
		Option option = ((OptionsDao)this.dao).getOption(user, optionInDatabase.getName());
		assertNull(option);
	}
	
	

}
