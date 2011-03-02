package fr.ecuriesduloup.edlwyswig.server;

import fr.ecuriesduloup.edlwyswig.client.GreetingService;

/**
 * The server side implementation of the RPC service.
 */

public class GreetingServiceImpl implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		
		
		return "Hello, " + input + "!<br><br>I am running " + ".<br><br>It looks like you are using:<br>" ;
	}
}
