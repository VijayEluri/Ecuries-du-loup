package album_photo;

import java.util.List;

import donnees.User;
import donnees.photo.LectureAlbum;
import donnees.photo.Media;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class MediaDAOImpl extends HibernateIdLongBySpringDao<Media> implements MediaDAO {

	@Override
	public boolean isMediaSee(Media media, User connectedUSer) {
		String request = "SELECT m " +
				" FROM Media as m" +
				" WHERE m.id=? " +
				" and exists (" +
				"	from LectureAlbum as l where l.utilisateur.login=? and l.mediaVu = m"+
				" )";
		List<Media> medias = this.getHibernateTemplate().find(request, media.getId(), connectedUSer.getLogin());
		
		return !medias.isEmpty();
	}

	@Override
	public void seeMedia(Media media, User connectedUser) {
		LectureAlbum lecture = new LectureAlbum();
		lecture.setMediaVu(media);
		lecture.setUtilisateur(connectedUser);
		 this.getHibernateTemplate().save(lecture);
	}
}
