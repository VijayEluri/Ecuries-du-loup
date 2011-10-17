package fr.ecuriesduloup.webnotifier.client.ui.news;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Cursor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.SimplePanel;

import fr.ecuriesduloup.webnotifier.client.NotifierResources;

public class Notifier extends Composite{

	protected static final NotifierResources notifierResources = GWT.create(NotifierResources.class);

	private SimplePanel panel;
	private NotifierService notifierService;
	private int secondeBetweenRefresh;
	private Timer timer;

	public Notifier(NotifierService notifierService, int secondeBetweenRefresh, String message,final String url) {
		panel = new SimplePanel();
		panel.setVisible(false);
		this.notifierService = notifierService;
		this.secondeBetweenRefresh = secondeBetweenRefresh;
		
		ImageResource img = notifierResources.notRead();
		Image image = new Image(img);
		image.setTitle(message);
		
		image.getElement().getStyle().setCursor(Cursor.POINTER);
		image.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				Window.open(url, "_self", "");

			}
		});
		panel.add(image);


		this.initWidget(panel);
	}

	public void news(){
		this.panel.setVisible(true);
	}

	public void nothingNew(){
		this.setVisible(false);
	}

	public void run(){
		if(this.timer == null){
			this.timer = new Timer() {
				public void run() {
					notifierService.maj();				
				}
			};
			notifierService.maj();
		}else{
			this.timer.schedule(this.secondeBetweenRefresh *1000);
		}

	}

	public static Notifier createMediaNotifier(){
		MediaNotifierService notifierService = new MediaNotifierService();
		Notifier mediaNotifier = new Notifier(notifierService, 5*60, "Nouvelles photos", getContext()+"/albumPhoto/affichage.do?nonVu");
		notifierService.setNotifier(mediaNotifier);
		return mediaNotifier;

	}
	
	public static Notifier createForumNotifier(){
		ForumNotifierService notifierService = new ForumNotifierService();
		Notifier forumNotifier = new Notifier(notifierService, 5*60, "Nouvelles réponses",getContext()+"/forum/affichage.do?nonLu");
		notifierService.setNotifier(forumNotifier);
		return forumNotifier;

	}
	
	private static native String getContext()/*-{
    	return $wnd.ctx;

	}-*/;
}
