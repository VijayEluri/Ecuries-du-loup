package fr.ecurie_du_loup.generique_util.data;


public class ObjectTest2 {
	private long id;
	private ObjectTestSample objectTest;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public ObjectTestSample getObjectTest() {
		return objectTest;
	}
	public void setObjectTest(ObjectTestSample objectTest) {
		this.objectTest = objectTest;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ObjectTest2)){
			return false;
		}
		ObjectTest2 objectTest = (ObjectTest2)obj;
		return objectTest.id == this.id;
	}
	
	@Override
	public String toString() {
		StringBuffer string = new StringBuffer();
		string.append("ObjectTest :");
		string.append("\tid :"+id);
		string.append("\tobjectTest :"+objectTest);
		return string.toString();
	}
	
	
	
}
