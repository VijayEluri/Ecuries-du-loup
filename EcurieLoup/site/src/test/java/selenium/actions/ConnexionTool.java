package selenium.actions;


import com.thoughtworks.selenium.Selenium;

public class ConnexionTool {
	private Selenium selenium;
	
	public ConnexionTool(Selenium selenium){
		this.selenium = selenium;
	}
	public void connexion(IdentifiantConnexion identifiantConnexion){
		selenium.click("link=Connectez-vous !");
		selenium.waitForPageToLoad("30000");
		
		selenium.type("j_username", identifiantConnexion.getLogin());
		selenium.type("j_password", identifiantConnexion.getPassword());
		selenium.click("bouton_connexion");
		selenium.waitForPageToLoad("30000");
	}
	
	public void deconnexion(){
		selenium.click("link=Déconnexion");
		selenium.waitForPageToLoad("30000");
	}
}
