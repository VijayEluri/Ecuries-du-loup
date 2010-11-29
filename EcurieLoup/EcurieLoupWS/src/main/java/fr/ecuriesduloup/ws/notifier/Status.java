package fr.ecuriesduloup.ws.notifier;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("status")
public class Status {
	
	private boolean hasNew;
	private long timeLastAction;
	
	public boolean isHasNew() {
		return hasNew;
	}
	public void setHasNew(boolean hasNew) {
		this.hasNew = hasNew;
	}
	public long getTimeLastAction() {
		return timeLastAction;
	}
	public void setTimeLastAction(long timeLastAction) {
		this.timeLastAction = timeLastAction;
	}
	
	@Override
	public String toString() {
		return "status : "+hasNew +" ; "+timeLastAction;
	}
	
}
