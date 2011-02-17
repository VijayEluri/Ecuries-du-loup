package fr.ecuriesduloup.siteoptions.dao;

import java.util.List;

import donnees.User;
import fr.ecurie_du_loup.generique_util.dao.HibernateIdLongBySpringDao;
import fr.ecuriesduloup.siteoptions.data.Option;

public class OptionsDaoImpl  extends HibernateIdLongBySpringDao<Option> implements OptionsDao{

	@Override
	public Option getOption(User user, String name) {
		if(user == null){
			return null;
		}
		String requete = "SELECT option FROM Option as option WHERE option.user.login='"+user.getLogin()+"' and option.name='"+name+"'";
		List<?> retour = this.getHibernateTemplate().find(requete);
		if(retour.isEmpty()){
			return null;
		}else{
			return (Option) retour.get(0);
		}
	}

}
