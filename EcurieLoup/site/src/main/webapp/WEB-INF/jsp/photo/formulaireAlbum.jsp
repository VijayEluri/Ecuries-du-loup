<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>


<fmt:setBundle basename="i18n.album_photo" />

<div id="corps">
	<div class="forum">
		<div class="formulaireAlbum">
			<h1>
				<fmt:message key="album_photo.album.form.title" />
			</h1>
			<div id="ajout_album_formulaire">
				<div id="formulaireAlbumSimple" class="ajout_album_parti_selected">
					<form method="post">
						<spring:bind path="album">
							<div class="error">
								<c:out value="${status.value}" />
								<c:out value="${status.errorMessage}" />
							</div>
						</spring:bind>

						<spring:bind path="album.titre">
							<fmt:message key="album_photo.album.simple.form.title" />
							<input type="text" name="titre"	value="<c:out value="${album.titre}"/>" placeholder="Mon titre d'album" size="15" maxlength="50" />
							&#160;<span class="error"> <c:out value="${status.errorMessage}" /></span>
						</spring:bind>
						<br />
						 <br /> 
						 <input type="submit" value="<fmt:message key="album_photo.album.simple.form.submit"/>" />

					</form>
				</div>
			</div>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

