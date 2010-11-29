package enregistrement_trace_requete.services;

import java.util.Collection;

import enregistrement_trace_requete.donnees.EnregistrementTraceRequete;

public interface EnregistrementManager {

	public void enregistreTraceRequete(
			EnregistrementTraceRequete enregistrementTraceRequete);

	public EnregistrementTraceRequete recupererEnregistrementTraceRequete(
			long id);

	public Collection<EnregistrementTraceRequete> recupererTousEnregistrementTraceRequete();
}
