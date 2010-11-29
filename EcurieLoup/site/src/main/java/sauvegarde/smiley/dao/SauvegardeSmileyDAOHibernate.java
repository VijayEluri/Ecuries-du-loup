package sauvegarde.smiley.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import sauvegarde.smiley.donnees.SauvegardeSmiley;

public class SauvegardeSmileyDAOHibernate extends HibernateDaoSupport implements
		SauvegardeSmileyDAO {

	@Override
	public void delete(SauvegardeSmiley sauvegardeSmiley) {
		if(sauvegardeSmiley !=null)
			this.getHibernateTemplate().delete(sauvegardeSmiley);

	}

	@Override
	public SauvegardeSmiley getSauvegardeSmiley(long codeSmiley) {
		return (SauvegardeSmiley) this.getHibernateTemplate().get(
				SauvegardeSmiley.class, codeSmiley);
	}

	@Override
	public void save(SauvegardeSmiley sauvegardeSmiley) {
		this.getHibernateTemplate().save(sauvegardeSmiley);

	}

	@Override
	public void update(SauvegardeSmiley sauvegardeSmiley) {
		this.getHibernateTemplate().update(sauvegardeSmiley);

	}

}
