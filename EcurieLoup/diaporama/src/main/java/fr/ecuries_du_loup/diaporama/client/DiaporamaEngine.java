package fr.ecuries_du_loup.diaporama.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
//@RemoteServiceRelativePath("diaporama")
public interface DiaporamaEngine extends RemoteService {
	public List<Integer> getIdPhoto();
}
