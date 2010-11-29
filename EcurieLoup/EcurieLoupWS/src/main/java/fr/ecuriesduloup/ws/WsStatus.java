package fr.ecuriesduloup.ws;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("WsStatus")
public class WsStatus {
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

}
