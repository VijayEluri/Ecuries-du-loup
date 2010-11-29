package dao;

import java.util.List;

import donnees.Role;

/**
 * Interface de gestion en base de donnée d'un rôle
 * @author Krack
 *
 */
public interface RoleDAO {

	/**
	 * Permet de récupérer un rôle a partir de son nom
	 * @param name le nom du Role
	 * @return le role 
	 */
	public Role getRole(String name);

	public List<Role> getAllRole();
	
}
