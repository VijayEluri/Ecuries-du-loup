package service;

/**
 * Exception généré lors d'une tentative de création d'un utilisateur avec un login déjà utilisé
 * @author Krack
 *
 */
public class UtilisateurDejaExistantException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public UtilisateurDejaExistantException(String s){
		super(s);
	}

}
