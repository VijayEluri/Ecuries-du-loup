package fr.ecuriesduloup.ws.albumPhoto;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import fr.ecuriesduloup.ws.WsStatus;
import fr.ecuriesduloup.ws.user.UserService;

@Controller
public class AlbumPhotoController {
	@Autowired
	private AlbumPhotoService albumPhotoService;
	@Autowired
	private UserService userService;


	@RequestMapping(value = "/albumPhoto/album/{name}",method=RequestMethod.PUT)
	public ModelAndView createAlbum(@PathVariable String name) {
		long idAlbumPhoto = this.albumPhotoService.createAlbumPhoto(name);
		Id id = new Id();
		id.setValue(idAlbumPhoto);
		ModelAndView mav = new ModelAndView("statusXmlView", BindingResult.MODEL_KEY_PREFIX + "albumPhoto", id);
		return mav;
	}

	@RequestMapping(value = "/albumPhoto/photo/{albumId}",method=RequestMethod.POST)
	public ModelAndView upload(@PathVariable long albumId, HttpServletRequest request){
	/*MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String,MultipartFile > filesMap = multipartRequest.getFileMap();
		System.out.println("filesMap recu : ");
		for(String key : filesMap.keySet()){
			System.out.println("\tfichier recu : "+key);
		}*/
		System.out.println("postage "+albumId);
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		System.out.println("postage after cast ");
		System.out.println(toString(request));
		
	/*	Photo photo = new Photo();
		User posteur = this.userService.getCurrentUser();
		Album album = this.albumPhotoService.getAlbum(albumId);
		photo.setAlbum(album);
		photo.setDatePostage(new Date().getTime());
		photo.setPosteur(posteur);
		
	
		
		if (multipartFile.isEmpty()) {
			

		}

		if(!this.isSupportedPicture(multipartFile)){
			
		}
		String chemin = "tmp";
		chemin += posteur.getLogin();
		chemin += "_" + new Date().getTime();
		chemin += (int) (Math.random() * 10000);

		File temporaire = new File(chemin);
		try {
			multipartFile.transferTo(temporaire);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathPhoto = request.getSession().getServletContext().getRealPath("/");

		this.albumPhotoService.createPhoto(photo, temporaire, pathPhoto);

		temporaire.delete();*/
		WsStatus wsStatus = new WsStatus();
		wsStatus.setStatus("OK");
		ModelAndView mav = new ModelAndView("statusXmlView", BindingResult.MODEL_KEY_PREFIX + "wsStatus", wsStatus);
		return mav;
	}
	
	private String toString(HttpServletRequest request){
		String s = "----------" +
				"HttpServletRequest Display :\n";
		s+="\t"+request.getClass()+" "+request.toString()+"\n";
		
		s+="\n";
		s+="\tAttribute : \n";
		Enumeration enumeration = request.getAttributeNames();
		s+= this.addEnum(enumeration);
		

		s+="\n";
		s+="\tHeaders : \n";
		Enumeration enumeration2 = request.getHeaderNames();
		s+= this.addEnum(enumeration2);
		
		s+="\n";
		s+="\tParameters : \n";
		Enumeration enumeration3= request.getParameterNames();
		s+= this.addEnum(enumeration3);
		
		
		s+="----------";
		return s;
	}
	
	private String addEnum(Enumeration enumeration){
		String s = "";
		while(enumeration.hasMoreElements()){
			String elementName = (String)enumeration.nextElement();
			s+="\t\t"+elementName+" "+"\n";
		}
		return s;
	}


	private boolean isSupportedPicture(MultipartFile multipartFile) {
		// TODO Auto-generated method stub
		return false;
	}
}
