package fr.ecuriesduloup.ecurieLoup.memo;

import static org.junit.Assert.assertEquals;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;


public class MemoTestUtil {



	public static void compareJUnit(Memo memo1, Memo memo2) {
		assertEquals(memo1.getId(), memo2.getId());
		assertEquals(memo1.getDeadLine(), memo2.getDeadLine());
		assertEquals(memo1.getDescription(), memo2.getDescription());
		assertEquals(memo1.getPostedDate(), memo2.getPostedDate());
		assertEquals(memo1.getReceiver(), memo2.getReceiver());
		assertEquals(memo1.getSender(), memo2.getSender());
		assertEquals(memo1.isMemoIsDo(), memo2.isMemoIsDo());
		assertEquals(memo1.isPrivateMemo(), memo2.isPrivateMemo());
	}

	public static Memo getNewObject() {
		Memo memo = new Memo();
		long id = (long) (Math.random() * 1000000);
		memo.setId(id);
		memo.setDeadLine(123456789);
		memo.setDescription("description");
		memo.setMemoIsDo(false);
		memo.setPostedDate(123456);
		memo.setPrivateMemo(true);
		memo.setReceiver(UserInBase.getUtilisateurToutDroit());
		memo.setSender(UserInBase.getUtilisateurSansDroit());
		
		return memo;
	}

	

	public static void modificationObject(Memo t) {
		t.setDescription("description");

	}
}
