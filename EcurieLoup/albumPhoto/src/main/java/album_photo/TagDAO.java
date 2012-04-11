package album_photo;

import java.util.List;

import donnees.User;
import donnees.photo.Tag;
import fr.ecurie_du_loup.generique_util.dao.DaoUtil;

public interface TagDAO extends DaoUtil<Tag> {
	public List<Tag> getTagOnUser(User user);
	public List<Tag> getTagOnHorse(long horseId);
}
