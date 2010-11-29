package fr.ecurie_du_loup.generique_util.dao;


public abstract class HibernateIdStringBySpringDao<T> extends HibernateBySpringDao<T>
		implements DaoIdStringUtil<T> {

	public HibernateIdStringBySpringDao() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(String id) {
		return (T) this.getHibernateTemplate().get(this.parametreClass, id);
	}

}
