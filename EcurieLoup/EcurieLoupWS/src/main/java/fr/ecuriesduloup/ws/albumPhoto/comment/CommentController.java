package fr.ecuriesduloup.ws.albumPhoto.comment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import donnees.photo.commentaire.Commentaire;
import fr.ecuriesduloup.ws.AbstractWsController;
import fr.ecuriesduloup.ws.albumPhoto.AlbumPhotoService;
import fr.ecuriesduloup.ws.user.UserService;

@Controller
public class CommentController extends AbstractWsController {
    @Autowired
    private AlbumPhotoService albumPhotoService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/albumPhoto/{mediaId}/comments", method = RequestMethod.GET)
    public ModelAndView getAllMediaComments(HttpServletRequest request, @PathVariable long mediaId) {
	List<Commentaire> comments = this.albumPhotoService.getComments(mediaId);

	List<CommentDto> commentsDto = new ArrayList<CommentDto>();
	for (Commentaire comment : comments) {
	    commentsDto.add(new CommentDto(comment));
	}
	return this.ChooseView(request, "comments", commentsDto);
    }

    @RequestMapping(value = "/albumPhoto/comments/{commentId}", method = RequestMethod.GET)
    public ModelAndView getComment(HttpServletRequest request, @PathVariable long commentId) {
	Commentaire comment = this.albumPhotoService.getComment(commentId);
	return this.ChooseView(request, "comment", new CommentDto(comment));
    }

    @RequestMapping(value = "/albumPhoto/comments/{commentId}", method = RequestMethod.DELETE)
    public ModelAndView deleteComment(HttpServletRequest request, @PathVariable long commentId) {
	this.albumPhotoService.deleteComment(commentId);
	return this.ChooseView(request, "comment", null);
    }

    @RequestMapping(value = "/albumPhoto/{mediaId}/comments", method = RequestMethod.POST)
    public ModelAndView createComment(HttpServletRequest request, @PathVariable long mediaId, @RequestParam("content") String content) {
	Commentaire comment = new Commentaire();
	comment.setContenu(content);
	comment.setDate(new Date().getTime());
	comment.setPosteur(this.userService.getCurrentUser());
	comment.setMedia(this.albumPhotoService.getMedia(mediaId));
	Commentaire commentSend = this.albumPhotoService.createComment(comment);
	return this.ChooseView(request, "comment", new CommentDto(commentSend));
    }

}
