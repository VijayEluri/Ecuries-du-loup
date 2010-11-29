package selenium.scenario;

import selenium.EcurieDuLoupSeleneseTestCase;



public class TestConnexion extends EcurieDuLoupSeleneseTestCase {
	
	public void testConnexion() throws Exception {
				
		this.checkIsNotConnected();
		this.connexionTool.connexion(this.getUserConnection());
		this.checkIsConnected();

		this.connexionTool.deconnexion();
	}
	
	public void testConnexionEchouerInvalidLogin() throws Exception {
				
		this.checkIsNotConnected();
		this.connexionTool.connexion(this.getUserInvalidLogin());
		
		this.checkInvalidConnexion();
	}
	
	public void testConnexionEchouerInvalidPassword() throws Exception {
		
		this.checkIsNotConnected();
		this.connexionTool.connexion(this.getUserInvalidPassword());
		
		this.checkInvalidConnexion();
	}
	
	private void checkIsNotConnected(){
		this.verificationTool.verificationPresenceLien("Connectez-vous !");
	}
	
	private void checkIsConnected(){
		this.verificationTool.verificationPresenceLien("Déconnexion");
	}
	
	private void checkInvalidConnexion(){
		
		this.verificationTool.verificationAbsenceLien("Déconnexion");

		this.verificationTool.verificationPresenceText("La connexion a échoué.");
		this.verificationTool.verificationPresenceText("Veuillez vérifier que votre login et password sont correct.");		
	}
	
	
}
