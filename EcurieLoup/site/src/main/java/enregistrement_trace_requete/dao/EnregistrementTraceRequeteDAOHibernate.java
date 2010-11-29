package enregistrement_trace_requete.dao;

import java.util.Collection;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import enregistrement_trace_requete.donnees.EnregistrementTraceRequete;
import enregistrement_trace_requete.donnees.ParametreEnregistrementTraceRequete;

public class EnregistrementTraceRequeteDAOHibernate extends HibernateDaoSupport
		implements EnregistrementTraceRequeteDAO {

	@Override
	public EnregistrementTraceRequete getEnregistrement(long id) {
		return (EnregistrementTraceRequete) this.getHibernateTemplate().load(
				EnregistrementTraceRequete.class, id);
	}

	@Override
	public void save(EnregistrementTraceRequete enregistrementTraceRequete) {
		this.getHibernateTemplate().save(enregistrementTraceRequete);
	}

	@Override
	public void save(
			ParametreEnregistrementTraceRequete parametreEnregistrementTraceRequete) {
		this.getHibernateTemplate().save(parametreEnregistrementTraceRequete);

	}

	@Override
	public Collection<EnregistrementTraceRequete> getAllEnregistrement() {
		return this.getHibernateTemplate().loadAll(
				EnregistrementTraceRequete.class);
	}

}
