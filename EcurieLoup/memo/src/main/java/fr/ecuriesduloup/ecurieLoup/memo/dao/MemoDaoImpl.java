package fr.ecuriesduloup.ecurieLoup.memo.dao;

import java.util.Date;
import java.util.List;

import donnees.User;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;
import fr.ecuriesduloup.ecurieLoup.memo.data.ReadingMemo;

public class MemoDaoImpl extends HibernateIdLongBySpringDao<Memo> implements MemoDao {

	@Override
	protected String getOrderByOfFindAll() {
		return "ORDER BY t.deadLine ASC";
	}
	@Override
	public List<Memo> getRequests(User user) {
		String query = "Select t FROM Memo t WHERE t.sender.login='"+user.getLogin()+"' "+this.getOrderByOfFindAll();
		List<Memo> memosRequests = this.getHibernateTemplate().find(query);
		return memosRequests;
	}

	@Override
	public List<Memo> getTasks(User user) {
		String query = "Select t FROM Memo t WHERE t.receiver.login='"+user.getLogin()+"' AND t.memoIsDo='false' "+this.getOrderByOfFindAll();
		List<Memo> memosTasks = this.getHibernateTemplate().find(query);
		return memosTasks;
	}
	@Override
	public List<Memo> getNewsMemos(User user) {
		long readingDate = this.getDateReadinMemos(user);
		
		String requete = "SELECT t FROM Memo as t WHERE t.receiver.login='"+user.getLogin()+"' AND t.memoIsDo='false' AND t.postedDate > '"+readingDate+"' "+this.getOrderByOfFindAll();
		List<Memo> memos = this.getHibernateTemplate().find(requete);
		return memos;
	}
	@Override
	public void readMemos(User user, long readDate) {
		String requete = "SELECT l FROM ReadingMemo as l WHERE l.user='"+user.getLogin()+"'";
		List<ReadingMemo> readings = this.getHibernateTemplate().find(requete);
		
		long date = new Date().getTime();
		
		ReadingMemo readingMemo;
		if(readings.isEmpty()){
			readingMemo = new ReadingMemo();
			readingMemo.setUser(user.getLogin());
			readingMemo.setDateOfSee(date);
			 this.getHibernateTemplate().save(readingMemo);
		}else{
			readingMemo = readings.get(0);
			readingMemo.setDateOfSee(date);
			 this.getHibernateTemplate().update(readingMemo);
		}
		
	}
	@Override
	public long getDateReadinMemos(User user) {
		String requete = "SELECT l.dateOfSee FROM ReadingMemo as l WHERE l.user='"+user.getLogin()+"'";
		List<Long> readings = this.getHibernateTemplate().find(requete);
		long date = 0;
		if(!readings.isEmpty()){
			date = readings.get(0);
		}
		return date;
	}
}
