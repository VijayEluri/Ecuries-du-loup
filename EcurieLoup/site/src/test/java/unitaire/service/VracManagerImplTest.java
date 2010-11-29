package unitaire.service;

import static org.junit.Assert.assertEquals;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import service.VracManagerImpl;
import dao.VracDAO;
import donnees.Vrac;

public class VracManagerImplTest {
	private VracDAO vracDAO;
	private VracManagerImpl vracManager;

	@Before
	public void setUp() throws Exception {
		this.vracDAO = EasyMock.createMock(VracDAO.class);
		this.vracManager = new VracManagerImpl();
		this.vracManager.setVracDAO(vracDAO);
	}

	@Test
	public void testRecupererVrac() {
		Vrac vrac = new Vrac();
		vrac.setId("idVrac de test");

		EasyMock.expect(this.vracDAO.getVrac(vrac.getId())).andReturn(vrac);

		EasyMock.replay(this.vracDAO);

		Vrac vracRecuperer = this.vracManager.recupererVrac(vrac.getId());

		assertEquals(vrac, vracRecuperer);
		EasyMock.verify(this.vracDAO);
	}

	@Test
	public void testModifierVrac() {
		Vrac vrac = new Vrac();
		vrac.setId("idVrac de test");

		this.vracDAO.update(vrac);

		EasyMock.replay(this.vracDAO);

		this.vracManager.modifierVrac(vrac);

		EasyMock.verify(this.vracDAO);
	}

}
