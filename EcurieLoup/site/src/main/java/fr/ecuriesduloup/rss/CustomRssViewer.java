package fr.ecuriesduloup.rss;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.feed.AbstractRssFeedView;

import com.sun.syndication.feed.rss.Channel;
import com.sun.syndication.feed.rss.Content;
import com.sun.syndication.feed.rss.Item;

import donnees.news.Nouvelle;

public class CustomRssViewer extends AbstractRssFeedView {

	@Override
	protected void buildFeedMetadata(Map<String,Object> model, Channel feed, HttpServletRequest request) {
		feed.setTitle("Ecuries du loup");
		feed.setDescription("Les nouvelles des écuries du loup.");
		feed.setLink("http://www.ecuriesduloup.fr");
		feed.setEncoding("ISO-8859-1");
		
		super.buildFeedMetadata(model, feed, request);
	};
	
	@Override
	protected List<Item> buildFeedItems(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Nouvelle> listContent = (List<Nouvelle>) model.get("feedContent");
		List<Item> items = new ArrayList<Item>();
		
		StringBuffer requestUrl = request.getRequestURL();
		String host = requestUrl.substring(0, requestUrl.indexOf("/",7));
		String pathServeur = request.getContextPath();
		
		for(Nouvelle tempContent : listContent){
			Item item = new Item();
			
			Content content = new Content();
			content.setValue(tempContent.getContenu());
			item.setContent(content);
			
			item.setTitle(tempContent.getTitre());

			item.setLink(host+pathServeur+"/news/show.do?newsId="+tempContent.getId());
			
			item.setPubDate(new Date(tempContent.getDateCreation()));
			item.setAuthor(tempContent.getAuteur().getEmail());
			items.add(item);
		
		}
		return items;
	}

}
