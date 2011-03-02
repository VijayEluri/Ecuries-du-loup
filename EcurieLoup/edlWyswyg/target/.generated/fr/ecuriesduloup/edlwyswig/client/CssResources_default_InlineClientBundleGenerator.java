package fr.ecuriesduloup.edlwyswig.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ResourcePrototype;

public class CssResources_default_InlineClientBundleGenerator implements fr.ecuriesduloup.edlwyswig.client.CssResources {
  public fr.ecuriesduloup.edlwyswig.client.ui.board.BoardCss boardCss() {
    return boardCss;
  }
  public fr.ecuriesduloup.edlwyswig.client.ui.portlet.PortletCss portletCss() {
    return portletCss;
  }
  private void _init0() {
    boardCss = new fr.ecuriesduloup.edlwyswig.client.ui.board.BoardCss() {
    private boolean injected;
    public boolean ensureInjected() {
      if (!injected) {
        injected = true;
        com.google.gwt.dom.client.StyleInjector.inject(getText());
        return true;
      }
      return false;
    }
    public String getName() {
      return "boardCss";
    }
    public String getText() {
      return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GMBOU4DCEG{height:" + ("20px")  + ";width:" + ("100%")  + ";background-color:" + ("fuchsia")  + ";}.GMBOU4DCDG{width:" + ("50px")  + ";}")) : ((".GMBOU4DCEG{height:" + ("20px")  + ";width:" + ("100%")  + ";background-color:" + ("fuchsia")  + ";}.GMBOU4DCDG{width:" + ("50px")  + ";}"));
    }
    public java.lang.String boardElement(){
      return "GMBOU4DCDG";
    }
    public java.lang.String boardTable(){
      return "GMBOU4DCEG";
    }
  }
  ;
    portletCss = new fr.ecuriesduloup.edlwyswig.client.ui.portlet.PortletCss() {
    private boolean injected;
    public boolean ensureInjected() {
      if (!injected) {
        injected = true;
        com.google.gwt.dom.client.StyleInjector.inject(getText());
        return true;
      }
      return false;
    }
    public String getName() {
      return "portletCss";
    }
    public String getText() {
      return com.google.gwt.i18n.client.LocaleInfo.getCurrentLocale().isRTL() ? ((".GMBOU4DCPG{background-color:" + ("blue")  + ";}.GMBOU4DCFG{background-color:" + ("green")  + ";}.GMBOU4DCGG{background-color:" + ("red")  + ";}.GMBOU4DCIG{cursor:" + ("n-resize")  + ";}.GMBOU4DCJG{cursor:" + ("nw-resize")  + ";}.GMBOU4DCHG{cursor:" + ("w-resize")  + ";}.GMBOU4DCMG{cursor:" + ("sw-resize")  + ";}.GMBOU4DCLG{cursor:" + ("s-resize")  + ";}.GMBOU4DCNG{cursor:" + ("se-resize")  + ";}.GMBOU4DCOG{cursor:" + ("e-resize")  + ";}.GMBOU4DCKG{cursor:") + (("ne-resize")  + ";}")) : ((".GMBOU4DCPG{background-color:" + ("blue")  + ";}.GMBOU4DCFG{background-color:" + ("green")  + ";}.GMBOU4DCGG{background-color:" + ("red")  + ";}.GMBOU4DCIG{cursor:" + ("n-resize")  + ";}.GMBOU4DCJG{cursor:" + ("ne-resize")  + ";}.GMBOU4DCHG{cursor:" + ("e-resize")  + ";}.GMBOU4DCMG{cursor:" + ("se-resize")  + ";}.GMBOU4DCLG{cursor:" + ("s-resize")  + ";}.GMBOU4DCNG{cursor:" + ("sw-resize")  + ";}.GMBOU4DCOG{cursor:" + ("w-resize")  + ";}.GMBOU4DCKG{cursor:") + (("nw-resize")  + ";}"));
    }
    public java.lang.String porletHeader(){
      return "GMBOU4DCFG";
    }
    public java.lang.String porletResizeBorder(){
      return "GMBOU4DCGG";
    }
    public java.lang.String porletResizeBorderEast(){
      return "GMBOU4DCHG";
    }
    public java.lang.String porletResizeBorderNorth(){
      return "GMBOU4DCIG";
    }
    public java.lang.String porletResizeBorderNorthEast(){
      return "GMBOU4DCJG";
    }
    public java.lang.String porletResizeBorderNorthWest(){
      return "GMBOU4DCKG";
    }
    public java.lang.String porletResizeBorderSouth(){
      return "GMBOU4DCLG";
    }
    public java.lang.String porletResizeBorderSouthEast(){
      return "GMBOU4DCMG";
    }
    public java.lang.String porletResizeBorderSouthWest(){
      return "GMBOU4DCNG";
    }
    public java.lang.String porletResizeBorderWest(){
      return "GMBOU4DCOG";
    }
    public java.lang.String portlet(){
      return "GMBOU4DCPG";
    }
  }
  ;
  }
  
  private static java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype> resourceMap;
  private static fr.ecuriesduloup.edlwyswig.client.ui.board.BoardCss boardCss;
  private static fr.ecuriesduloup.edlwyswig.client.ui.portlet.PortletCss portletCss;
  
  static {
    new CssResources_default_InlineClientBundleGenerator()._init0();
  }
  public ResourcePrototype[] getResources() {
    return new ResourcePrototype[] {
      boardCss(), 
      portletCss(), 
    };
  }
  public ResourcePrototype getResource(String name) {
    if (GWT.isScript()) {
      return getResourceNative(name);
    } else {
      if (resourceMap == null) {
        resourceMap = new java.util.HashMap<java.lang.String, com.google.gwt.resources.client.ResourcePrototype>();
        resourceMap.put("boardCss", boardCss());
        resourceMap.put("portletCss", portletCss());
      }
      return resourceMap.get(name);
    }
  }
  private native ResourcePrototype getResourceNative(String name) /*-{
    switch (name) {
      case 'boardCss': return this.@fr.ecuriesduloup.edlwyswig.client.CssResources::boardCss()();
      case 'portletCss': return this.@fr.ecuriesduloup.edlwyswig.client.CssResources::portletCss()();
    }
    return null;
  }-*/;
}
