package fr.ecuriesduloup.save.photo.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import fr.ecuriesduloup.save.photo.SaveMaker;

public class DeletePhotoBackupAdvice implements AfterReturningAdvice {
	private SaveMaker saveMaker;


	public void setSaveMaker(SaveMaker saveMaker) {
		this.saveMaker = saveMaker;
	}
	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		// supprimerFicherSurDisque(String emplacement)
		String nom = (String) args[0];
		String[] spliter = nom.split("/");
		long sauvegarde = Long.parseLong(spliter[spliter.length - 1]);
		this.saveMaker.addDeletePhoto(sauvegarde);

	}

}
