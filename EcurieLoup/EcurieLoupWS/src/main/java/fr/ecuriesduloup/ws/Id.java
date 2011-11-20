package fr.ecuriesduloup.ws;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("id")
public class Id {
	
	private long value;
	
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}




	@Override
	public String toString() {
		return "Id : "+value ;
	}
	
}
