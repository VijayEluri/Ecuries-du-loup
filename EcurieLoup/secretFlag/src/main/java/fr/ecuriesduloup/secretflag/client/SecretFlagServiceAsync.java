package fr.ecuriesduloup.secretflag.client;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fr.ecuriesduloup.secretflag.client.form.data.Data;

public interface SecretFlagServiceAsync {
	public void tryPassword(String password, AsyncCallback<List<Data>> callback);
	
	public void saveData(List<Data> datas, AsyncCallback<Void> callback);
}
