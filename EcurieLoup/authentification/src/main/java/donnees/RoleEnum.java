package donnees;

/**
 * Permet de définir la liste de role possible dans l'application
 * @author Krack
 *
 */
public enum RoleEnum {
	/**
	 * Role pour les personnes juste authentifier 
	 */
	ROLE_AUTHENTIFIER, 
	/**
	 * Role pour les administrateurs du sites
	 */
	ROLE_ADMINISTRATEUR_ADMIN,
	
	/**
	 * Role pour les administrateurs des news
	 */
	ROLE_ADMINISTRATEUR_NEWS,
	
	/**
	 * Role pour les administrateurs du forum
	 */
	ROLE_ADMINISTRATEUR_FORUM,
	
	/**
	 * Role pour les administrateurs des photos
	 */
	ROLE_ADMINISTRATEUR_PHOTO,
	
	/**
	 * Role pour les administrateurs du calendrier
	 */
	ROLE_ADMINISTRATEUR_CALENDRIER,
	
	/**
	 * Role pour les administrateurs des fiches chevaux
	 */
	ROLE_ADMINISTRATEUR_FICHECHEVAUX
}
