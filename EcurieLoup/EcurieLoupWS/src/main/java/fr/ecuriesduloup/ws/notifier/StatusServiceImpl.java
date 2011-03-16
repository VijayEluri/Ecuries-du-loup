package fr.ecuriesduloup.ws.notifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import service.photo.MediaManager;
import donnees.photo.Media;
import forum.donnees.Message;
import forum.service.ForumManager;
@Service
public class StatusServiceImpl implements NotifierService{
	@Autowired
	private ForumManager forumManager;
	@Autowired
	private MediaManager mediaManager;
	
	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}

	
	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}


	@Override
	public Status getForumStatus() {
		boolean newMessage = this.forumManager.hasNouveauxMessages();
		Message lastMessage = this.forumManager.getLastMessage();
		Status status = new Status();
		status.setHasNew(newMessage);
		status.setTimeLastAction(lastMessage.getDatePostage());
		
		return status;
		
	}
	
	@Override
	public Status getAlbumPhotoStatus() {
		boolean newMedia = this.mediaManager.hasNouvellesMedias();
		Media lastMedia = this.mediaManager.getLastMedia();
		Status status = new Status();
		status.setHasNew(newMedia);
		status.setTimeLastAction(lastMedia.getDatePostage());
		
		return status;
		
	}

}
