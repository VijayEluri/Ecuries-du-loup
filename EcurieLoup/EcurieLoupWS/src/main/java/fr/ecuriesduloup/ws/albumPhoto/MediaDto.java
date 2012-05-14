package fr.ecuriesduloup.ws.albumPhoto;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import donnees.photo.Media;
import donnees.photo.TypeMedia;

@XStreamAlias("media")
public class MediaDto {
	private long id;
	private String description;
	private TypeMedia type;
	private long datePostage;
	private String poster;
	private boolean read;
	
	public MediaDto(Media media) {
		this.id= media.getId();
		this.description = media.getDescription();
		this.setType(media.getType());
		this.datePostage = media.getDatePostage();
		this.poster = media.getPosteur().getLogin();
		this.read = media.isReadByCurrentUser();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getType() {
		if(type != null){
			return type.ordinal();
		}else{
			return 0;
		}
	}


	public void setType(int type) {
		if(type == 0){
			this.type = TypeMedia.Photo;
		}else if(type == 1){
			this.type = TypeMedia.Video;
		}else{

			throw new RuntimeException ("case not manage");
		}

	}
	public long getDatePostage() {
		return datePostage;
	}
	public void setDatePostage(long datePostage) {
		this.datePostage = datePostage;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}
	
	
}
