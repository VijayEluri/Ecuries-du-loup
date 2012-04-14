package service;

import org.springframework.beans.factory.annotation.Autowired;

import dao.VracDAO;
import donnees.Vrac;
import donnees.news.Nouvelle;
import edlcode.EdlCode;
import edlcode.EdlCodeEncodageException;

public class VracManagerImpl implements VracManager {
	private VracDAO vracDAO;

	public void setVracDAO(VracDAO vracDAO) {
		this.vracDAO = vracDAO;
	}
	
	@Autowired
	private EdlCode edlCode;
	
	public void setEdlCode(EdlCode edlCode) {
		this.edlCode = edlCode;
	}

	@Override
	public Vrac recupererVrac(String identifiant) {
		return this.vracDAO.getVrac(identifiant);
	}

	@Override
	public void modifierVrac(Vrac vrac) {
		this.vracDAO.update(vrac);

	}

	@Override
	public Vrac getFormatedVrac(String string) {
		Vrac vrac = this.recupererVrac(string);
		Vrac copyVrac = new Vrac();
		copyVrac.setId(vrac.getId());
		try {
			copyVrac.setContenu(this.edlCode.parse(vrac.getContenu()));
		} catch (EdlCodeEncodageException e) {
			copyVrac.setContenu(vrac.getContenu());
		};
		return vrac;
	}

}
