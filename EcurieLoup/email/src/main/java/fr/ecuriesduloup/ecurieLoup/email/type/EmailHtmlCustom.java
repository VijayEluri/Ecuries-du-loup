package fr.ecuriesduloup.ecurieLoup.email.type;

import java.util.HashMap;
import java.util.Map;

import com.lowagie.text.html.HtmlEncoder;

import donnees.User;

public class EmailHtmlCustom extends EmailHtml implements Email {
	private User userForCustom;
	private Map<String, String> patternReplace;

	public EmailHtmlCustom(User userForCustom) {
		super();
		this.patternReplace = new HashMap<String, String>();
		this.userForCustom = userForCustom;
		
		this.initPatternReplaceWithUserFiedl();
	}
	
	private void initPatternReplaceWithUserFiedl(){
		this.patternReplace.put("{login}", this.userForCustom.getLogin());
		this.patternReplace.put("{name}", this.userForCustom.getNom());
		this.patternReplace.put("{firstname}", this.userForCustom.getPrenom());

		this.patternReplace.put("{email}", this.userForCustom.getEmail());
		this.patternReplace.put("{password}", this.userForCustom.getPassword());
	}
	@Override
	public void setMessage(String message) {
		
		message = this.replacePattern(message);
		
		super.setMessage(message);
	}
	
	public void addPatternReplace(String pattern, String replacementOfThePattern){
		this.patternReplace.put(pattern, replacementOfThePattern);
	}
	
	
	private String replacePattern(String initialMessage){
		for(String pattern : this.patternReplace.keySet()){
			String replace = HtmlEncoder.encode(this.patternReplace.get(pattern));
			initialMessage = initialMessage.replace(pattern, replace);
		}
		return initialMessage;
	}
}
