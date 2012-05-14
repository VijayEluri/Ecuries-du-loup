package album_photo;

import donnees.User;
import donnees.photo.Media;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface MediaDAO extends DaoIdLongUtil<Media> {
	public boolean isMediaSee(Media media, User connectedUser);
	public void seeMedia(Media media, User connectedUser);
}
