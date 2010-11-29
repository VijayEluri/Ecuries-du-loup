package fr.ecuriesduloup.site.facebook.api;

import javax.servlet.http.HttpServletRequest;

public interface FacebookManager {

	public String getIdentifiantFacebook(HttpServletRequest request)
			throws NoSessionKeyException;

	public String getApiKey();
}
