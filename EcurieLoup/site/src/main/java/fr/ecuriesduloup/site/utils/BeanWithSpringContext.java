package fr.ecuriesduloup.site.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

import fr.ecuriesduloup.secretflag.client.SecretFlagService;
import fr.ecuriesduloup.secretflag.server.SecretFlagServiceImpl;
import fr.ecuriesduloup.secretflag.server.SecretFlagServlet;

public class BeanWithSpringContext implements BeanFactoryAware{
	private BeanFactory beanFactory;
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	
	public void init(){
		//	SecretFlagService secretFlagServite = this.beanFactory.getBean(SecretFlagServiceImpl.class);
		//	SecretFlagServlet.setSecretFlagService(secretFlagServite);	
	}

}
