package fr.ecuriesduloup.siteoptions.service;

import fr.ecuriesduloup.siteoptions.data.Option;

public interface OptionsService {

	public void save(String name, String value);
	public Option get(String name);
}
