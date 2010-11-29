package dao;

import donnees.Vrac;

public interface VracDAO {

	public Vrac getVrac(String identifiant);

	public void update(Vrac vrac);
}
