package fr.ecuriesduloup.site.facebook.api;

import javax.servlet.http.HttpServletRequest;

import com.google.code.facebookapi.FacebookException;
import com.google.code.facebookapi.FacebookXmlRestClient;

public class FacebookMangerImpl implements FacebookManager {
	private String apiKey;
	private String secret;

	@Override
	public String getIdentifiantFacebook(HttpServletRequest request)
			throws NoSessionKeyException {
		String sessionKey = request.getParameter("fb_sig_session_key");
		if (sessionKey == null) {
			throw new NoSessionKeyException();
		}
		FacebookXmlRestClient client = new FacebookXmlRestClient(this.apiKey,
				this.secret, sessionKey);
		try {
			return "" + client.users_getLoggedInUser();
		} catch (FacebookException e) {
			return "";
		}
	}

	@Override
	public String getApiKey() {
		return this.apiKey;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

}
