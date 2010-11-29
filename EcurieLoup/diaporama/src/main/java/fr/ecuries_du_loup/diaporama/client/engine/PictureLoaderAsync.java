package fr.ecuries_du_loup.diaporama.client.engine;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.ecuries_du_loup.diaporama.shared.data.Picture;

public interface PictureLoaderAsync {

	public void loadAlbum(long idAlbum, AsyncCallback<List<Picture>> callback);

	public void loadAllPicture(AsyncCallback<List<Picture>> callback);

}
