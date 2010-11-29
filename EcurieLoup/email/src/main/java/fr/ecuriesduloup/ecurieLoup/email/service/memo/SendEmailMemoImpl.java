package fr.ecuriesduloup.ecurieLoup.email.service.memo;

import fr.ecuriesduloup.ecurieLoup.email.type.EmailHtmlCustom;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;
import fr.ecuriesduloup.util.message.MessageI18nManager;

public class SendEmailMemoImpl implements SendEmailMemo {
	private String adresseEmailMemo;
	private MessageI18nManager i18nManager;


	public void setI18nManager(MessageI18nManager i18nManager) {
		this.i18nManager = i18nManager;
	}

	public void setAdresseEmailMemo(String adresseEmailMemo) {
		this.adresseEmailMemo = adresseEmailMemo;
	}

	@Override
	public void sendEmailNewMemo(Memo memo) {
		EmailHtmlCustom email = new EmailHtmlCustom(memo.getReceiver());
		email.addPatternReplace("{senderLogin}", memo.getSender().getLogin());
		
		email.setFrom(this.adresseEmailMemo);
		email.setSubject("Nouveau memo sur ecuriesduloup.fr");
		email.addReceiver(memo.getReceiver().getEmail());
		email.setMessage(this.i18nManager.getMessage("email.memo.new"));
		
		email.sendEmail();

	}

}
