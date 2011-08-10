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
	<div class="forum">
		<div class="formulaireAlbum">
			<h1><fmt:message key="album_photo.album.form.title"/></h1>
			
			<div class="type_ajout">
			
				<input type="radio" name="typeAjout" value="simple" id="simple" checked="checked" onchange="changeModeAjout()" />
				<label for="simple">
					<fmt:message key="album_photo.photo.form.simple"/>
				</label> 
				
				<input type="radio" name="typeAjout" value="zip" id="zip" onchange="changeModeAjout()" /> 
				<label for="zip">
					<fmt:message key="album_photo.photo.form.zip"/>
				</label>
				
				<br />
			</div>
			
			<div id="ajout_album_formulaire">
				<div id="formulaireAlbumSimple" class="ajout_album_parti_selected">
					<%@ include file="./formulaireAlbumSimple.jsp"%>
				</div>
				<div id="formulaireAlbumZip" class="ajout_album_parti_non_selected">
					<%@ include file="./formulaireAlbumZip.jsp"%>
				</div>
			</div>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

