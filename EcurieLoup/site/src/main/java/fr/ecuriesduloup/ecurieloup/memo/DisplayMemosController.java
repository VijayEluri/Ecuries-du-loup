package fr.ecuriesduloup.ecurieloup.memo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.UtilisateurManager;
import donnees.User;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;
import fr.ecuriesduloup.ecurieLoup.memo.service.MemoManager;

@Controller
public class DisplayMemosController{
	@Autowired
	@Qualifier("memoManager")
	private MemoManager memoManager;
	
	@Autowired
	@Qualifier("utilisateurManager")
	private UtilisateurManager utilisateurManager;

	
	public void setMemoManager(MemoManager memoManager) {
		this.memoManager = memoManager;
	}

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@RequestMapping("/memo/myMemos.do")
	public ModelAndView handleRequest(HttpServletRequest request){
		
		if(this.deleteManager(request)){
			return new ModelAndView("redirect:myMemos.do");
		}
		if(this.doManager(request)){
			return new ModelAndView("redirect:myMemos.do");
		}
		
		Map<String, Object> model = this.getModel();
		this.memoManager.readMemosForConnectedUser();
		return new ModelAndView("memo/myMemos",model );
	}

	private boolean deleteManager(HttpServletRequest request){
		String deleteParameter = request.getParameter("delete");
		if(deleteParameter != null){
			Long id = Long.parseLong(deleteParameter);
			Memo memo = this.memoManager.getById(id);
			this.memoManager.delete(memo);
			return true;
		}
		return false;
	}
	private boolean doManager(HttpServletRequest request){
		String doParameter = request.getParameter("do");
		if(doParameter != null){
			Long id = Long.parseLong(doParameter);
			Memo memo = this.memoManager.getById(id);
			memo.setMemoIsDo(true);
			this.memoManager.update(memo);
			return true;
		}
		return false;
	}
	
	private Map<String, Object> getModel(){
		User currentUser=  this.utilisateurManager.getUtilisateurCourant();
		List<Memo> myTasks = this.memoManager.getTasks(currentUser);
		List<Memo> myRequests =this.memoManager.getRequests(currentUser);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("myTasks", myTasks);
		model.put("myRequests", myRequests);
		
		return model;
	}
}
