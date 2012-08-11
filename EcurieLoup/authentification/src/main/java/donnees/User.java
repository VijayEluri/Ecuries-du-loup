package donnees;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import fr.ecurie_du_loup.generique_util.type.DataWithStringId;

/**
 * Classe définissant un utilisateur dans l'application
 * 
 * @author Krack
 * 
 */
public class User implements DataWithStringId {

    private String login;

    private String password;

    private String nom;

    private String prenom;

    private String email;

    private Date creationDate;

    private Date lastAccessDate;

    private String identifiantFacebook;

    private boolean enabled;

    private Set<Role> roles = new HashSet<Role>();

    private long birthDate;

    private long lastAccessDateNotifier;

    public String getLogin() {
	return this.login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    @Override
    /**
     * Equivaut au getLogin() car il s'agit seulement de typage et donc le terme de login reste plus adapté
     */
    public String getId() {
	return this.getLogin();
    }

    @Override
    public void setId(String id) {
	this.setLogin(id);
    }

    public String getEmail() {
	return this.email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getNom() {
	return this.nom;
    }

    public void setNom(String nom) {
	this.nom = nom;
    }

    public String getPrenom() {
	return this.prenom;
    }

    public void setPrenom(String prenom) {
	this.prenom = prenom;
    }

    public String getPassword() {
	return this.password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Date getCreationDate() {
	return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
	this.creationDate = creationDate;
    }

    public Date getLastAccessDate() {
	return this.lastAccessDate;
    }

    public void setLastAccessDate(Date lastAccessDate) {
	this.lastAccessDate = lastAccessDate;
    }

    public String getIdentifiantFacebook() {
	return this.identifiantFacebook;
    }

    public void setIdentifiantFacebook(String identifiantFacebook) {
	this.identifiantFacebook = identifiantFacebook;
    }

    public boolean isEnabled() {
	return this.enabled;
    }

    public void setEnabled(boolean enabled) {
	this.enabled = enabled;
    }

    public Set<Role> getRoles() {
	return this.roles;
    }

    public void setRoles(Set<Role> roles) {
	this.roles = roles;
    }

    @Override
    public String toString() {
	return "login : " + this.login + "\npassword : " + this.password + "\n\nnom : " + this.nom + "\nprénom : " + this.prenom + "\nemail : " + this.email + "\ncréation " + this.creationDate
		+ "\ndernière accès : " + this.lastAccessDate + "\nactivé : " + this.enabled + "\nrole  : " + this.roles.toString();
    }

    @Override
    public boolean equals(Object obj) {
	boolean egal;
	if (obj instanceof User) {
	    egal = this.equals((User) obj);
	} else {
	    egal = super.equals(obj);
	}
	return egal;
    }

    public boolean equals(User user) {
	if (user == null) {
	    return false;
	}
	boolean egal = true;
	egal = egal && this.getLogin().toLowerCase().equals(user.getLogin().toLowerCase());

	return egal;

    }

    public long getBirthDate() {
	return this.birthDate;
    }

    public void setBirthDate(long birthDate) {
	this.birthDate = birthDate;
    }

    public long getLastAccessDateNotifier() {
	return this.lastAccessDateNotifier;
    }

    public void setLastAccessDateNotifier(long lastAccessDateNotifier) {
	this.lastAccessDateNotifier = lastAccessDateNotifier;
    }

}
