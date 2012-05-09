package mvc.photo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.photo.MediaManager;
import donnees.photo.Media;
@Controller
public class AffichagePhotoAlbumPhotoController{
	@Autowired
	@Qualifier("mediaManager")
	private MediaManager mediaManager;
	

	

	public void setAlbumPhotoManager(MediaManager mediaManager) {
		this.mediaManager = mediaManager;
	}
	
	@ModelAttribute("searchTag")
	protected String getParams(HttpServletRequest request) {
		return getParams(request, "searchtag");
	
	}
	
	@ModelAttribute("albumId")
	protected long getAlbumId(HttpServletRequest request) {
		String searchTag =  getParams(request, "searchtag");
		long albumId = getParamsId(request, "albumId");
		if(albumId == 0 && searchTag.equals("") ){
			long mediaId = getParamsId(request, "mediaId");
			if(mediaId == 0){
				//last method 
				mediaId = getParamsId(request, "idPhoto");
			}
			Media media = this.mediaManager.recupererMedia(mediaId);
			albumId = media.getAlbum().getId();
		}
		return albumId;
		
	}
	
	@ModelAttribute("mediaId")
	protected long getMediaId(HttpServletRequest request) {
		long mediaId = getParamsId(request, "mediaId");
		if(mediaId == 0){
			//last method 
			mediaId = getParamsId(request, "idPhoto");
		}
		return mediaId;
	}

	private long getParamsId(HttpServletRequest request, String paramsName){
		String params = getParams(request, paramsName);
		return (params != null && !params.equals(""))? Long.parseLong(params): 0;
	}
	private String getParams(HttpServletRequest request, String paramsName){
		String params = request.getParameter(paramsName);
		return (params!= null)? params: "";
	}


	@RequestMapping(value="/albumPhoto/affichagePhoto.do", method=RequestMethod.GET)
	public String displayPhoto(){
		return "photo/affichagePhoto";
	}

	@RequestMapping(value="/albumPhoto/affichagePhoto.do", method=RequestMethod.POST)
	public String onSubmit(@ModelAttribute("photo")Media photo) {
		this.mediaManager.modifierMedia(photo);

		return this.displayPhoto();

	}
}
