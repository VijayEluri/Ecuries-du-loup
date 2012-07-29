package fr.ecuriesduloup.ws.albumPhoto;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import donnees.photo.Album;
import donnees.photo.Media;

@XStreamAlias("album")
public class AlbumWs {

	private long id;
	private String name;
	private List<MediaDto> medias;
	public AlbumWs(){
	}
	public AlbumWs(Album album){
		this.id = album.getId();
		this.name = album.getTitre();
		this.medias = new ArrayList<MediaDto>();
		for(Media media : album.getMedias()){
			if(media!=null){
				this.medias.add(new MediaDto(media));
			}
		}
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<MediaDto> getMedias() {
		return medias;
	}

	public void setMedias(List<MediaDto> medias) {
		this.medias = medias;
	}
	
	
}
