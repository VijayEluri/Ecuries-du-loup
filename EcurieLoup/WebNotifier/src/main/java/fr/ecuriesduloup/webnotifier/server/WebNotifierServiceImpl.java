package fr.ecuriesduloup.webnotifier.server;

import service.photo.MediaManager;
import forum.service.ForumManager;
import fr.ecuriesduloup.webnotifier.client.WebNotifierService;

public class WebNotifierServiceImpl implements WebNotifierService {
	private ForumManager forumManager;
	private MediaManager mediaManager;
	
	
	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}
	public void setMediaManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}
	
	@Override
	public int getNumberNotReadMedia() {
		return this.mediaManager.getNombreNouvellesMedias();
	}
	@Override
	public int getNumberNotReadForum() {
		return this.forumManager.getNombreNouveauxMessages();
	}

}
