package fr.ecuriesduloup.imagechooser.client;

public class Size {
	private int height;
	private int width;
	
	public Size(int height, int width){
		this.height = height;
		this.width= width;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public Size scale(double coef){
		int height = (int)(coef * this.getHeight());
		int width = (int)(coef * this.getWidth());
		
		return new Size(height, width);
	}
	
	public Size scaleWithMaxSize(Size maxSize){
		double coef = 1.0;
		double coefWidth = calculateReduceCoef(this.getWidth(), maxSize.getWidth());
		double coefHeight = calculateReduceCoef(this.getHeight(), maxSize.getHeight());;
		
		coef = Math.min(coefWidth, coefHeight);
		
		return this.scale(coef);
		
	}
	
	private double calculateReduceCoef(int size, int maxSize){
		double coef = 1.0;
		
		if(size > maxSize){
			coef = (double)maxSize / size;
		}
		
		return coef;
	}
	
	@Override
	public String toString() {
		return "Size : height "+this.height+" - width "+width;
	}
	
}
