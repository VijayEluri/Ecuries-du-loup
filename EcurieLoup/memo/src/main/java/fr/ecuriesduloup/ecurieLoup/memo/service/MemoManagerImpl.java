package fr.ecuriesduloup.ecurieLoup.memo.service;

import java.util.Date;
import java.util.List;

import service.UtilisateurManager;
import donnees.User;
import fr.ecurie_du_loup.generique_util.service.DataBaseServiceWithDaoIdLongUtilAndLongId;
import fr.ecuriesduloup.ecurieLoup.memo.dao.MemoDao;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;

public class MemoManagerImpl extends DataBaseServiceWithDaoIdLongUtilAndLongId<Memo> implements MemoManager {
	private UtilisateurManager utilisateurManager;
	
	
	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public List<Memo> getRequests(User user) {
		return this.manageMemo(((MemoDao) this.dao).getRequests(user));
	}

	private List<Memo> manageMemo(List<Memo> memos){
		for(Memo memo : memos){
			User receiver = memo.getReceiver();
			long dateViewMemoByReceiver = ((MemoDao) this.dao).getDateReadinMemos(receiver);
			
			memo.setViewByReceiver(memo.getPostedDate() < dateViewMemoByReceiver);
		}
		return memos;
	}
	@Override
	public List<Memo> getTasks(User user) {
		return this.manageMemo(((MemoDao) this.dao).getTasks(user));
	}

	@Override
	public List<Memo> getNewsMemosForConnectedUser() {
		User userConnected = this.utilisateurManager.getUtilisateurCourant();
		return ((MemoDao) this.dao).getNewsMemos(userConnected);
	}

	@Override
	public boolean hasNewTaskForConnectedUser() {
		
		return !this.getNewsMemosForConnectedUser().isEmpty();
	}

	@Override
	public void readMemosForConnectedUser() {
		User userConnected = this.utilisateurManager.getUtilisateurCourant();
		long currentTime = new Date().getTime();
		((MemoDao) this.dao).readMemos(userConnected, currentTime );
		
	}
}
