package album_photo;

import java.util.List;

import donnees.User;
import donnees.photo.LectureAlbum;
import donnees.photo.Media;
import donnees.photo.Tag;
import donnees.photo.commentaire.Commentaire;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class MediaDAOImpl extends HibernateIdLongBySpringDao<Media> implements MediaDAO {

    @Override
    public boolean isMediaSee(Media media, User connectedUser) {
	String request = "SELECT m " + " FROM Media as m" + " WHERE m.id=? " + " and exists (" + "	from LectureAlbum as l where l.utilisateur.login=? and l.mediaVu = m" + " )";
	List<Media> medias = this.getHibernateTemplate().find(request, media.getId(), connectedUser.getLogin());

	return !medias.isEmpty();
    }

    @Override
    public void seeMedia(Media media, User connectedUser) {
	LectureAlbum lecture = new LectureAlbum();
	lecture.setMediaVu(media);
	lecture.setUtilisateur(connectedUser);
	this.getHibernateTemplate().save(lecture);
    }

    @Override
    public List<Media> getMediasNotSee(User connectedUser) {
	String request = "SELECT m " + " FROM Media as m" + " WHERE not exists (" + "	from LectureAlbum as l where l.utilisateur.login=? and l.mediaVu = m" + " )";
	List<Media> medias = this.getHibernateTemplate().find(request, connectedUser.getLogin());

	return medias;
    }

    @Override
    protected String getOrderByOfFindAll() {
	return " ORDER BY t.shotDate";
    }

    @Override
    public List<Tag> getMediasTags(long mediaId) {
	String request = "SELECT t FROM Tag as t WHERE t.photo.id=?";
	List<Tag> tags = this.getHibernateTemplate().find(request, mediaId);

	return tags;
    }

    @Override
    public List<Commentaire> getMediasComments(long mediaId) {
	String request = "SELECT c FROM Commentaire as c WHERE c.media.id=?";
	List<Commentaire> comments = this.getHibernateTemplate().find(request, mediaId);
	return comments;
    }
}
