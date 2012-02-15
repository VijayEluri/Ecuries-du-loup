package fr.ecuriesduloup.imagechooser.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.ecuriesduloup.imagechooser.shared.Album;

@RemoteServiceRelativePath("imagechooser")
public interface ImageChooserService extends RemoteService {
	
	public List<Album> getListAlbum();

}
