package fr.ecuriesduloup.imagechooser.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.ecuriesduloup.imagechooser.shared.Album;

public interface ImageChooserServiceAsync {
	public void getListAlbum(AsyncCallback<List<Album>> asyncCallback);
}
