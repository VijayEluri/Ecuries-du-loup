package fr.ecuriesduloup.ws.albumPhoto.comment;

import java.util.Date;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import donnees.photo.commentaire.Commentaire;

@XStreamAlias("Comment")
public class CommentDto {
	private long id;
	private long mediaId;
	private String posterLogin;
	private Date date;
	private String content;
	
	public CommentDto(Commentaire comment){
		this.setId(comment.getId());
		this.setMediaId(comment.getMedia().getId());
		this.setPosterLogin(comment.getPosteur().getLogin());
		this.setDate(new Date(comment.getDate()));
		this.setContent(comment.getContenu());
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getMediaId() {
		return mediaId;
	}
	public void setMediaId(long mediaId) {
		this.mediaId = mediaId;
	}
	public String getPosterLogin() {
		return posterLogin;
	}
	public void setPosterLogin(String posterLogin) {
		this.posterLogin = posterLogin;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
