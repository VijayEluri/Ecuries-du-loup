package dao.photo;

import java.util.Date;
import java.util.List;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.LectureAlbum;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class AlbumDAOImpl extends HibernateIdLongBySpringDao<Album> implements AlbumDAO {
	
	@Override
	public long getReadingDate(Album album, User utilisateurCourant) {
		long dateLecture = 0;
		try {
			String requete = "SELECT l.heureLecture FROM LectureAlbum as l WHERE l.albumVu.id='"+album.getId()+"' AND l.utilisateur.login='"+utilisateurCourant.getLogin()+"'";
			dateLecture = (Long) this.getHibernateTemplate().find(requete).get(0);
		}catch (IndexOutOfBoundsException e) {
			 dateLecture = 0;
		}
		return dateLecture;
	}

	@Override
	public void seeAlbum(Album album, User utilisateurCourant) {
		String requete = "SELECT l FROM LectureAlbum as l WHERE l.albumVu.id='"+album.getId()+"' AND l.utilisateur.login='"+utilisateurCourant.getLogin()+"'";
		List<LectureAlbum> lectures = this.getHibernateTemplate().find(requete);
		
		long date = new Date().getTime();
		
		LectureAlbum lecture;
		if(lectures.isEmpty()){
			lecture = new LectureAlbum();
			lecture.setAlbumVu(album);
			lecture.setUtilisateur(utilisateurCourant);
			lecture.setHeureLecture(date);
			 this.getHibernateTemplate().save(lecture);
		}else{
			lecture = lectures.get(0);
			lecture.setHeureLecture(date);
			 this.getHibernateTemplate().update(lecture);
		}
		
	}
}
