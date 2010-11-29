package fr.ecuriesduloup.ecurieLoup.memo.service;

import java.util.List;

import donnees.User;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithLongId;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;

public interface MemoManager extends DataBaseServiceWithLongId<Memo>{

	@Override
	public void add(Memo t);
	
	public List<Memo> getTasks(User user);

	public List<Memo> getRequests(User user);
	
	public boolean hasNewTaskForConnectedUser();
	
	public void readMemosForConnectedUser();
	
	public List<Memo> getNewsMemosForConnectedUser();

}
