package fr.ecurie_du_loup.generique_util.dao;

import fr.ecurie_du_loup.generique_util.type.DataWithLongId;


public abstract class HibernateIdLongBySpringDao<T extends DataWithLongId> extends HibernateBySpringDao<T>
		implements DaoIdLongUtil<T> {

	public HibernateIdLongBySpringDao() {
		super();
	}
	
	@Override
	public T findById(long id) {
		return (T) this.getHibernateTemplate().get(this.parametreClass, id);
	}

}
