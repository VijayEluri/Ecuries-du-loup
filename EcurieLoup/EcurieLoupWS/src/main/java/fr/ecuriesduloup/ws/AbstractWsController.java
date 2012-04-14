package fr.ecuriesduloup.ws;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public class AbstractWsController {

	protected ModelAndView ChooseView(HttpServletRequest request, String modelName,Object returnedObject) {
		ModelAndView mav = null;
		if(isAcceptType(request, "json")){
			mav = new ModelAndView("jsonView", modelName, returnedObject);
		}else if(isAcceptType(request, "xml")){
			mav = new ModelAndView("statusXmlView", BindingResult.MODEL_KEY_PREFIX + modelName, returnedObject);

		}else{
			mav = new ModelAndView("statusXmlView", BindingResult.MODEL_KEY_PREFIX + modelName, returnedObject);
		}
		return mav;
	}
	
	private boolean isAcceptType(HttpServletRequest request, String type){
		if(request.getHeader("Accept") == null) return false;
		return request.getHeader("Accept").contains(type);
	}
}
