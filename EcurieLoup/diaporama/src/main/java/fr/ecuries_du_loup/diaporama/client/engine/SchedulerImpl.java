package fr.ecuries_du_loup.diaporama.client.engine;

import com.google.gwt.user.client.Timer;

import fr.ecuries_du_loup.diaporama.client.engine.navigator.Navigator;

public class SchedulerImpl implements Scheduler{
	
	private Navigator navigator;
	private Timer timer;
	
	private int interval = 5;
	private boolean isEnabled;
	
	public SchedulerImpl(Navigator navigator){
		this.navigator = navigator;
		this.timer = new Timer() {
			
			@Override
			public void run() {
				SchedulerImpl.this.navigator.next();
				
			}
		};
		
	}
	
	@Override
	public void reinitializeWanted() {
		if(this.isEnabled){
			this.stop();
			this.start();
		}
		
	}

	@Override
	public void setIntervalInSecond(int interval) {
		this.interval = interval;
		
	}

	@Override
	public void start() {
		this.isEnabled = true;
		this.timer.scheduleRepeating(this.interval * 1000);
		
	}

	@Override
	public void stop() {
		this.isEnabled = false;
		this.timer.cancel();
		
	}

}
