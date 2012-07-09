package album_photo;

import java.util.List;

import donnees.User;
import donnees.photo.Media;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;

public interface MediaDAO extends DaoIdLongUtil<Media> {
    public boolean isMediaSee(Media media, User connectedUser);

    public void seeMedia(Media media, User connectedUser);

    public List<Media> getMediasNotSee(User connectedUser);

    public List<Tag> getMediasTags(long mediaId);

    public List<Commentaire> getMediasComments(long mediaId);
}
