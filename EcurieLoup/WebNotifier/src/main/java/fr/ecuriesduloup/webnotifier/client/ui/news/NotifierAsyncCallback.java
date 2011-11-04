package fr.ecuriesduloup.webnotifier.client.ui.news;

import com.google.gwt.user.client.rpc.AsyncCallback;

public class NotifierAsyncCallback implements AsyncCallback<Integer> {
	private Notifier notifier;
	
	public NotifierAsyncCallback(Notifier notifier) {
		this.notifier= notifier;
	}
	
	@Override
	public void onSuccess(Integer result) {
		if(result > 0){
			this.notifier.news();
		}else{
			this.notifier.nothingNew();
		}
		this.notifier.run();
	}
	
	@Override
	public void onFailure(Throwable caught) {
		/*String echo = "erreur : ";
		for(StackTraceElement ste: caught.getStackTrace()){
			echo += ste.toString();
		}
		Window.alert(echo);*/
		notifier.run();
		
	}
}
