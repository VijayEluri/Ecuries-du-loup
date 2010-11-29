<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../header.jsp"%>

<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.album_photo"/>

<div id="corps">

	<div class="navigation">
		&gt; <a href="${ctx}/albumPhoto/affichage.do"><fmt:message key="album_photo.navigation.album.list"/></a>
		&gt; ${album.titre}
	</div>
	
	<div class="albumPhoto">
		<div class="visualisationAlbumPhoto">
			<h1><fmt:message key="album_photo.album.title" />${album.titre} 
				<a href="javascript:openVisionneuseAlbum(${album.id});">
					<img alt="visionneuse" src="${ctx}/images/icone_visionneuse.gif" alt="<fmt:message key="album_photo.album.visionneuse.alt" />" title="<fmt:message key="album_photo.album.visionneuse.title"/>"/>
				</a>
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_PHOTO">
					<a href="${ctx}/albumPhoto/formulaireAlbum.do?album=${album.id}">
						<img src="${ctx}/images/edit.png" alt="<fmt:message key="album_photo.album.edit.alt" />" title="<fmt:message key="album_photo.album.edit.title" />" />
					</a>
					<a href="${ctx}/albumPhoto/affichage.do?deleteAlbum=${album.id}">
					<img src="${ctx}/images/delete.png" alt="<fmt:message key="album_photo.album.delete.alt" />" title="<fmt:message key="album_photo.album.delete.title" />" /></a>
				</security:authorize>
			</h1>
			
			<c:if test="${!empty message }">
				<div class="information_message">
					<fmt:message key="${message}"/>
				</div>
			</c:if>
			
			

			<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_PHOTO">
				<div class="lien">
					<a href="${ctx}/albumPhoto/formulaireNouvellePhoto.do?album=${album.id}">
						<fmt:message key="album_photo.album.add_photo" />
					</a>
				</div>
			</security:authorize>
			
			<c:if test="${empty listePhoto}">
				<p><fmt:message key="album_photo.album.empty_list" /></p>
	
			</c:if>
			
			<c:forEach var="photo" items="${listePhoto}">
				<a href="${ctx}/albumPhoto/affichagePhoto.do?idPhoto=${photo.id}">
					<div class="photo">
						
						<c:if test="${photo.datePostage > album.dateLecture}">
							<img class="petit_icone_album" src="${ctx}/images/forum/nonVu.png" alt="*" />
							
						</c:if>
						<img src="${ctx}/images/albumPhoto/miniatures/${photo.id}" alt="photo ${photo.id}" />
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>