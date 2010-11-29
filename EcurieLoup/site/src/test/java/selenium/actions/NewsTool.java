package selenium.actions;


import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

public class NewsTool extends SeleneseTestCase{
	private Selenium selenium;
	private VerificationTool verificationTool;

	public NewsTool(Selenium selenium, VerificationTool verificationTool){
		this.selenium = selenium;
		this.verificationTool = verificationTool;
	}
	
	public void ecrireNews(String titre, String contenu){
		selenium.click("link=rediger une news");
		selenium.waitForPageToLoad("30000");
		selenium.type("titre", titre);
		selenium.type("contenu", contenu);
		selenium.click("bouton_valider_news");
		selenium.waitForPageToLoad("30000");
	}

	public void verifierNews(String titre, String contenu, String loginAuteur, boolean modifier){
		this.verificationTool.verificationPresenceText(titre);
		this.verificationTool.verificationPresenceText(contenu);
		this.verificationTool.verificationPresenceText("Par "+loginAuteur.toLowerCase());

		verifyTrue(selenium.isElementPresent("//img[@alt='Modifier']"));
		verifyTrue(selenium.isElementPresent("//img[@alt='supprimer']"));

		if(modifier)
			this.verifierNewsModifier();
		else
			this.verifierNewsNonModifier();

	}

	public void verifierNewsModifier(){
		this.verificationTool.verificationPresenceText("Derni�re modification ");
	}
	public void verifierNewsNonModifier(){
		this.verificationTool.verificationAbsenceText("Derni�re modification ");
	}

	public void modificationNews(int indexListePresentation, String titre, String contenu){
		selenium.click("//div[@id='corps']/div/div["+indexListePresentation+"]/div[1]/div[2]/a[1]/img");
		selenium.waitForPageToLoad("30000");

		selenium.type("titre", titre);
		selenium.type("contenu", contenu);
		selenium.click("bouton_valider_news");
		selenium.waitForPageToLoad("30000");

	}
	public void supprimerNews(int indexListePresentation){
		selenium.click("//div[@id='corps']/div/div["+indexListePresentation+"]/div[1]/div[2]/a[2]/img");
		selenium.waitForPageToLoad("30000");
	}
}
