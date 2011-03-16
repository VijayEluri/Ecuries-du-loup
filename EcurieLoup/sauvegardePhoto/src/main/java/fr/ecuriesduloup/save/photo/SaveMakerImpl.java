package fr.ecuriesduloup.save.photo;

import java.io.File;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.dao.DataIntegrityViolationException;

import donnees.photo.Media;
import fr.ecuriesduloup.save.photo.data.PhotoBackup;
import fr.ecuriesduloup.save.photo.service.PhotoBackupManager;

public class SaveMakerImpl implements SaveMaker, Runnable{
	private Set<Media> photosWaitRecevery;
	private Set<Media> photosWaitSave;
	private Set<Media> photosWaitDelete;
	private ExecutorService executorService;

	private PhotoBackupManager photoBackupManager;

	private boolean work;


	public void setPhotoBackupManager(PhotoBackupManager photoBackupManager) {
		this.photoBackupManager = photoBackupManager;
	}


	public SaveMakerImpl() {
		this.photosWaitRecevery = new HashSet<Media>();
		this.photosWaitSave = new HashSet<Media>();
		this.photosWaitDelete = new HashSet<Media>();
		this.executorService = Executors.newFixedThreadPool(1);
	}


	@Override
	public void addRecoveryPhoto(Media photoRecovery) {
		this.photosWaitRecevery.add(photoRecovery);
		this.work();
	}
	@Override
	public void addRecoveryPhoto(Collection<Media> photoRecovery) {
		this.photosWaitRecevery.addAll(photoRecovery);
		this.work();
	}

	@Override
	public void addSavePhoto(Media photoSave) {		
		this.photosWaitSave.add(photoSave);
		this.work();
	}
	//Attention : ne fonctionne que parce qu'on ne fait des traitements
	//que sur l'id dans le reste !!
	@Override
	public void addSavePhoto(long idPhotoSave) {
		Media photoSave = new Media();
		photoSave.setId(idPhotoSave);
		this.addSavePhoto(photoSave);
	}


	@Override
	public void addDeletePhoto(Media photoDelete) {
		this.photosWaitDelete.add(photoDelete);
		this.work();

	}

	//Attention : ne fonctionne que parce qu'on ne fait des traitements
	//que sur l'id dans le reste !!
	@Override
	public void addDeletePhoto(long idPhotoDelete) {
		Media photoDelete = new Media();
		photoDelete.setId(idPhotoDelete);

		this.addDeletePhoto(photoDelete);		
	}

	private void work(){
		if(!this.isAllTermined() && !work){
			this.executorService.execute(this);
		}
	}
	@Override
	public void run() {
		work= true;
		while(!this.isAllTermined()){

			this.workRecovery();
			this.workDelete();
			this.workSave();
		}
		work= false;

	}
	private boolean isAllTermined(){	
		boolean isTermined = this.photosWaitRecevery.isEmpty();
		isTermined = isTermined && this.photosWaitSave.isEmpty();
		isTermined = isTermined && this.photosWaitDelete.isEmpty();
		return isTermined;	
	}



	private void workRecovery(){
		while(!this.photosWaitRecevery.isEmpty()){
			try{
				final Media photo = this.photosWaitRecevery.iterator().next();
				this.executorService.execute(new Runnable() {
					@Override
					public void run() {
						if(!photoBackupManager.isOnHardDisk(photo)){
							photoBackupManager.restorePhotoBackup(photo);

						}

					}


				});
				photosWaitRecevery.remove(photo);
			}catch (ConcurrentModificationException e) {
			}
		
		}		
	}

	private void workSave(){
		while(!this.photosWaitSave.isEmpty()){
			final Media photo = this.photosWaitSave.iterator().next();
			this.executorService.execute(new Runnable() {
				@Override
				public void run() {
					if(photoBackupManager.isOnHardDisk(photo)){
						PhotoBackup photoBackup = new PhotoBackup();
						photoBackup.setId(photo.getId());
						File photoFile = photoBackupManager.getOnHardDisk(photo);
						photoBackup.setFile(photoFile);
						try{
							photoBackupManager.add(photoBackup);
						}catch (DataIntegrityViolationException e) {
						}

					}

				}
			});
			photosWaitSave.remove(photo);
		}		
	}

	private void workDelete(){
		while(!this.photosWaitDelete.isEmpty()){
			final Media photo = this.photosWaitDelete.iterator().next();
			this.executorService.execute(new Runnable() {
				@Override
				public void run() {
					photoBackupManager.delete(photo.getId());

				}
			});
			photosWaitDelete.remove(photo);
		}		
	}
}
