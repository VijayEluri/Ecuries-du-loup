package sauvegarde.smiley.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import sauvegarde.smiley.service.SauvegardeSmileyManager;

public class SuppressionSauvegardeSmileyGreffon implements AfterReturningAdvice {
	private SauvegardeSmileyManager sauvegardeSmileyManager;

	public void setSauvegardeSmileyManager(
			SauvegardeSmileyManager sauvegardeSmileyManager) {
		this.sauvegardeSmileyManager = sauvegardeSmileyManager;
	}

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {

		// public void supprimerPhoto(Photo photo, String pathServeur)
		String nom = (String) args[0];
		String[] spliter = nom.split("/");
		int sauvegarde = Integer.parseInt(spliter[spliter.length - 1]);
		try{
			this.sauvegardeSmileyManager.suppressionSauvegardeSmiley(sauvegarde);
		}catch (Exception e) {
			// TODO: handle exception
		}

	}

}
