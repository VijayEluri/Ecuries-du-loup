package sauvegarde.smiley.service;

import sauvegarde.smiley.donnees.SauvegardeSmiley;

public interface SauvegardeSmileyManager {

	public void creationSauvegardeSmiley(SauvegardeSmiley sauvegardeSmiley);

	public void suppressionSauvegardeSmiley(long identifiantSmiley);

	public void restaurerSauvegardeSmiley(long identifiantSmiley);

	public boolean isInCacheSauvegardeSmiley(long identifiantSmiley);
}
