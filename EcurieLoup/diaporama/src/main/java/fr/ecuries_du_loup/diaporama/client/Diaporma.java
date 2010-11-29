package fr.ecuries_du_loup.diaporama.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import fr.ecuries_du_loup.diaporama.client.control.DiaporamaControlImpl;
import fr.ecuries_du_loup.diaporama.client.engine.PictureLoader;
import fr.ecuries_du_loup.diaporama.client.engine.PictureLoaderAsync;
import fr.ecuries_du_loup.diaporama.client.engine.Scheduler;
import fr.ecuries_du_loup.diaporama.client.engine.SchedulerImpl;
import fr.ecuries_du_loup.diaporama.client.engine.navigator.Navigator;
import fr.ecuries_du_loup.diaporama.client.engine.navigator.NavigatorSelector;
import fr.ecuries_du_loup.diaporama.client.engine.navigator.RandomNavigator;
import fr.ecuries_du_loup.diaporama.client.engine.navigator.SequentialNavigator;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Diaporma implements EntryPoint {
	

	
	private final PictureLoaderAsync pictureLoader = GWT.create(PictureLoader.class);
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		
		Navigator navigatorRandom = new RandomNavigator();
		Navigator navigatorSequential= new SequentialNavigator();
		
		NavigatorSelector navigatorSelector = new NavigatorSelector();
		navigatorSelector.addNavigator("sequential", navigatorSequential);
		navigatorSelector.addNavigator("random", navigatorRandom);
		navigatorSelector.setNavigator("sequential");
		
		DiaporamaControlImpl diaporamaControl = new DiaporamaControlImpl(); 
		
		diaporamaControl.setNavigator(navigatorSelector);
		diaporamaControl.setPictureLoader(pictureLoader);
		
		DiaporamaPanel diaporamaPanel = new DiaporamaPanel(diaporamaControl);
		
		diaporamaControl.setIhm(diaporamaPanel);
		Scheduler scheduler = new SchedulerImpl(navigatorSelector);
		
		((RandomNavigator)navigatorRandom).setDiaporamaControl(diaporamaControl);
		((SequentialNavigator)navigatorSequential).setDiaporamaControl(diaporamaControl);
		diaporamaControl.setScheduler(scheduler);
		
		//choose pictures
		String album = Window.Location.getParameter("album");
		if(album==null){
			diaporamaControl.loadAllPicture();
		}else{
			int numAlbum = Integer.parseInt(album);
			diaporamaControl.loadAlbum(numAlbum);
		}
		
		
		diaporamaPanel.setStyleName("diaporama");
		RootPanel.get("nameFieldContainer").add(diaporamaPanel);
	}
}
