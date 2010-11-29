package dao.photo;

import donnees.User;
import donnees.photo.Album;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface AlbumDAO extends DaoIdLongUtil<Album>{

	public long getReadingDate(Album album, User currentUser);
	public void seeAlbum(Album album, User currentUser);
}
