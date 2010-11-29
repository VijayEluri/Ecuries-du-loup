package selenium;

import java.util.Date;

import selenium.actions.ConnexionTool;
import selenium.actions.IdentifiantConnexion;
import selenium.actions.VerificationTool;

import com.thoughtworks.selenium.SeleneseTestCase;

public abstract class EcurieDuLoupSeleneseTestCase extends SeleneseTestCase {
	protected ConnexionTool connexionTool;
	protected VerificationTool verificationTool;
	
	@Override
	public void setUp() throws Exception {
		super.setUp("http://localhost:8080/", "*firefox"); 
		selenium.open("beta/index.do");
		
		this.connexionTool = new ConnexionTool(this.selenium);
		this.verificationTool = new VerificationTool(this.selenium);
	}
	
	@Override
	public void tearDown() throws Exception {
		selenium.deleteAllVisibleCookies();
		super.tearDown();
		
	}
	
	protected IdentifiantConnexion getUniqueUser(){
		IdentifiantConnexion uniqueUser = new IdentifiantConnexion();
		uniqueUser.setLogin("login"+new Date().getTime());
		uniqueUser.setPassword("password");
		
		return uniqueUser;
	}
	
	protected IdentifiantConnexion getUserConnection(){
		IdentifiantConnexion uniqueUser = new IdentifiantConnexion();
		uniqueUser.setLogin("krack");
		uniqueUser.setPassword("pass");
		
		return uniqueUser;
	}
	
	protected IdentifiantConnexion getUserInvalidLogin(){
		IdentifiantConnexion uniqueUser = new IdentifiantConnexion();
		uniqueUser.setLogin("Login inexistant");
		uniqueUser.setPassword("pass");
		
		return uniqueUser;
	}
	
	protected IdentifiantConnexion getUserInvalidPassword(){
		IdentifiantConnexion uniqueUser = new IdentifiantConnexion();
		uniqueUser.setLogin("krack");
		uniqueUser.setPassword("pass de merde");
		
		return uniqueUser;
	}
}
