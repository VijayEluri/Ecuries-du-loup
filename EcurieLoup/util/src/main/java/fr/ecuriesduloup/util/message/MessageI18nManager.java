package fr.ecuriesduloup.util.message;

public interface MessageI18nManager {

	public String getMessage(String key);

	public String getMessage(String key, Object[] parametres);
}
