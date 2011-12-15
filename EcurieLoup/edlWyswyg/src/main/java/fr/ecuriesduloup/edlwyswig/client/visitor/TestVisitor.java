package fr.ecuriesduloup.edlwyswig.client.visitor;

import fr.ecuriesduloup.edlwyswig.client.ui.portlet.Portlet;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.imageportlet.ImagePortlet;
import fr.ecuriesduloup.edlwyswig.client.ui.portlet.textportlet.TextPortlet;
import fr.ecuriesduloup.imagechooser.shared.Img;


public class TestVisitor implements Visitor {
	private StringBuffer text;

	public TestVisitor() {
		this.text= new StringBuffer();
	}

	@Override
	public void visit(ImagePortlet imagePortlet) {
		Img img = imagePortlet.getSelectedImage();
		if(img != null){
			if(img.isDefine()){
				if(img.isUrl()){

					this.text.append("[image=\"");
					this.text.append(img.getUrl());
					this.text.append("\" ");
					this.generatePositionAndDimention(imagePortlet);
					this.text.append("]");
				}
			}
		}

	}
	
	private void generatePositionAndDimention(Portlet portlet){
		this.text.append("hauteur=\"");
		this.text.append(portlet.getBlockHeight()+"px");
		this.text.append("\" largeur=\"");
		this.text.append(portlet.getBlockWidth()+"px");
		this.text.append("\" top=\"");
		this.text.append(portlet.getBlockTop()+"px");
		this.text.append("\" left=\"");
		this.text.append(portlet.getBlockLeft()+"px");
		this.text.append("\"");
	}

	@Override
	public void visit(TextPortlet textPortlet) {
		this.text.append("[text ");
		this.generatePositionAndDimention(textPortlet);
		this.text.append("]");
		this.text.append(textPortlet.getContent());
		this.text.append("[/text]");

	}

	@Override
	public String getString() {
		return this.text.toString();
	}

}
