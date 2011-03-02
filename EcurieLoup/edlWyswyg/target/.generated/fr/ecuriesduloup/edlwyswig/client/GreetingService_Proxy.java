package fr.ecuriesduloup.edlwyswig.client;

import com.google.gwt.user.client.rpc.impl.RemoteServiceProxy;
import com.google.gwt.user.client.rpc.impl.ClientSerializationStreamWriter;
import com.google.gwt.user.client.rpc.SerializationStreamWriter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.impl.RequestCallbackAdapter.ResponseReader;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.core.client.impl.Impl;
import com.google.gwt.user.client.rpc.impl.RpcStatsContext;

public class GreetingService_Proxy extends RemoteServiceProxy implements fr.ecuriesduloup.edlwyswig.client.GreetingServiceAsync {
  private static final String REMOTE_SERVICE_INTERFACE_NAME = "fr.ecuriesduloup.edlwyswig.client.GreetingService";
  private static final String SERIALIZATION_POLICY ="01A731C0E2C5A2BC4D571C7788583035";
  private static final fr.ecuriesduloup.edlwyswig.client.GreetingService_TypeSerializer SERIALIZER = new fr.ecuriesduloup.edlwyswig.client.GreetingService_TypeSerializer();
  
  public GreetingService_Proxy() {
    super(GWT.getModuleBaseURL(),
      "greet", 
      SERIALIZATION_POLICY, 
      SERIALIZER);
  }
  
  public void greetServer(java.lang.String input, com.google.gwt.user.client.rpc.AsyncCallback callback) {
    RpcStatsContext statsContext = new RpcStatsContext();
    boolean toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("GreetingService_Proxy.greetServer", "begin"));
    SerializationStreamWriter streamWriter = createStreamWriter();
    // createStreamWriter() prepared the stream
    try {
      streamWriter.writeString(REMOTE_SERVICE_INTERFACE_NAME);
      streamWriter.writeString("greetServer");
      streamWriter.writeInt(1);
      streamWriter.writeString("java.lang.String/2004016611");
      streamWriter.writeString(input);
      String payload = streamWriter.toString();
      toss = statsContext.isStatsAvailable() && statsContext.stats(statsContext.timeStat("GreetingService_Proxy.greetServer",  "requestSerialized"));
      doInvoke(ResponseReader.STRING, "GreetingService_Proxy.greetServer", statsContext, payload, callback);
    } catch (SerializationException ex) {
      callback.onFailure(ex);
    }
  }
}
