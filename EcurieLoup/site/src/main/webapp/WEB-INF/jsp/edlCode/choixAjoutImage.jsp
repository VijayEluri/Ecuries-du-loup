<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<%@ include file="../headerLight.jsp"%>

<fmt:setBundle basename="i18n.edlCode"/>
<div id="selection_photo" >
	<input type="hidden" id="idPhoto" />
	
	<img id="photoSelectionner" alt="photo Selectionner" src="${ctx}/images/albumPhoto/miniatures/${valeurChamps}" />
	
	
	<div class="type_image">
		<input type="radio" name="typeImage" value="url" id="url" checked="checked" onchange="changeModeImageEdlCode()" />
		<label for="url">
			<fmt:message key="edlCode.image.url"/>
		</label> 
				
		<input type="radio" name="typeImage" value="id" id="id" onchange="changeModeImageEdlCode()" /> 
		<label for="id">
			<fmt:message key="edlCode.image.idPhoto"/>
		</label><br />
	</div>
	<input type="button" value="Annuler" onclick="window.close();"/>
	<input type="button" value="OK" onclick="validerChoixImage()"/>
	
	<div id="ajout_image_edlCode">
		<div id="imageUrl" class="choix_type_image_selected">
			<%@ include file="affichageChoixUrl.jsp"%>
		</div>
		<div id="imageAlbum" class="choix_type_image_non_selected">
			<%@ include file="../affichageChoixPhotoAlbum.jsp"%>
		</div>
	</div>
</div>
<%@ include file="../foot.jsp"%>