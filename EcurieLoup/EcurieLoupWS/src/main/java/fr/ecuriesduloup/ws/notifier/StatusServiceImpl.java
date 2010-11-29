package fr.ecuriesduloup.ws.notifier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import donnees.photo.Photo;

import service.photo.AlbumPhotoManager;

import forum.donnees.Message;
import forum.service.ForumManager;
@Service
public class StatusServiceImpl implements NotifierService{
	@Autowired
	private ForumManager forumManager;
	@Autowired
	private AlbumPhotoManager albumPhotoManager;
	
	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}

	
	public void setAlbumPhotoManager(AlbumPhotoManager albumPhotoManager) {
		this.albumPhotoManager = albumPhotoManager;
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
		boolean newPhoto = this.albumPhotoManager.hasNouvellesPhotos();
		Photo lastPhoto = this.albumPhotoManager.getLastPhoto();
		Status status = new Status();
		status.setHasNew(newPhoto);
		status.setTimeLastAction(lastPhoto.getDatePostage());
		
		return status;
		
	}

}
