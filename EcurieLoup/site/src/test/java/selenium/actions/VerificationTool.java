package selenium.actions;

import com.thoughtworks.selenium.SeleneseTestCase;
import com.thoughtworks.selenium.Selenium;

public class VerificationTool extends SeleneseTestCase{
	private Selenium selenium;

	public VerificationTool(Selenium selenium){
		this.selenium = selenium;
	}
	
	public void verificationPresenceLien(String nomLien){
		assertTrue(selenium.isElementPresent("link="+nomLien));
	}
	
	public void verificationAbsenceLien(String nomLien){
		assertFalse(selenium.isElementPresent("link="+nomLien));
	}
	
	public void verificationPresenceText(String texte){
		assertTrue(selenium.isTextPresent(texte));
	}

	public void verificationAbsenceText(String texte) {
		assertFalse(selenium.isTextPresent(texte));	
	}
}
