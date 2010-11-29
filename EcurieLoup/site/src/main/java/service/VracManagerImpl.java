package service;

import dao.VracDAO;
import donnees.Vrac;

public class VracManagerImpl implements VracManager {
	private VracDAO vracDAO;

	public void setVracDAO(VracDAO vracDAO) {
		this.vracDAO = vracDAO;
	}

	@Override
	public Vrac recupererVrac(String identifiant) {
		return this.vracDAO.getVrac(identifiant);
	}

	@Override
	public void modifierVrac(Vrac vrac) {
		this.vracDAO.update(vrac);

	}

}
