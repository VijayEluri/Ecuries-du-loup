<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<%@ include file="../headerLight.jsp"%>
<div id="selection_photo" >
	<input type="hidden" id="idPhoto" value="${valeurChamps}"/>
	
	
	<img id="photoSelectionner" alt="photo Selectionner" src="${ctx}/images/albumPhoto/miniatures/${valeurChamps}" />
	<input type="button" value="Annuler" onclick="window.close();"/>
	<input type="button" value="OK" onclick="reporter('${idChamps}')"/>
	
	<%@ include file="../affichageChoixPhotoAlbum.jsp"%>
</div>
<%@ include file="../foot.jsp"%>