package fr.ecuriesduloup.save.photo.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

import donnees.photo.Album;
import fr.ecuriesduloup.save.photo.SaveMaker;

public class RecoveryAlbumAdvice implements
		AfterReturningAdvice {
	private SaveMaker saveMaker;

	
	public void setSaveMaker(SaveMaker saveMaker) {
		this.saveMaker = saveMaker;
	}


	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		if (target.getClass().toString().equals("class service.photo.AlbumPhotoManagerImpl")) {
			// public Album recupererAlbum(long id);
			Album album = (Album) returnValue;

			this.saveMaker.addRecoveryPhoto(album.getMedias());
			

		}

	}

}
