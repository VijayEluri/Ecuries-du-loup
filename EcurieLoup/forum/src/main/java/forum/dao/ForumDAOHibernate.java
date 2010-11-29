//package forum.dao;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
//
//import donnees.User;
//import forum.donnees.Categorie;
//import forum.donnees.Lecture;
//import forum.donnees.Message;
//import forum.donnees.Topic;
//
//public class ForumDAOHibernate extends HibernateDaoSupport implements ForumDAO {
//
//	@Override
//	public List<Categorie> getAllCategories() {
//		List<Categorie> find = this.getHibernateTemplate().loadAll(Categorie.class);
//		return find;
//	}
//
//	@Override
//	public Categorie getCategorie(int id) {
//		return (Categorie) this.getHibernateTemplate().get(Categorie.class, id);
//	}
//
//	@Override
//	public Message getMessage(long id) {
//		return (Message) this.getHibernateTemplate().get(Message.class, id);
//
//	}
//
//	@Override
//	public Topic getTopic(long id) {
//		Topic topic = (Topic) this.getHibernateTemplate().get(Topic.class, id);
//		return topic;
//
//	}
//
//	@Override
//	public void save(Message message) {
//		this.getHibernateTemplate().save(message);
//	}
//
//	@Override
//	public void save(Topic topic) {
//		this.getHibernateTemplate().save(topic);
//	}
//
//	@Override
//	public void save(Categorie categorie) {
//		this.getHibernateTemplate().save(categorie);
//	}
//
//	@Override
//	public void update(Message message) {
//		this.getHibernateTemplate().update(message);
//	}
//
//	@Override
//	public void update(Topic topic) {
//		this.getHibernateTemplate().update(topic);
//	}
//
//	@Override
//	public void update(Categorie categorie) {
//		this.getHibernateTemplate().update(categorie);
//	}
//
//	@Override
//	public void delete(Message message) {
//		this.getHibernateTemplate().delete(message);
//	}
//
//	@Override
//	public void delete(Topic topic) {
//		this.getHibernateTemplate().delete(topic);
//	}
//
//	@Override
//	public void delete(Categorie categorie) {
//		this.getHibernateTemplate().delete(categorie);
//	}
//
//	@Override
//	public List<Topic> getTopicsCatgeries(int idCategorie) {
//		String requete = "SELECT t FROM Topic as t WHERE t.categorie.id='"+idCategorie+"'";
//		return this.getHibernateTemplate().find(requete);
//	}
//	@Override
//	public Message getLastMessage(Topic topic) {
//		if(topic != null){
//			String requete = "SELECT m FROM Message as m WHERE m.topic.id="+topic.getId()+" ORDER BY m.datePostage desc LIMIT 0, 1";
//			return (Message) this.getHibernateTemplate().find(requete).get(0);
//		}else{
//			return new Message();
//		}
//
//	}
//
//	@Override
//	public long getDateLecture(Topic topic, User utilisateurConnecte) {
//		long dateLecture = 0;
//		try {
//			String requete = "SELECT l.heureLecture FROM Lecture as l WHERE l.topicLu.id='"+topic.getId()+"' AND l.utilisateur.login='"+utilisateurConnecte.getLogin()+"'";
//			dateLecture = (Long) this.getHibernateTemplate().find(requete).get(0);
//		}catch (IndexOutOfBoundsException e) {
//		}
//		return dateLecture;
//	}
//
//	@Override
//	public Message getPremierMessageNonLu(Topic topic, User utilisateurConnecte) {
//		if(topic != null){
//			String requete = "SELECT m FROM Message as m WHERE m.topic.id="+topic.getId()+" AND m.datePostage > "+this.getDateLecture(topic, utilisateurConnecte)+" ORDER BY m.datePostage asc LIMIT 0, 1";
//			List<Message> messages = this.getHibernateTemplate().find(requete);
//			if(messages.isEmpty()){
//				
//				return this.getLastMessage(topic);
//			}else{
//				return messages.get(0);
//			}
//		}else{
//			return new Message();
//		}
//	}
//	
//	@Override
//	public void lectureTopic(Topic topic, User utilisateurConnecte) {
//		String requete = "SELECT l FROM Lecture as l WHERE l.topicLu.id='"+topic.getId()+"' AND l.utilisateur.login='"+utilisateurConnecte.getLogin()+"'";
//		List<Lecture> lectures = this.getHibernateTemplate().find(requete);
//		
//		long date = new Date().getTime();
//		
//		Lecture lecture;
//		if(lectures.isEmpty()){
//			lecture = new Lecture();
//			lecture.setTopicLu(topic);
//			lecture.setUtilisateur(utilisateurConnecte);
//			lecture.setHeureLecture(date);
//			 this.getHibernateTemplate().save(lecture);
//		}else{
//			lecture = lectures.get(0);
//			lecture.setHeureLecture(date);
//			 this.getHibernateTemplate().update(lecture);
//		}
//		
//	}
//
//	@Override
//	public int getNombreNouveauxMessage(User utilisateurConnecte) {
//		int nombreNouveauxMessage = 0;
//		
//			for(Categorie categorie : this.getAllCategories()){
//				for(Topic topic : categorie.getTopics()){
//					if(topic!= null){
//						long dateLectureTopic = this.getDateLecture(topic, utilisateurConnecte);
//						
//						String requeteNouveauMessageTopic = "SELECT count(m) FROM Message as m WHERE m.datePostage >='" +dateLectureTopic+"' AND m.topic.id='"+topic.getId()+"'";
//						nombreNouveauxMessage += (Long) this.getHibernateTemplate().find(requeteNouveauMessageTopic).get(0);
//						
//					}
//				}
//			}
//			
//			
//		
//		return nombreNouveauxMessage;
//	}
//}
