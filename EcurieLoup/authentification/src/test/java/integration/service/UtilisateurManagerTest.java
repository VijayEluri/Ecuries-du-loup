package integration.service;

import static org.junit.Assert.assertTrue;
import integration.ContextManager;
import integration.UserInBase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import service.UtilisateurManager;
import dao.AuthentificationTestUtil;
import donnees.Role;
import donnees.RoleEnum;
import donnees.User;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithStringIdIntegrationTest;

public class UtilisateurManagerTest extends DataBaseServiceWithStringIdIntegrationTest<User>{
	private ApplicationContext context;
	
	public UtilisateurManagerTest(){
		this.context = ContextManager.getContext();
	}

	@Before
	public void setUp(){
		this.service = (UtilisateurManager) this.context.getBean("utilisateurManager");
	}

	@Test
	public void testRecupererRoles(){
		Set<Role> roles = new HashSet<Role>();

		Role roleAuth = new Role();
		roleAuth.setRole(RoleEnum.ROLE_AUTHENTIFIER.toString());
		roles.add(roleAuth);
		
		Role roleAdmin = new Role();
		roleAdmin.setRole(RoleEnum.ROLE_ADMINISTRATEUR_ADMIN.toString());
		roles.add(roleAdmin);


		Role roleForum = new Role();
		roleForum.setRole(RoleEnum.ROLE_ADMINISTRATEUR_FORUM.toString());
		roles.add(roleForum);

		Role rolePhoto = new Role();
		rolePhoto.setRole(RoleEnum.ROLE_ADMINISTRATEUR_PHOTO.toString());
		roles.add(rolePhoto);

		Role roleNews = new Role();
		roleNews.setRole(RoleEnum.ROLE_ADMINISTRATEUR_NEWS.toString());
		roles.add(roleNews);

		Role roleCalendrier= new Role();
		roleCalendrier.setRole(RoleEnum.ROLE_ADMINISTRATEUR_CALENDRIER.toString());
		roles.add(roleCalendrier);
		
		Role roleFiche= new Role();
		roleFiche.setRole(RoleEnum.ROLE_ADMINISTRATEUR_FICHECHEVAUX.toString());
		roles.add(roleFiche);
		
		List<Role> roleRecuperer = ((UtilisateurManager) this.service).recupererListeRole();
		
		assertTrue(roleRecuperer.containsAll(roles));
		assertTrue(roleRecuperer.size()==roles.size());
		
	}

	@Override
	protected void compareJUnit(User utilisateur1, User utilisateur2) {
		AuthentificationTestUtil.compareJUnit(utilisateur1, utilisateur2);
		
	}

	@Override
	protected User getNewObject() {
		return AuthentificationTestUtil.getNewObject();
	}

	@Override
	protected User getObjectInBase() {
		return UserInBase.getUtilisateurSansDroit();
	}

	@Override
	protected void modificationObject(User t) {
		AuthentificationTestUtil.modificationObject(t);
		
	}
}