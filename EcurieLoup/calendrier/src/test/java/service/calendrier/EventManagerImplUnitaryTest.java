package service.calendrier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import dao.UserDAO;
import dao.calendrier.CalendrierTestUtil;
import dao.calendrier.EventDao;
import dao.calendrier.TypeEventDao;
import donnees.User;
import donnees.calendrier.Evenement;
import donnees.calendrier.TypeEvenement;
import fiche_chevaux.dao.FicheChevauxDAO;
import fiche_chevaux.donnees.Fiche;
import fr.ecurie_du_loup.generique_util.service.test.DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest;


public class EventManagerImplUnitaryTest extends DataBaseServiceWithDaoIdLongUtilAndLongIdUnitaryTest<Evenement>{
	private UserDAO userDAO;
	private TypeEventDao typeEventDao;
	private FicheChevauxDAO ficheChevauxDAO;
	@Before
	public void setUp() throws Exception {
		this.dao = EasyMock.createMock(EventDao.class);
		this.service = new EventManagerImpl();
		this.service.setDao(this.dao);
		this.userDAO = EasyMock.createMock(UserDAO.class); 
		((EventManagerImpl)this.service).setUserDAO(this.userDAO);
		
		this.typeEventDao = EasyMock.createMock(TypeEventDao.class); 
		((EventManagerImpl)this.service).setTypeEventDao(this.typeEventDao);
		
		this.ficheChevauxDAO = EasyMock.createMock(FicheChevauxDAO.class); 
		((EventManagerImpl)this.service).setFicheChevauxDAO(this.ficheChevauxDAO);
	}
	
	@Override
	protected Evenement getNewObject() {
		return CalendrierTestUtil.getNewObject();
	}
	
	private List<Evenement> creationListEvenement(){
		List<Evenement> listeEvenement = new ArrayList<Evenement>();
		long[] timestamp = {
				this.genereTimestamp(30, 6, 2009, 9, 26, 40),
				this.genereTimestamp(30, 6, 2009, 19, 26, 40),
				this.genereTimestamp(14, 6, 2009, 19, 26, 40),
				this.genereTimestamp(14, 4, 2009, 19, 26, 40),
				this.genereTimestamp(14, 6, 1992, 19, 26, 40),
				this.genereTimestamp(1, 6, 2009, 0, 0, 0),
				this.genereTimestamp(1, 7, 2009, 0, 0, 0),
				this.genereTimestamp(1, 2, 2009, 13, 0, 0),
				this.genereTimestamp(1, 2, 2009, 13, 3, 20),
				this.genereTimestamp(1, 6, 2011, 13, 0, 0)
				};
		for(int i = 0; i < 10; i++){
			Evenement evenement = this.getNewObject();
			evenement.setDate(timestamp[i]);
			listeEvenement.add(evenement);
		}
		return listeEvenement;
	}
	
	private long genereTimestamp(int jour, int mois, int annees, int heure, int minutes, int seconde){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, jour);
		calendar.set(Calendar.MONTH, mois-1);
		calendar.set(Calendar.YEAR, annees);
		calendar.set(Calendar.HOUR_OF_DAY, heure);
		calendar.set(Calendar.MINUTE, minutes);
		calendar.set(Calendar.SECOND, seconde);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime().getTime();
	}
	
	@Test
	public void testRecuperationTousEvenementDuMoisParJour() throws Throwable{
		List<Evenement> listeEvenement = this.creationListEvenement();
		Map<Integer, List<Evenement>> evenements = new HashMap<Integer, List<Evenement>>();

		for(int i = 0; i <= 30; i++){
			List<Evenement> listeEvenementJour = new ArrayList<Evenement>();
			if(i==30){
				listeEvenementJour.add(listeEvenement.get(0));
				listeEvenementJour.add(listeEvenement.get(1));
			}else if(i == 14){
				listeEvenementJour.add(listeEvenement.get(2));
			}
			else if(i == 1){
				listeEvenementJour.add(listeEvenement.get(5));
			}
			evenements.put(i, listeEvenementJour);
		}


		EasyMock.expect(this.dao.findAll()).andReturn(listeEvenement);
		for(int i = 1; i <= 30; i++){
			EasyMock.expect(this.typeEventDao.findById(1)).andReturn(new TypeEvenement());
			EasyMock.expect(this.userDAO.getUserBorn(06, i)).andReturn(new ArrayList<User>());
			EasyMock.expect(this.typeEventDao.findById(1)).andReturn(new TypeEvenement());
			EasyMock.expect(this.ficheChevauxDAO.getHorseBorn(06, i)).andReturn(new ArrayList<Fiche>());
			
		}
		
		EasyMock.replay(this.dao);
		EasyMock.replay(this.userDAO);
		EasyMock.replay(this.typeEventDao);
		EasyMock.replay(this.ficheChevauxDAO);

		Map<Integer, List<Evenement>> evenementRecuperer = ((EventManagerImpl) this.service).recuperationTousEvenementsDuMoisParJour(2009, 06);

		for(int i = 1; i <= 30; i++){
			List<Evenement> liste1= evenementRecuperer.get(i);
			List<Evenement> liste2= evenements.get(i);

			assertEquals(liste1.size(), liste2.size());

			assertTrue(liste1.containsAll(liste2));
			assertTrue(liste2.containsAll(liste1));


		}
		EasyMock.verify(this.dao);
	}
	
	
	@Test
	public void testRecuperationTousEvenementDuJour() throws Throwable{
		

		List<Evenement> listeEvenement = this.creationListEvenement();
		List<Evenement> evenements = new  ArrayList<Evenement>();

		evenements.add(listeEvenement.get(0));
		evenements.add(listeEvenement.get(1));


		EasyMock.expect(this.dao.findAll()).andReturn(listeEvenement);
		
		
		EasyMock.expect(this.typeEventDao.findById(1)).andReturn(new TypeEvenement());
		EasyMock.expect(this.typeEventDao.findById(1)).andReturn(new TypeEvenement());
		EasyMock.expect(this.userDAO.getUserBorn(06, 30)).andReturn(new ArrayList<User>());
		EasyMock.expect(this.ficheChevauxDAO.getHorseBorn(06, 30)).andReturn(new ArrayList<Fiche>());
		
		EasyMock.replay(this.dao);

		EasyMock.replay(this.userDAO);
		EasyMock.replay(this.typeEventDao);

		EasyMock.replay(this.ficheChevauxDAO);

		List<Evenement> evenementRecuperer = ((EventManagerImpl) this.service).recuperationTousEvenementsDuJour(2009, 06, 30);


		assertTrue(evenements.containsAll(evenementRecuperer));
		assertTrue(evenementRecuperer.containsAll(evenements));

		EasyMock.verify(this.dao);
	}

}
