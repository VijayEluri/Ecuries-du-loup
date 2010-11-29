package mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import service.UtilisateurManager;
import donnees.User;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;
import fr.ecuriesduloup.ecurieLoup.memo.service.MemoManager;

public class MemoInterceptor extends HandlerInterceptorAdapter {
	private MemoManager memoManager;
	private UtilisateurManager utilisateurManager;

	

	public void setMemoManager(MemoManager memoManager) {
		this.memoManager = memoManager;
	}


	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		User connectedUser = this.utilisateurManager.getUtilisateurCourant();

		if(connectedUser != null){
			if(modelAndView != null){
				modelAndView.addObject("hasNewTask", this.memoManager.hasNewTaskForConnectedUser());
				List<Memo> tasks = this.memoManager.getTasks(connectedUser);
				String status = "normal";
				if(!tasks.isEmpty()){
					status = tasks.get(0).getStatus();
				}
				modelAndView.addObject("memoStatus", status);
			}
		}else{
			modelAndView.addObject("memoStatus", "normal");
		}
	}
}
