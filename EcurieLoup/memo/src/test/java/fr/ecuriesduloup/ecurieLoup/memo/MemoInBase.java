package fr.ecuriesduloup.ecurieLoup.memo;

import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;



public class MemoInBase {
	

	
	public static Memo getMemo(){
		Memo memo = new Memo();
		memo.setId(1);
		memo.setSender(UserInBase.getUtilisateurToutDroit());
		memo.setReceiver(UserInBase.getUtilisateurSansDroit());
		memo.setDescription("Description of memo");
		memo.setPostedDate(123456);
		memo.setDeadLine(123456789);
		memo.setPrivateMemo(true);
		memo.setMemoIsDo(true);
		return memo;
	}

}
