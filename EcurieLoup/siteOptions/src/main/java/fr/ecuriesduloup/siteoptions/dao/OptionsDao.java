package fr.ecuriesduloup.siteoptions.dao;

import donnees.User;
import fr.ecurie_du_loup.generique_util.dao.DaoIdLongUtil;
import fr.ecuriesduloup.siteoptions.data.Option;

public interface OptionsDao extends DaoIdLongUtil<Option>{

	public Option getOption(User user, String name);
}
