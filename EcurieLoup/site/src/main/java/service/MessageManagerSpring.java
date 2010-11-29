package service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import fr.ecuriesduloup.util.message.MessageI18nManager;

public class MessageManagerSpring implements MessageI18nManager, ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;

	}

	@Override
	public String getMessage(String key) {
		return applicationContext.getMessage(key, null, null);
	}

	@Override
	public String getMessage(String key, Object[] parametres) {
		return applicationContext.getMessage(key, parametres, null);
	}

}
