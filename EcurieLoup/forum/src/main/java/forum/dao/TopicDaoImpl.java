package forum.dao;

import java.util.Date;
import java.util.List;

import donnees.User;
import forum.donnees.Lecture;
import forum.donnees.Message;
import forum.donnees.Topic;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;

public class TopicDaoImpl extends HibernateIdLongBySpringDao<Topic> implements TopicDao {

	@Override
	public void readTopic(Topic topic, User userConnected) {
		String requete = "SELECT l FROM Lecture as l WHERE l.topicLu.id='"+topic.getId()+"' AND l.utilisateur.login='"+userConnected.getLogin()+"'";
		List<Lecture> lectures = this.getHibernateTemplate().find(requete);
		
		long date = new Date().getTime();
		
		Lecture lecture;
		if(lectures.isEmpty()){
			lecture = new Lecture();
			lecture.setTopicLu(topic);
			lecture.setUtilisateur(userConnected);
			lecture.setHeureLecture(date);
			 this.getHibernateTemplate().save(lecture);
		}else{
			lecture = lectures.get(0);
			lecture.setHeureLecture(date);
			 this.getHibernateTemplate().update(lecture);
		}
		
	}
	
	
	@Override
	public long getReadingDate(Topic topic, User userConnected) {
		long dateLecture = 0;
		try {
			String requete = "SELECT l.heureLecture FROM Lecture as l WHERE l.topicLu.id='"+topic.getId()+"' AND l.utilisateur.login='"+userConnected.getLogin()+"'";
			dateLecture = (Long) this.getHibernateTemplate().find(requete).get(0);
		}catch (IndexOutOfBoundsException e) {
		}
		return dateLecture;
	}
	
	@Override
	public Message getFirstMessageNotRead(Topic topic, User utilisateurConnecte) {
		if(topic != null){
			String requete = "SELECT m FROM Message as m WHERE m.topic.id="+topic.getId()+" AND m.datePostage > "+this.getReadingDate(topic, utilisateurConnecte)+" ORDER BY m.datePostage asc LIMIT 0, 1";
			List<Message> messages = this.getHibernateTemplate().find(requete);
			if(messages.isEmpty()){
				
				return this.getLastMessage(topic);
			}else{
				return messages.get(0);
			}
		}else{
			return new Message();
		}
	}
	
	@Override
	public Message getLastMessage(Topic topic) {
		if(topic != null){
			String requete = "SELECT m FROM Message as m WHERE m.topic.id="+topic.getId()+" ORDER BY m.datePostage desc LIMIT 0, 1";
			List<Message> messages= this.getHibernateTemplate().find(requete);
			if(messages.isEmpty()){
				return new Message();
			}else{
				return messages.get(0);
			}
		}else{
			return new Message();
		}

	}

}
