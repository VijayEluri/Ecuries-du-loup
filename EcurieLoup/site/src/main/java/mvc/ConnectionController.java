package mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConnectionController{

	@RequestMapping("/login.do")
	public String handleRequest(HttpServletRequest request) throws Exception {
		return "/login";
	}

}
