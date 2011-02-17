package fr.ecuriesduloup.secretflag.server;

import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import fr.ecuriesduloup.secretflag.client.SecretFlagService;
import fr.ecuriesduloup.secretflag.client.form.data.Data;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class SecretFlagServlet extends RemoteServiceServlet implements SecretFlagService {

	private static SecretFlagService secretFlagService;
	
	public static void setSecretFlagService(SecretFlagService secretFlagService){
		SecretFlagServlet.secretFlagService = secretFlagService;	
	}
	
	@Override
	public void saveData(List<Data> datas) {
		SecretFlagServlet.secretFlagService.saveData(datas);
		
	}

	@Override
	public List<Data> tryPassword(String password) {
		return SecretFlagServlet.secretFlagService.tryPassword(password);
	}


}
