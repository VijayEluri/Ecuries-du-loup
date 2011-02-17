package fr.ecuriesduloup.secretflag.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Image;

public class BretonImageClickHandler implements ClickHandler {
	private Image image;
	private final static int NUMBER_OF_BAND = 9;
	private final static int NUMBER_OF_BAND_FOR_STAR_ZONE = 4;
	private final static double X_PROPORTION_FOR_STAR_ZONE = 0.44;
	private final static char[] BAND_MAPPING = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i'};
	private final static char[][] STAR_MAPPING = {{'0', '1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9', '*'}};
	
	private String password = "";
	private PasswordSender passwordSender;
	
	public BretonImageClickHandler(Image img, PasswordSender passwordSender){
		this.image = img;
		this.passwordSender = passwordSender;
	}
	
	@Override
	public void onClick(ClickEvent clickEvent) {
		int x = clickEvent.getX();
		int y = clickEvent.getY();
		
		if(this.isStarZone(x, y)){
			this.addStarValue(x, y);
		}else{
			this.addBandValue(y);
		}
		
		this.sendPassword();
		this.cleanPassword();
		
	}
	
	private boolean isStarZone(int x, int y){
		if(this.isInWidthStarZone(x) && this.isInHeigthStarZone(y)){
			return true;
		}else{
			return false;
		}
	}
	
	private boolean isInWidthStarZone(int x){
		float prop = (float)x / this.image.getWidth();
		//260 => 591
		//x = > 100
		//44%
		return prop < X_PROPORTION_FOR_STAR_ZONE;
	}
	
	private boolean isInHeigthStarZone(int y){		
		return y < this.getWidthStarSize();
	}
	
	private void addStarValue(int x, int y){
		int yIndex = this.getLigneIndex(y);
		int xIndex = -1;
		if(yIndex == 0 || yIndex == 2){
			xIndex = this.getColonneIndex(x, 4);
		}else{
			xIndex = this.getColonneIndex(x, 3);			
		}
		this.password += STAR_MAPPING[yIndex][xIndex];
	}
	
	private void sendPassword(){
		this.passwordSender.send(this.password);
	}

	private void cleanPassword() {
		if(this.password.length() >= 10){
			this.password = this.password.substring(this.password.length() - 10);
		}		
	}

	private void addBandValue(int y){
		int numberOfBand = this.getClickedBand(y);
		this.password += BAND_MAPPING[numberOfBand];
	}
	
	
	private int getSizeOfBand(){
		return this.image.getHeight() / NUMBER_OF_BAND;
	}
	
	
	
	private int getLigneIndex(int y){
		int sizeOfBandOfStar = this.getHeightStarSize() / 3;
		return y / sizeOfBandOfStar;
	}
	
	private int getColonneIndex(int x, int starNumber){
		int sizeOfLargeOfStar = this.getWidthStarSize() / starNumber;
		return x / sizeOfLargeOfStar;
	}
	

	

	
	private int getClickedBand(int y){
		return y /this.getSizeOfBand();
	}
	

	
	private int getHeightStarSize(){
		return this.getSizeOfBand() * NUMBER_OF_BAND_FOR_STAR_ZONE;
	}
	
	private int getWidthStarSize(){
		return (int) (this.image.getWidth() * X_PROPORTION_FOR_STAR_ZONE);
	}
}
