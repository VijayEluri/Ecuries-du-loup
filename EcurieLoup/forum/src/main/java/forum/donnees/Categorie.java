package forum.donnees;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import donnees.Role;
import fr.ecurie_du_loup.generique_util.type.DataWithLongId;
import fr.ecurie_du_loup.generique_util.type.DataWtihLongIdAbstract;

public class Categorie extends DataWtihLongIdAbstract<Categorie> implements DataWithLongId{
	private String titre;
	private String description;
	private Set<Role> roleAutoriser;
	private List<Topic> topics;
	
	public Categorie(){
		this.topics = new ArrayList<Topic>();
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRoleAutoriser(Set<Role> roleAutoriser) {
		this.roleAutoriser = roleAutoriser;
	}
	public Set<Role> getRoleAutoriser() {
		return roleAutoriser;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		
		this.topics = topics;
		//TODO : géré sa dans hibernate :s
		while(this.topics.contains(null)){
			this.topics.remove(null);
		}
	}
	
	public String toString(){
		String categorieEnString = "";
		
		categorieEnString += "=====Categorie=====\n";
		categorieEnString += "ID : "+this.id+"\n";
		categorieEnString += "Titre : "+this.titre+"\n";
		categorieEnString += "Description : "+this.description+"\n";
		categorieEnString += "Roles  : ["+this.roleAutoriser+"]\n";
		categorieEnString += "Topics  : ["+this.topics+"]\n";
		
		categorieEnString += "=====Fin Categorie=====\n";
		
		return  categorieEnString;
	}
	
	public boolean isTopicNonLu(){
		boolean hasTopicNonLu = false;
		
		for(Topic topic : this.topics){
			if(topic != null){
				if(topic.getDateLecture() < topic.getDernierMessage().getDatePostage()){
					hasTopicNonLu = true;
					break;
				}
			}
		}
		return hasTopicNonLu;
	}
	public List<Topic> getTopicNonLu(){
		List<Topic> topicsNonLu = new ArrayList<Topic>();
		
		for(Topic topic : this.topics){
			if(topic != null){
				if(topic.getDateLecture() < topic.getDernierMessage().getDatePostage()){
					topicsNonLu.add(topic);
				}
			}
		}
		return topicsNonLu;
	}
}
