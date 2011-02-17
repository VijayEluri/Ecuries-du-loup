package fr.ecuriesduloup.secretflag.client;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import fr.ecuriesduloup.secretflag.client.form.data.Data;

@RemoteServiceRelativePath("secretFlag")
public interface SecretFlagService  extends RemoteService {

	public List<Data> tryPassword(String password);

	public void saveData(List<Data> datas);
}
