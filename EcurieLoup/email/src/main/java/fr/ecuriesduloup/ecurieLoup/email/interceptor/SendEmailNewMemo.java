package fr.ecuriesduloup.ecurieLoup.email.interceptor;

import java.util.ArrayList;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import fr.ecuriesduloup.ecurieLoup.email.service.memo.SendEmailMemo;
import fr.ecuriesduloup.ecurieLoup.memo.data.Memo;

public class SendEmailNewMemo implements MethodInterceptor{
	private List<Memo> emailSendFor;
	private SendEmailMemo sendEmailMemo;
	
	public SendEmailNewMemo() {
		this.emailSendFor = new ArrayList<Memo>();
	}
	
	public void setSendEmailMemo(SendEmailMemo sendEmailMemo) {
		this.sendEmailMemo = sendEmailMemo;
	}
	
	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		try{
			method.proceed();
			Memo memo = (Memo)method.getArguments()[0];
			if(!this.emailSendFor.contains(memo)){
				this.emailSendFor.add(memo);
				this.sendEmailMemo.sendEmailNewMemo(memo);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	


	
}
