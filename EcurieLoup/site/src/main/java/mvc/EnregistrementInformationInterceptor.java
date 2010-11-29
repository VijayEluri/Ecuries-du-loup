package mvc;

import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import enregistrement_trace_requete.donnees.EnregistrementTraceRequete;
import enregistrement_trace_requete.donnees.ParametreEnregistrementTraceRequete;
import enregistrement_trace_requete.services.EnregistrementManager;

public class EnregistrementInformationInterceptor extends
		HandlerInterceptorAdapter {

	private EnregistrementManager enregistrementManager;

	public void setEnregistrementManager(
			EnregistrementManager enregistrementManager) {
		this.enregistrementManager = enregistrementManager;
	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		EnregistrementTraceRequete requete = new EnregistrementTraceRequete();

		long date = Calendar.getInstance().getTimeInMillis();
		requete.setDate(date);

		requete.setUserAgent("" + request.getHeader("User-Agent"));
		requete.setReferer("" + request.getHeader("Referer"));
		requete.setRemoteAdress("" + request.getRemoteAddr());
		requete.setUri("" + request.getRequestURI());

		Enumeration parameters = request.getParameterNames();
		while (parameters.hasMoreElements()) {

			String param = (String) parameters.nextElement();
			String valeur = request.getParameter(param);

			ParametreEnregistrementTraceRequete parametreTrace = new ParametreEnregistrementTraceRequete();
			parametreTrace.setName("" + param);
			parametreTrace.setValue("" + valeur);

			requete.getParametresRequeste().add(parametreTrace);

		}

		this.enregistrementManager.enregistreTraceRequete(requete);

		return super.preHandle(request, response, handler);
	}

}
