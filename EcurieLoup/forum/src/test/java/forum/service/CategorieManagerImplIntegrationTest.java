package forum.service;

import integration.ContextManager;
import integration.ForumInBase;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import forum.dao.ForumTestUtil;
import forum.donnees.Categorie;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithLongIdIntegrationTest;


public class CategorieManagerImplIntegrationTest extends DataBaseServiceWithLongIdIntegrationTest<Categorie>{

	private ApplicationContext context;
	
	public CategorieManagerImplIntegrationTest(){
		this.context = ContextManager.getContext();
		
	}
	
	@Before
	public void setUp(){		
		this.service = (CategorieManager) this.context.getBean("categorieManagerTest");
	}
	@Override
	protected void compareJUnit(Categorie categorie1, Categorie categorie2) {
		ForumTestUtil.compareJUnit(categorie1, categorie2);
		
	}

	@Override
	protected Categorie getNewObject() {
		
		return ForumTestUtil.getNewCategorie();
	}

	@Override
	protected Categorie getObjectInBase() {
		return ForumInBase.getCatergorie();
	}

	@Override
	protected void modificationObject(Categorie categorie) {
		ForumTestUtil.modificationObject(categorie);
		
	}

}
