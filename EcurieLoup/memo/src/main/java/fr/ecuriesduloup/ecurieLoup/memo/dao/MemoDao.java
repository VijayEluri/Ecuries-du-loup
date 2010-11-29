package fr.ecuriesduloup.ecurieLoup.memo.dao;

import java.util.List;

import donnees.User;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;

public interface MemoDao extends DaoIdLongUtil<Memo>{
	public List<Memo> getTasks(User user);

	public List<Memo> getRequests(User user);
	
	public List<Memo> getNewsMemos(User user);
	
	public void readMemos(User user, long readDate);

	public long getDateReadinMemos(User user);
}
