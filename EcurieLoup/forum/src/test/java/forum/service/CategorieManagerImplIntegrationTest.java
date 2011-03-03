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
		this.notCheckedValue.clear();
		this.service = (CategorieManager) this.context.getBean("categorieManagerTest");
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

	@Override
	public void testGetById() {
		this.notCheckedValue.add("getTopics");
		this.notCheckedValue.add("getTopicNonLu");
		
		System.out.println("test");
		super.testGetById();
	}
	
	@Override
	public void testGetAll() {
		this.notCheckedValue.add("getTopics");
		this.notCheckedValue.add("getTopicNonLu");
		
		super.testGetAll();
	}
}
