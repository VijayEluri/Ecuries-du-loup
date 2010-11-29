package enregistrement_trace_requete.dao;

import java.util.Collection;

import enregistrement_trace_requete.donnees.EnregistrementTraceRequete;
import enregistrement_trace_requete.donnees.ParametreEnregistrementTraceRequete;

public interface EnregistrementTraceRequeteDAO {

	public void save(EnregistrementTraceRequete enregistrementTraceRequete);

	public void save(
			ParametreEnregistrementTraceRequete parametreEnregistrementTraceRequete);

	public EnregistrementTraceRequete getEnregistrement(long id);

	public Collection<EnregistrementTraceRequete> getAllEnregistrement();
}
