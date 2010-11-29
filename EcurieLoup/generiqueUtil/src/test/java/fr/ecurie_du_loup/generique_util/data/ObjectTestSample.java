package fr.ecurie_du_loup.generique_util.data;

import java.util.Date;

import fr.ecurie_du_loup.generique_util.type.DataWithLongId;

public class ObjectTestSample implements DataWithLongId{
	private long id;
	private String string1;
	private String string2;
	private Date date1;
	
	@Override
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getString1() {
		return string1;
	}
	public void setString1(String string1) {
		this.string1 = string1;
	}
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ObjectTestSample)){
			return false;
		}
		ObjectTestSample objectTest = (ObjectTestSample)obj;
		return objectTest.id == this.id;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("ObjectTestSample :");
		string.append("\tid :"+id);
		string.append("\tstring1 :"+string1);
		string.append("\tstring2 :"+string2);
		string.append("\tdate1 :"+date1);
		return string.toString();
	}
	
}
