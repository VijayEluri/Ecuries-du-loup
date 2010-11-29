package fr.ecuriesduloup.save.photo.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import fr.ecuriesduloup.save.photo.SaveMaker;

//TODO : checker pour voir si on peut pas prendre ailleur la coupe
public class AddPhotoBackupAdvice implements AfterReturningAdvice {
	private SaveMaker saveMaker;

	
	public void setSaveMaker(SaveMaker saveMaker) {
		this.saveMaker = saveMaker;
	}

	
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		// public void creerFicherSurDisque(String emplacement, String nom, File fichier);
		
		int  photo = Integer.parseInt((String) args[1]);
		this.saveMaker.addSavePhoto(photo);

	}

}
