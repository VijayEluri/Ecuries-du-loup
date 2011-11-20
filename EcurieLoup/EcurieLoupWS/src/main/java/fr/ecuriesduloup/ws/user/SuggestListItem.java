package fr.ecuriesduloup.ws.user;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("item")
public class SuggestListItem implements Comparable<SuggestListItem> {
	private String id;
	private String value;
	private String type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int compareTo(SuggestListItem o) {
		return this.value.compareTo(o.value);
	}
	@Override
	public String toString() {
		return this.getClass().toString()+ " "+this.getId()+" "+this.getValue()+" "+this.getType();
	}
}
