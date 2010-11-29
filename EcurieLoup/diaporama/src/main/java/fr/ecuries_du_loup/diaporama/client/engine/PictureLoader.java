package fr.ecuries_du_loup.diaporama.client.engine;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.ecuries_du_loup.diaporama.shared.data.Picture;

@RemoteServiceRelativePath("diaporama")
public interface PictureLoader  extends RemoteService {

	public List<Picture> loadAlbum(long idAlbum);
	
	public List<Picture> loadAllPicture();	
}
