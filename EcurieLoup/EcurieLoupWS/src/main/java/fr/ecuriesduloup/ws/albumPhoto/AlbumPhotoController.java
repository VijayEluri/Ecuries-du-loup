package fr.ecuriesduloup.ws.albumPhoto;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import donnees.User;
import donnees.photo.Album;
import donnees.photo.Media;
import donnees.photo.TypeMedia;
import fr.ecuriesduloup.ws.AbstractWsController;
import fr.ecuriesduloup.ws.Id;
import fr.ecuriesduloup.ws.WsStatus;
import fr.ecuriesduloup.ws.user.UserService;

@Controller
public class AlbumPhotoController extends AbstractWsController {
    @Autowired
    private AlbumPhotoService albumPhotoService;
    @Autowired
    private UserService userService;

    /**
     * Return all media with a personn or a horse.
     * 
     * @param identifier
     *            the identifier of the horse or personn you want all media.
     * @return a xml of media contents personn.
     */
    @RequestMapping(value = "/albumPhoto/photos/{identifier}", method = RequestMethod.GET)
    public ModelAndView GetMediaWith(HttpServletRequest request, @PathVariable String identifier) {
	AlbumWs albumWs = new AlbumWs();
	User user = this.userService.getUserByLogin(identifier);
	List<Media> medias = new ArrayList<Media>();
	if (user == null) {
	    long id = Long.parseLong(identifier);
	    List<Media> mediasWithHorse = this.albumPhotoService.getMediaWithHorse(id);
	    medias.addAll(mediasWithHorse);

	} else {
	    List<Media> mediasWithUser = this.albumPhotoService.getMediaWithUser(user);
	    medias.addAll(mediasWithUser);
	}
	albumWs.setId(0);
	albumWs.setName("Marqué " + identifier);
	albumWs.setMedias(this.convert(medias));
	return this.ChooseView(request, "media", albumWs);
    }

    @RequestMapping(value = "/albumPhoto/photos/{identifier}/read", method = RequestMethod.PUT)
    public ModelAndView readMedia(HttpServletRequest request, @PathVariable final long identifier) {
	final User user = this.userService.getCurrentUser();
	AlbumPhotoController.this.albumPhotoService.readMedia(identifier, user);

	return this.ChooseView(request, "status", "ok");
    }

    @RequestMapping(value = "/albumPhoto/photos/{identifier}", method = RequestMethod.DELETE)
    public ModelAndView deleteMedia(HttpServletRequest request, @PathVariable final long identifier) {
	String pathServer = request.getSession().getServletContext().getRealPath("/");
	this.albumPhotoService.deleteMedia(identifier, pathServer);
	return this.ChooseView(request, "status", "ok");
    }

    @RequestMapping(value = "/albumPhoto/photos/{identifier}/description", method = RequestMethod.POST)
    public ModelAndView changeDescription(HttpServletRequest request, @PathVariable final long identifier, @RequestParam("description") final String description) {
	this.albumPhotoService.changeDescription(identifier, description);
	return this.ChooseView(request, "status", "ok");
    }

    @RequestMapping(value = "/albumPhoto/{identifier}", method = RequestMethod.GET)
    public ModelAndView getAlbum(HttpServletRequest request, @PathVariable long identifier) {

	Album album = this.albumPhotoService.getAlbum(identifier);

	AlbumWs albumWs = new AlbumWs(album);

	return this.ChooseView(request, "media", albumWs);
    }

    private List<MediaDto> convert(List<Media> medias) {
	List<MediaDto> mediasDto = new ArrayList<MediaDto>();
	for (Media media : medias) {
	    MediaDto dto = new MediaDto(media);
	    mediasDto.add(dto);
	}

	return mediasDto;
    }

    /**
     * Get all albums.
     * 
     * @return The xml with all album.
     */
    @RequestMapping(value = "/albumPhoto/medias/notread", method = RequestMethod.GET)
    public ModelAndView listNotRead(HttpServletRequest request) {

	AlbumWs albumWs = new AlbumWs();
	List<Media> mediasNotRead = this.albumPhotoService.getMediaNotRead();
	List<MediaDto> mediasDto = new ArrayList<MediaDto>();
	for (Media media : mediasNotRead) {
	    mediasDto.add(new MediaDto(media));
	}
	albumWs.setId(0);
	albumWs.setMedias(mediasDto);
	albumWs.setName("Non vu");
	return this.ChooseView(request, "media", albumWs);
    }

    /**
     * Get all albums.
     * 
     * @return The xml with all album.
     */
    @RequestMapping(value = "/albumPhoto/albums", method = RequestMethod.GET)
    public ModelAndView listAlbum(HttpServletRequest request) {
	List<Album> albums = this.albumPhotoService.getAlbums();
	List<AlbumWs> albumWs = new ArrayList<AlbumWs>();
	for (Album album : albums) {
	    albumWs.add(new AlbumWs(album));
	}

	return this.ChooseView(request, "albums", albumWs);
    }

    /**
     * Add new album.
     * 
     * @param name
     *            The name of album.
     * @return
     */
    @RequestMapping(value = "/albumPhoto/album/{name}", method = RequestMethod.PUT)
    public ModelAndView createAlbum(HttpServletRequest request, @PathVariable String name) {
	long idAlbumPhoto = this.albumPhotoService.createAlbumPhoto(name);
	Id id = new Id();
	id.setValue(idAlbumPhoto);

	return this.ChooseView(request, "albumPhoto", id);
    }

    @RequestMapping(value = "/albumPhoto/album/{albumId}", method = RequestMethod.DELETE)
    public ModelAndView deleteAlbum(HttpServletRequest request, @PathVariable long albumId) {

	String pathServeur = request.getSession().getServletContext().getRealPath("/");
	this.albumPhotoService.deleteAlbum(albumId, pathServeur);
	return this.ChooseView(request, "status", "ok");
    }

    /**
     * Upload photo.
     * 
     * @param albumId
     *            the id of the album.
     * @param multipartFile
     *            The file to upload
     * @param request
     *            the request.
     * @return
     */
    @RequestMapping(value = "/albumPhoto/photo/{albumId}", method = RequestMethod.POST)
    public ModelAndView upload(@PathVariable long albumId, @RequestParam("file") MultipartFile multipartFile, MultipartHttpServletRequest request) {
	return this.commonUpload(albumId, multipartFile, request, TypeMedia.Photo);
    }

    /**
     * Upload video.
     * 
     * @param albumId
     *            the id of the album.
     * @param multipartFile
     *            The file to upload
     * @param request
     *            the request.
     * @return
     */
    @RequestMapping(value = "/albumPhoto/video/{albumId}", method = RequestMethod.POST)
    public ModelAndView uploadVideo(@PathVariable long albumId, @RequestParam("file") MultipartFile multipartFile, MultipartHttpServletRequest request) {
	return this.commonUpload(albumId, multipartFile, request, TypeMedia.Video);

    }

    private ModelAndView commonUpload(long albumId, MultipartFile multipartFile, MultipartHttpServletRequest request, TypeMedia type) {
	User posteur = this.userService.getCurrentUser();
	Album album = this.albumPhotoService.getAlbum(albumId);

	Media media = new Media();
	media.setAlbum(album);
	media.setDatePostage(new Date().getTime());
	media.setPosteur(posteur);
	media.setDescription("");
	media.setTypeAdding("web_service");
	if (type.equals(TypeMedia.Photo)) {
	    media.setType(0);
	} else if (type.equals(TypeMedia.Video)) {
	    media.setType(1);
	}

	if (multipartFile.isEmpty()) {

	}

	if (!this.isSupportedPicture(multipartFile)) {

	}

	File temporaire = this.createTemp(multipartFile, posteur);

	String pathPhoto = request.getSession().getServletContext().getRealPath("/");

	this.albumPhotoService.createMedia(media, temporaire, pathPhoto);

	temporaire.delete();
	WsStatus wsStatus = new WsStatus();
	wsStatus.setStatus("OK");

	return this.ChooseView(request, "Status", wsStatus);
    }

    private File createTemp(MultipartFile multipartFile, User posteur) {
	String[] s = multipartFile.getOriginalFilename().split("\\.");
	String extention = "";
	if (s.length > 1) {
	    extention = s[s.length - 1];
	}

	String chemin = "tmp";
	chemin += posteur.getLogin();
	chemin += "_" + new Date().getTime();
	chemin += new Random().nextInt(10000);
	chemin += "." + extention;

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
	return temporaire;
    }

    private boolean isSupportedPicture(MultipartFile multipartFile) {
	// TODO Auto-generated method stub
	return false;
    }
}
