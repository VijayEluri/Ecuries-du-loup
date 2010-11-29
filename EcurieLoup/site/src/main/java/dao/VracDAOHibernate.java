package dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import donnees.Vrac;

public class VracDAOHibernate extends HibernateDaoSupport implements VracDAO {

	@Override
	public Vrac getVrac(String identifiant) {
		return (Vrac) this.getHibernateTemplate().get(Vrac.class, identifiant);

	}

	@Override
	public void update(Vrac vrac) {
		this.getHibernateTemplate().update(vrac);
	}
}
