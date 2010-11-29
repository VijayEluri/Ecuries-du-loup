package fr.ecurie_du_loup.generique_util.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import fr.ecurie_du_loup.generique_util.data.ObjectTestSample;

public final class ObjectTestSampleTestUtil {

	private ObjectTestSampleTestUtil(){
		
	}
	public static void compareJUnit(ObjectTestSample t1, ObjectTestSample t2) {
		assertEquals(t1.getId(), t2.getId());
		assertEquals(t1.getString1(), t2.getString1());
		assertEquals(t1.getString2(), t2.getString2());
		int time1 = (int)t1.getDate1().getTime();
		int time2 = (int)t2.getDate1().getTime();
		boolean dateEquals = false;
		if(time2 +10000 >= time1 && time2 <= time1){
			dateEquals = true;
		}else if(time1 +10000 >= time2 && time1 <= time2){
			dateEquals = true;
		}
		assertTrue("time 1: "+time1+" - date 2 : "+time2, dateEquals);
	}
	
	public static ObjectTestSample getNewObject() {
		ObjectTestSample objectTest  = new ObjectTestSample();
		
		objectTest.setString1("string21");
		objectTest.setString2("string22");
		objectTest.setDate1(new Date());
		return objectTest;
	}
	public static ObjectTestSample getObjectInBase() {
		ObjectTestSample objectTest  = new ObjectTestSample();
		objectTest.setId(1);
		objectTest.setString1("string11");
		objectTest.setString2("string12");
		objectTest.setDate1(new Date(1826410000));
		return objectTest;
	}
	
	public static void modificationObject(ObjectTestSample t) {
		t.setString1("string 1 modifier");
		
	}
}
