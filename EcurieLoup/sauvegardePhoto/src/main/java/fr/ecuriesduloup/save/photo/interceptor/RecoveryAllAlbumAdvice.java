package fr.ecuriesduloup.save.photo.interceptor;

import java.lang.reflect.Method;
import java.util.List;

import org.springframework.aop.AfterReturningAdvice;

import donnees.photo.Album;
import fr.ecuriesduloup.save.photo.SaveMaker;

/**
 * Ce greffon est appeller quand on récupère tous les albums. Il vérifie la
 * première photo de chaque album. Si celle ci n'est pas en cache (c'est a dire
 * dans le dossier), il l'a rajoute. Seulement la première photo. L'ajout des
 * autres sera fait dans l'album.
 * 
 */
public class RecoveryAllAlbumAdvice implements
		AfterReturningAdvice {
	private SaveMaker saveMaker;

	
	public void setSaveMaker(SaveMaker saveMaker) {
		this.saveMaker = saveMaker;
	}


	@Override
	public void afterReturning(Object returnValue, Method method,
			Object[] args, Object target) throws Throwable {
		if (target.getClass().toString().equals("class service.photo.AlbumPhotoManagerImpl")) {
			// public List<Album> recupererTousLesAlbums();
			List<Album> listeDesAlbums = (List<Album>) returnValue;

			
			for (Album album : listeDesAlbums) {
				if(!album.getPhotos().isEmpty()){
					this.saveMaker.addRecoveryPhoto(album.getPhotos().get(0));
				}
			}

		}

	}
}
