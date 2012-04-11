package album_photo;

import java.util.List;

import donnees.User;
import donnees.photo.Tag;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class TagDAOImpl extends HibernateIdLongBySpringDao<Tag> implements TagDAO {

	@Override
	public List<Tag> getTagOnUser(User user) {
		return this.getTagWithFoName(user.getLogin());
	}

	@Override
	public List<Tag> getTagOnHorse(long horseId) {
		return this.getTagWithFoName(horseId+"");
	}
	
	private List<Tag> getTagWithFoName(String name){
		String requete = "SELECT tag FROM Tag as tag WHERE tag.nom = ? ORDER BY  tag.photo.datePostage DESC ";
		return this.getHibernateTemplate().find(requete, name);
	}
}
