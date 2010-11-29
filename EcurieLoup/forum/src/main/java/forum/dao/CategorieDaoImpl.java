package forum.dao;

import donnees.User;
import forum.donnees.Categorie;
import forum.donnees.Topic;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class CategorieDaoImpl extends HibernateIdLongBySpringDao<Categorie> implements CategorieDao {

	@Override
	public int countNewMessage(User userConnected){
		int nombreNouveauxMessage = 0;

		for(Categorie categorie : this.findAll()){
			for(Topic topic : categorie.getTopics()){
				if(topic!= null){
					long dateLectureTopic = this.getDateLecture(topic, userConnected);

					String requeteNouveauMessageTopic = "SELECT count(m) FROM Message as m WHERE m.datePostage >='" +dateLectureTopic+"' AND m.topic.id='"+topic.getId()+"'";
					nombreNouveauxMessage += (Long) this.getHibernateTemplate().find(requeteNouveauMessageTopic).get(0);

				}
			}
		}



		return nombreNouveauxMessage;
	}
	
	private long getDateLecture(Topic topic, User userConnected) {
		long dateLecture = 0;
		try {
			String requete = "SELECT l.heureLecture FROM Lecture as l WHERE l.topicLu.id='"+topic.getId()+"' AND l.utilisateur.login='"+userConnected.getLogin()+"'";
			dateLecture = (Long) this.getHibernateTemplate().find(requete).get(0);
		}catch (IndexOutOfBoundsException e) {
		}
		return dateLecture;
	}
}
