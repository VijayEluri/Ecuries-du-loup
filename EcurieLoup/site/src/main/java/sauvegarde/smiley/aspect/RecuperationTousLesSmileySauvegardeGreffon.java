package sauvegarde.smiley.aspect;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.aop.AfterReturningAdvice;

import sauvegarde.smiley.service.SauvegardeSmileyManager;
import donnees.smiley.Smiley;

public class RecuperationTousLesSmileySauvegardeGreffon implements
		AfterReturningAdvice {
	private SauvegardeSmileyManager sauvegardeSmileyManager;

	public void setSauvegardeSmileyManager(
			SauvegardeSmileyManager sauvegardeSmileyManager) {
		this.sauvegardeSmileyManager = sauvegardeSmileyManager;
	}

	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		if (target.getClass().toString().equals(
				"class service.smiley.SmileyManagerImpl")) {
			// public List<Smiley> recupererTousLesSmiley();
			List<Smiley> listeDesSmiley = (List<Smiley>) returnValue;

			for (Smiley smiley : listeDesSmiley) {
				if (this.aBesoinDeRecuperation(smiley)) {
					this.recuperation(smiley);
				}
			}

		}

	}

	private boolean aBesoinDeRecuperation(Smiley smiley) {
		return !this.sauvegardeSmileyManager.isInCacheSauvegardeSmiley(smiley
				.getId());
	}

	private void recuperation(Smiley smiley) {
		this.sauvegardeSmileyManager.restaurerSauvegardeSmiley(smiley.getId());

	}

}
