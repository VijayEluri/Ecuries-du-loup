package fr.ecuriesduloup.edlwyswig.server;

import edlcode.EdlCode;
import edlcode.EdlCodeEncodageException;
import fr.ecuriesduloup.edlwyswig.client.WysiwygService;

public class WysiwygServiceImpl implements WysiwygService {
	private EdlCode edlCode;
	
	
	public void setEdlCode(EdlCode edlCode) {
		this.edlCode = edlCode;
	}


	@Override
	public String generateHtml(String text) {
		
		try {
			return this.edlCode.parse(text);
		} catch (EdlCodeEncodageException e) {
			return text;
		}
	}

}
