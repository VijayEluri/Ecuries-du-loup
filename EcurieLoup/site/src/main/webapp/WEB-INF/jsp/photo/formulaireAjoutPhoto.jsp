<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>


<fmt:setBundle basename="i18n.album_photo"/>

<div id="corps">
	<div class="albumPhoto">
		<div class="formulairePhoto">
			<h1><fmt:message key="album_photo.photo.form.title"/></h1>
			
			<spring:bind path="photo">
				<div class="error">
					<c:out value="${status.value}" />
				</div>
			</spring:bind>
			<div class="type_ajout">
				<input type="radio" name="typeAjout" value="simple" id="simple" checked="checked" onchange="changeModeAjoutPhoto()" />
				<label for="simple"><fmt:message key="album_photo.photo.form.simple"/></label>
				
				<input type="radio" name="typeAjout" value="zip" id="zip" onchange="changeModeAjoutPhoto()" />
				<label for="zip"><fmt:message key="album_photo.photo.form.zip"/></label><br />
			</div>
			
			<div id="ajout_album_formulaire">
				<div id="formulairePhotoSimple" class="ajout_album_parti_selected">
					<%@ include file="./formulairePhotoSimple.jsp"%>
				</div>
				<div id="formulairePhotoZip" class="ajout_album_parti_non_selected">
					<%@ include file="./formulairePhotoZip.jsp"%>
				</div>
			</div>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

