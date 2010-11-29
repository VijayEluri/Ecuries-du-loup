package sauvegarde.smiley.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sauvegarde.smiley.dao.SauvegardeSmileyDAO;
import sauvegarde.smiley.donnees.SauvegardeSmiley;
import donnees.MemoireVariable;

public class SauvegardeSmileyManagerImpl implements SauvegardeSmileyManager {
	private SauvegardeSmileyDAO sauvegardeSmileyDAO;
	private String emplacementSmiley;

	public void setSauvegardeSmileyDAO(SauvegardeSmileyDAO sauvegardeSmileyDAO) {
		this.sauvegardeSmileyDAO = sauvegardeSmileyDAO;
	}

	public void setEmplacementSmiley(String emplacementSmiley) {
		this.emplacementSmiley = emplacementSmiley;
	}

	@Override
	public boolean isInCacheSauvegardeSmiley(long identifiantSmiley) {
		File fichierSmiley = new File(MemoireVariable
				.optenirVariable("pathServeur")
				+ "/" + this.emplacementSmiley + "/" + identifiantSmiley);
		return fichierSmiley.exists();
	}

	@Override
	public void creationSauvegardeSmiley(SauvegardeSmiley sauvegardeSmiley) {
		try{
			this.sauvegardeSmileyDAO.save(sauvegardeSmiley);
		}catch (Exception e) {
		}
	}

	@Override
	public void restaurerSauvegardeSmiley(long identifiantSmiley) {
		SauvegardeSmiley sauvegardeSmiley = this.sauvegardeSmileyDAO
				.getSauvegardeSmiley(identifiantSmiley);
		byte[] fichierSmiley = sauvegardeSmiley.getFichier();

		String urlSortie = MemoireVariable.optenirVariable("pathServeur") + "/"
				+ this.emplacementSmiley + "/" + identifiantSmiley;

		File newFile = new File(urlSortie);

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(newFile);
			try {
				fos.write(fichierSmiley);
			} catch (IOException e1) {
				e1.printStackTrace();
			} finally {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}

	@Override
	public void suppressionSauvegardeSmiley(long identifiantSmiley) {
		SauvegardeSmiley sauvegardeSmiley = this.sauvegardeSmileyDAO
				.getSauvegardeSmiley(identifiantSmiley);
		this.sauvegardeSmileyDAO.delete(sauvegardeSmiley);

	}

}
