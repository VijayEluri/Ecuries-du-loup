package unitaire.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import service.UtilisateurManager;
import service.UtilisateurManagerImpl;
import dao.AuthentificationTestUtil;
import dao.RoleDAO;
import dao.UserDAO;
import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithDaoAndStringIdUnitariTest;

public class UtilisateurManagerImplTest extends DataBaseServiceWithDaoAndStringIdUnitariTest<User>{
	private RoleDAO roleDAO;
	
	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(UserDAO.class);
		this.roleDAO = EasyMock.createMock(RoleDAO.class);
		this.service = new UtilisateurManagerImpl();
		((UtilisateurManagerImpl)this.service).setRoleDAO(this.roleDAO);
		((UtilisateurManagerImpl)this.service).setDao(this.dao);
	}

	@Override
	public void testAdd() {
		User nouvelleUtilisateur = new User();
		nouvelleUtilisateur.setLogin("nouvelle utilisateur");
		
		EasyMock.expect(((UserDAO)this.dao).findById(nouvelleUtilisateur.getLogin())).andReturn(null);
		this.dao.add(nouvelleUtilisateur);
		Role roleAuthentifier = new Role();
		roleAuthentifier.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
		
		EasyMock.expect(this.roleDAO.getRole(RoleEnum.ROLE_AUTHENTIFIER.toString())).andReturn(roleAuthentifier);
		
		EasyMock.replay(this.dao);
		EasyMock.replay(this.roleDAO);
		
		this.service.add(nouvelleUtilisateur);
			
		Set<Role> rolesUser = new HashSet<Role>();
		rolesUser.add(roleAuthentifier);
			
		assertEquals(rolesUser, nouvelleUtilisateur.getRoles());
		assertTrue(nouvelleUtilisateur.isEnabled());
		EasyMock.verify(this.dao);
	}

	
	@Test
	public void testRechercheUtilisateurInsensibleCast() {
		User utilisateurReferant = new User();
		utilisateurReferant.setLogin("krack");
		
		User utilisateurNoCast = new User();
		utilisateurNoCast.setLogin("KRACK");
		EasyMock.expect(((UserDAO) this.dao).findById(utilisateurReferant.getLogin())).andReturn(utilisateurReferant);
		
		EasyMock.replay(this.dao);
		
		User utilisateur = ((UtilisateurManager) this.service).getById(utilisateurReferant.getLogin());
		
		assertTrue(utilisateur!=null);
		assertTrue(utilisateurNoCast.equals(utilisateur));

		
		EasyMock.verify(this.dao);	
	}
	
	@Test
	public void testRecupererListeRoleVide() {
		List<Role> listeRole = new ArrayList<Role>();
		
		EasyMock.expect(this.roleDAO.getAllRole()).andReturn(listeRole);
		
		EasyMock.replay(this.roleDAO);
		
		List<Role> listeRoleRecuperer = ((UtilisateurManager) this.service).recupererListeRole();
		
		assertTrue(listeRole.containsAll(listeRoleRecuperer));
		assertTrue(listeRoleRecuperer.containsAll(listeRole));
		assertTrue(listeRoleRecuperer.isEmpty());
		EasyMock.verify(this.roleDAO);	
	}
	
	@Test
	public void testRecupererListeRole() {
		List<Role> listeRole = new ArrayList<Role>();
		Role role = new Role();
		role.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
		listeRole.add(role);
		
		EasyMock.expect(this.roleDAO.getAllRole()).andReturn(listeRole);
		
		EasyMock.replay(this.roleDAO);
		
		List<Role> listeRoleRecuperer = ((UtilisateurManager) this.service).recupererListeRole();
		
		assertTrue(listeRole.containsAll(listeRoleRecuperer));
		assertTrue(listeRoleRecuperer.containsAll(listeRole));
		EasyMock.verify(this.roleDAO);	
	}
	
	
	
	
	

	@Override
	protected User getNewObject() {
		return AuthentificationTestUtil.getNewObject();
	}

}
