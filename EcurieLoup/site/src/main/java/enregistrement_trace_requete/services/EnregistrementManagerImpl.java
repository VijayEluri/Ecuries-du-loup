package enregistrement_trace_requete.services;

import java.util.Collection;

import enregistrement_trace_requete.dao.EnregistrementTraceRequeteDAO;
import enregistrement_trace_requete.donnees.EnregistrementTraceRequete;
import enregistrement_trace_requete.donnees.ParametreEnregistrementTraceRequete;

public class EnregistrementManagerImpl implements EnregistrementManager {
	private EnregistrementTraceRequeteDAO enregistrementTraceRequeteDAO;

	public void setEnregistrementTraceRequeteDAO(
			EnregistrementTraceRequeteDAO enregistrementTraceRequeteDAO) {
		this.enregistrementTraceRequeteDAO = enregistrementTraceRequeteDAO;
	}

	@Override
	public void enregistreTraceRequete(
			EnregistrementTraceRequete enregistrementTraceRequete) {

		for (ParametreEnregistrementTraceRequete parametreEnregistrementTraceRequete : enregistrementTraceRequete
				.getParametresRequeste()) {
			this.enregistrementTraceRequeteDAO
					.save(parametreEnregistrementTraceRequete);
		}

		this.enregistrementTraceRequeteDAO.save(enregistrementTraceRequete);
	}

	@Override
	public EnregistrementTraceRequete recupererEnregistrementTraceRequete(
			long id) {
		return this.enregistrementTraceRequeteDAO.getEnregistrement(id);
	}

	@Override
	public Collection<EnregistrementTraceRequete> recupererTousEnregistrementTraceRequete() {
		return this.enregistrementTraceRequeteDAO.getAllEnregistrement();
	}

}
