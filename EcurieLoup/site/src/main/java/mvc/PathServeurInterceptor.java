package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import donnees.MemoireVariable;

public class PathServeurInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String pathServeur = request.getSession().getServletContext()
				.getRealPath("/");

		MemoireVariable.definirVariable("pathServeur", pathServeur);

		return super.preHandle(request, response, handler);
	}

}
