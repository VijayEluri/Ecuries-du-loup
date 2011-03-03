package fr.ecuriesduloup.ecurieLoup.memo;

import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;


public class MemoTestUtil {


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
