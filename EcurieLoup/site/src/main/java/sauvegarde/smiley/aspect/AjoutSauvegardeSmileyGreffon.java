package sauvegarde.smiley.aspect;

import java.io.File;
import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import sauvegarde.smiley.donnees.SauvegardeSmiley;
import sauvegarde.smiley.service.SauvegardeSmileyManager;

public class AjoutSauvegardeSmileyGreffon implements AfterReturningAdvice {

	private SauvegardeSmileyManager sauvegardeSmileyManager;

	public void setSauvegardeSmileyManager(
			SauvegardeSmileyManager sauvegardeSmileyManager) {
		this.sauvegardeSmileyManager = sauvegardeSmileyManager;
	}

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		
		
		// public void creerFicherSurDisque(String emplacement, String nom, File
		// fichier)
		String nom = (String) args[1];
		File fichierPhoto = (File) args[2];
		
		SauvegardeSmiley sauvegardeSmiley = new SauvegardeSmiley();
		sauvegardeSmiley.setIdentifiant(Integer.parseInt(nom));
		sauvegardeSmiley.setFichier(fichierPhoto);

		this.sauvegardeSmileyManager.creationSauvegardeSmiley(sauvegardeSmiley);
	}

}
