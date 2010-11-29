package enregistrement_trace_requete.donnees;

import java.util.Collection;
import java.util.HashSet;

public class EnregistrementTraceRequete {
	private long id;
	private long date;

	private String userAgent;
	private String referer;

	private String uri;
	private String remoteAdress;

	private Collection<ParametreEnregistrementTraceRequete> parametresRequeste;

	public EnregistrementTraceRequete() {
		// TODO : voir dans hibernate pour avoir des collection plutot que des
		// sets
		this.parametresRequeste = new HashSet<ParametreEnregistrementTraceRequete>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getRemoteAdress() {
		return remoteAdress;
	}

	public void setRemoteAdress(String remoteAdress) {
		this.remoteAdress = remoteAdress;
	}

	public Collection<ParametreEnregistrementTraceRequete> getParametresRequeste() {
		return parametresRequeste;
	}

	public void setParametresRequeste(
			Collection<ParametreEnregistrementTraceRequete> parametresRequeste) {
		this.parametresRequeste = parametresRequeste;
	}

}
