package fr.ecurie_du_loup.generique_util.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class HibernateBySpringDao<T> extends HibernateDaoSupport implements DaoUtil<T> {
	protected final Class<T> parametreClass;
	
	@SuppressWarnings("unchecked")
	public HibernateBySpringDao(){
		this.parametreClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
	}
	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return this.getHibernateTemplate().find("Select t FROM "+ this.parametreClass.getSimpleName()+" t "+this.getOrderByOfFindAll());
	}
	
	protected String getOrderByOfFindAll(){
		return "";
	}

	@Override
	public void remove(T t) {
		this.getHibernateTemplate().delete(t);
		
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);		
	}

}
