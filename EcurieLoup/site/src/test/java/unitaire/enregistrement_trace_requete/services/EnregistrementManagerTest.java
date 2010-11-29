package unitaire.enregistrement_trace_requete.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import enregistrement_trace_requete.dao.EnregistrementTraceRequeteDAO;
import enregistrement_trace_requete.donnees.EnregistrementTraceRequete;
import enregistrement_trace_requete.donnees.ParametreEnregistrementTraceRequete;
import enregistrement_trace_requete.services.EnregistrementManager;
import enregistrement_trace_requete.services.EnregistrementManagerImpl;

public class EnregistrementManagerTest {
	private EnregistrementManager enregistrementManager;
	private EnregistrementTraceRequeteDAO enregistrementTraceRequeteDAO;

	@Before
	public void setUp() throws Exception {
		this.enregistrementTraceRequeteDAO = EasyMock
				.createMock(EnregistrementTraceRequeteDAO.class);

		this.enregistrementManager = new EnregistrementManagerImpl();
		((EnregistrementManagerImpl) this.enregistrementManager)
				.setEnregistrementTraceRequeteDAO(this.enregistrementTraceRequeteDAO);
	}

	@Test
	public void testEnregistreTraceRequete() {
		ParametreEnregistrementTraceRequete p1 = new ParametreEnregistrementTraceRequete();
		ParametreEnregistrementTraceRequete p2 = new ParametreEnregistrementTraceRequete();

		Collection<ParametreEnregistrementTraceRequete> c = new ArrayList<ParametreEnregistrementTraceRequete>();
		c.add(p1);
		c.add(p2);

		EnregistrementTraceRequete trace = new EnregistrementTraceRequete();
		trace.setParametresRequeste(c);

		this.enregistrementTraceRequeteDAO.save(p1);
		this.enregistrementTraceRequeteDAO.save(p2);

		this.enregistrementTraceRequeteDAO.save(trace);

		EasyMock.replay(this.enregistrementTraceRequeteDAO);

		this.enregistrementManager.enregistreTraceRequete(trace);

		EasyMock.verify(this.enregistrementTraceRequeteDAO);
	}

	@Test
	public void testRecupererEnregistrementTraceRequete() {
		ParametreEnregistrementTraceRequete p1 = new ParametreEnregistrementTraceRequete();
		ParametreEnregistrementTraceRequete p2 = new ParametreEnregistrementTraceRequete();

		Collection<ParametreEnregistrementTraceRequete> c = new ArrayList<ParametreEnregistrementTraceRequete>();
		c.add(p1);
		c.add(p2);

		EnregistrementTraceRequete trace = new EnregistrementTraceRequete();
		trace.setId(1);
		trace.setParametresRequeste(c);

		EasyMock.expect(
				this.enregistrementTraceRequeteDAO.getEnregistrement(trace
						.getId())).andReturn(trace);

		EasyMock.replay(this.enregistrementTraceRequeteDAO);

		EnregistrementTraceRequete traceRecuperer = this.enregistrementManager
				.recupererEnregistrementTraceRequete(trace.getId());

		assertEquals(trace, traceRecuperer);

		EasyMock.verify(this.enregistrementTraceRequeteDAO);
	}

	@Test
	public void testRecupererTousEnregistrementTraceRequete() {
		ParametreEnregistrementTraceRequete p1 = new ParametreEnregistrementTraceRequete();
		ParametreEnregistrementTraceRequete p2 = new ParametreEnregistrementTraceRequete();

		Collection<ParametreEnregistrementTraceRequete> c = new ArrayList<ParametreEnregistrementTraceRequete>();
		c.add(p1);
		c.add(p2);

		EnregistrementTraceRequete trace = new EnregistrementTraceRequete();
		trace.setId(1);
		trace.setParametresRequeste(c);

		Collection<EnregistrementTraceRequete> cTrace = new ArrayList<EnregistrementTraceRequete>();
		cTrace.add(trace);

		EasyMock.expect(
				this.enregistrementTraceRequeteDAO.getAllEnregistrement())
				.andReturn(cTrace);

		EasyMock.replay(this.enregistrementTraceRequeteDAO);

		Collection<EnregistrementTraceRequete> cTraceRecuperer = this.enregistrementManager
				.recupererTousEnregistrementTraceRequete();

		assertEquals(cTrace, cTraceRecuperer);
		EasyMock.verify(this.enregistrementTraceRequeteDAO);
	}

}
