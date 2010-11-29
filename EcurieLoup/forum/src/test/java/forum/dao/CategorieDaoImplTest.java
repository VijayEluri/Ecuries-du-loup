package forum.dao;


import integration.ContextManager;
import integration.ForumInBase;

import org.junit.Before;
import org.springframework.context.ApplicationContext;

import forum.donnees.Categorie;
import fr.ecurie_du_loup.generique_util.dao.test.DaoIdLongUtilTest;

public class CategorieDaoImplTest extends DaoIdLongUtilTest<Categorie>{

	private ApplicationContext context;

	public CategorieDaoImplTest(){
		this.context = ContextManager.getContext();
		
	}
	@Before
	public void setUp(){		
		this.dao = (CategorieDao) this.context.getBean("categorieDAOTest");
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
