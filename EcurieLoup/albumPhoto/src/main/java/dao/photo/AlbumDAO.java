package dao.photo;

import java.util.List;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface AlbumDAO extends DaoIdLongUtil<Album>{

	public boolean isAlbumHasNotSeeMedia(Album album, User utilisateurCourant);
	public List<Media> getMediaReadForAlbum(Album album, User utilisateurCourant);
}
