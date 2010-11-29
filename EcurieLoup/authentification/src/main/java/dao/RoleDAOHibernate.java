package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import donnees.Role;

/**
 * Classe implémentant UserDAO pour la gestion en base de données de Role<br />
 * Utilisation de hibernate pour la gestion de données conjointement à spring 
 * @author Krack
 *
 */
public class RoleDAOHibernate extends HibernateDaoSupport implements RoleDAO{

	@Override
	public Role getRole(String name) {
		return (Role) this.getHibernateTemplate().get(Role.class, name);
	}

	@Override
	public List<Role> getAllRole() {
		return this.getHibernateTemplate().loadAll(Role.class);
	}

}
