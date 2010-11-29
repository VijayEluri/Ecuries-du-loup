package sauvegarde.smiley.dao;

import sauvegarde.smiley.donnees.SauvegardeSmiley;

public interface SauvegardeSmileyDAO {

	public SauvegardeSmiley getSauvegardeSmiley(long codeSmiley);

	public void update(SauvegardeSmiley sauvegardeSmiley);

	public void save(SauvegardeSmiley sauvegardeSmiley);

	public void delete(SauvegardeSmiley sauvegardeSmiley);
}
