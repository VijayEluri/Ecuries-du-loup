package integration.service;

import static org.junit.Assert.assertEquals;
import integration.ContextManager;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import service.VracManager;
import donnees.Vrac;

public class VracManagerTest {
	private VracManager vracManager;
	private ApplicationContext context;

	public VracManagerTest() {
		this.context = ContextManager.getContext();
	}

	@Before
	public void setUp() {

		this.vracManager = (VracManager) this.context.getBean("vracManager");

	}

	@Test
	public void testRecupererVrac() {
		String contenuVracAttendu = "[gras]edito super genial[/gras]\n\nviva moi[:p]";

		Vrac vrac = this.vracManager.recupererVrac("edito");
		assertEquals(vrac.getContenu(), contenuVracAttendu);
	}

	@Test
	public void testModifierVrac() {
		String contenuVracAttendu = "[gras]edito super genial[/gras]\n\nviva moi[:p]";

		Vrac vrac = this.vracManager.recupererVrac("edito");

		String contenuModifier = "test de modification de vrac";
		vrac.setContenu(contenuModifier);
		this.vracManager.modifierVrac(vrac);
		assertEquals(vrac.getContenu(), contenuModifier);

		vrac.setContenu(contenuVracAttendu);
		this.vracManager.modifierVrac(vrac);
		assertEquals(vrac.getContenu(), contenuVracAttendu);
	}

}
