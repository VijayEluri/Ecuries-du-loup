package mvc.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import service.page.PageManager;
import donnees.page.Page;

public class MenuInterceptor extends HandlerInterceptorAdapter {
	private PageManager pageManager;

	public void setPageManager(PageManager pageManager) {
		this.pageManager = pageManager;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		List<Page> pages = this.pageManager.recuperePagesVisibles();
		if(modelAndView != null){
			modelAndView.addObject("listePagesPresentation", pages);
	
		}
	}
}
