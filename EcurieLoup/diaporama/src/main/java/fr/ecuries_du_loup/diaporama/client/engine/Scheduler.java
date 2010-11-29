package fr.ecuries_du_loup.diaporama.client.engine;

public interface Scheduler {

	public void setIntervalInSecond(int interval);
	
	public void start();
	public void stop();
	
	public void reinitializeWanted();
	
}
