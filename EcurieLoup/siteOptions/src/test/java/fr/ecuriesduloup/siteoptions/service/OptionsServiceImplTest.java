package fr.ecuriesduloup.siteoptions.service;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import service.UtilisateurManager;
import donnees.User;
import fr.ecuriesduloup.siteoptions.dao.OptionsDao;
import fr.ecuriesduloup.siteoptions.data.Option;

public class OptionsServiceImplTest {

	private OptionsServiceImpl optionsService;
	private UtilisateurManager userManager;
	private OptionsDao optionsDao;
	@Before
	public void setUp(){
		this.optionsService =  new OptionsServiceImpl();
		
		this.userManager = EasyMock.createMock(UtilisateurManager.class);			
		this.optionsService.setUserManager(userManager);
		
		this.optionsDao = EasyMock.createMock(OptionsDao.class);	
		this.optionsService.setOptionsDao(optionsDao);
	}
	@Test
	public void testGet() {
		String name = "name";
		String value = "value";
		String loginUser = "login of the user";
		
		
		Option option = this.createOption(loginUser, name, value);
		
		EasyMock.expect(this.userManager.getUtilisateurCourant()).andReturn(option.getUser());
		EasyMock.expect(this.optionsDao.getOption(option.getUser(), name)).andReturn(option);
		
		EasyMock.replay(this.userManager);
		EasyMock.replay(this.optionsDao);
		Option optionReturn = this.optionsService.get(name);
		
		assertEquals(value, optionReturn.getValue());
		
		EasyMock.verify(this.userManager);
		EasyMock.verify(this.optionsDao);
	}
	
	private Option createOption(String loginUser, String name, String value){
		Option option = new Option();
		option.setId(15);
		
		
		option.setName(name);
		User user = new User();
		user.setLogin(loginUser);
		option.setUser(user);
		option.setValue(value);
		
		return option;
	}
	
	@Test
	public void testSaveUpdate() {
		String name = "name";
		String value = "value";
		String loginUser = "login of the user";
		
		
		Option option = this.createOption(loginUser, name, value);
		
		EasyMock.expect(this.userManager.getUtilisateurCourant()).andReturn(option.getUser());
		EasyMock.expect(this.optionsDao.getOption(option.getUser(), name)).andReturn(option);
		
		this.optionsDao.update(option);
	
		
		EasyMock.replay(this.userManager);
		EasyMock.replay(this.optionsDao);
		
		this.optionsService.save(name, value);
		
		EasyMock.verify(this.userManager);
		EasyMock.verify(this.optionsDao);
	}
	
	@Test
	public void testSaveFirst() {
		/*String name = "name";
		String value = "value";
		String loginUser = "login of the user";
		
		
		Option option = this.createOption(loginUser, name, value);
		
		EasyMock.expect(this.userManager.getUtilisateurCourant()).andReturn(option.getUser());
		EasyMock.expect(this.optionsDao.getOption(option.getUser(), name)).andReturn(null);
		
		OptionsEquals optionsEquals = new OptionsEquals(option);
		EasyMock.expect(this.optionsDao.add(optionsEquals));
	
		
		EasyMock.replay(this.userManager);
		EasyMock.replay(this.optionsDao);
		
		this.optionsService.save(name, value);
		
		EasyMock.verify(this.userManager);
		EasyMock.verify(this.optionsDao);*/
	}
	

}
