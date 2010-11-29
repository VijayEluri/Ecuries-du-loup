package forum.service.securite;

import forum.service.ForumManager;

public abstract class ForumSecuriteDecorateur implements ForumManager{

	protected ForumManager forumManager;

	public void setForumManager(ForumManager forumManager) {
		this.forumManager = forumManager;
	}	
}
