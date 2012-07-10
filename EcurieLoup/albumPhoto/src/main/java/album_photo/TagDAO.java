package album_photo;

import java.util.List;

import donnees.User;
import donnees.photo.Tag;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface TagDAO extends DaoIdLongUtil<Tag> {
    public List<Tag> getTagOnUser(User user);

    public List<Tag> getTagOnHorse(long horseId);
}
