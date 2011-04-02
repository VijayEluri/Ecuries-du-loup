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
		<div class="navigation">
			&gt; <a href="${ctx}/albumPhoto/affichage.do"><fmt:message key="album_photo.navigation.album.list"/></a>
			&gt; <a	href="${ctx}/albumPhoto/affichagePhoto.do?idPhoto=${commentaire.media.id}">
					<fmt:message key="album_photo.navigation.picture"/> ${commentaire.media.id}
				</a>
			 &gt; <fmt:message key="album_photo.navigation.comment.form"/>
		</div>
		
		<div class="formulaireCommentaire">
			<h1><fmt:message key="album_photo.comment.form.title"/></h1>
			<form method="post">
			
				<spring:bind path="commentaire.contenu">
				
					<fmt:message key="album_photo.comment.form.comment"/>
					<br />
					<c:set var="nameContenuEDLCode" value="contenu" />
					<c:set var="valeurContenuEDLCode" value="${commentaire.contenu}" />
			
					<%@ include file="../contenuEDLcode.jsp"%>
					&#160;<span class="error">
						<c:out value="${status.errorMessage}" />
					</span>
				</spring:bind>
				<br />
				<br />
				<input type="submit" value="<fmt:message key="album_photo.comment.form.submit"/>" />
			</form>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>

