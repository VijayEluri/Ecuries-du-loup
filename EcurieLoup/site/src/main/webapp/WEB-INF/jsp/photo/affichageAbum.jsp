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
				<c:if test="${album.id != 0}">
					<div id="nameFieldContainer"></div>		
					<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_PHOTO">
						<a href="${ctx}/albumPhoto/formulaireNouvellePhoto.do?album=${album.id}">
							<img alt="add" src="${ctx}/images/add.png" alt="<fmt:message key="yalbum_photo.album.add_photo" />" title="<fmt:message key="album_photo.album.add_photo"/>" />
						</a>
						<a href="${ctx}/albumPhoto/formulaireAlbum.do?album=${album.id}">
							<img src="${ctx}/images/edit.png" alt="<fmt:message key="album_photo.album.edit.alt" />" title="<fmt:message key="album_photo.album.edit.title" />" />
						</a>
						<a href="${ctx}/albumPhoto/affichage.do?deleteAlbum=${album.id}">
						<img src="${ctx}/images/delete.png" alt="<fmt:message key="album_photo.album.delete.alt" />" title="<fmt:message key="album_photo.album.delete.title" />" /></a>
					</security:authorize>
				</c:if>
			</h1>
			
			<c:if test="${!empty message }">
				<div class="information_message">
					<fmt:message key="${message}"/>
				</div>
			</c:if>
			
			<c:if test="${empty listePhoto}">
				<p><fmt:message key="album_photo.album.empty_list" /></p>
	
			</c:if>
			
			<c:forEach var="photo" items="${listePhoto}">
				<a href="${ctx}/albumPhoto/affichagePhoto.do?mediaId=${photo.id}&albumId=${album.id}">
					<div class="photo video">
						<c:if test="${photo.type==1}">
							<div class="image_video">
							</div>				
						</c:if>		
						<c:if test="${not(photo.readByCurrentUser)}">
						
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