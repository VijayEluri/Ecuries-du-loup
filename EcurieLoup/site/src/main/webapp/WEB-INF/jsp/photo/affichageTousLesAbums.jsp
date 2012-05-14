<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>

<fmt:setBundle basename="i18n.album_photo"/>

<div id="corps">
	<div class="navigation">
		&gt; <fmt:message key="album_photo.navigation.album.list"/>
	</div>
	
	<div class="albumPhoto">
		<div class="visualisationTousLesAlbumsPhoto">
			<h1><fmt:message key="album_photo.all_album.title"/>
				<div id="nameFieldContainer"></div>		
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_PHOTO">
					<a href="${ctx}/albumPhoto/formulaireAlbum.do">
						<img alt="add" src="${ctx}/images/add.png" alt="<fmt:message key="album_photo.album.add" />" title="<fmt:message key="album_photo.album.add"/>" />
					
					</a>					
				</security:authorize>
			</h1>
			
			<c:if test="${!empty message }">
				<div class="information_message">
					<fmt:message key="${message}"/>
				</div>
			</c:if>
			
			<c:if test="${empty listeAlbums}">
				<p><fmt:message key="album_photo.album.empty_list"/></p>
			</c:if> 
			
			<c:forEach var="album" items="${listeAlbums}">
				<a href="${ctx}/albumPhoto/affichage.do?idAlbum=${album.id}">
					<div class="album">
						<c:if test="${album.mediasNotSee}">
							<img class="petit_icone_album" src="${ctx}/images/forum/nonVu.png" alt="*" />
							
						</c:if>
						
						<h2>${album.titre}</h2>
						<img src="${ctx}/images/albumPhoto/miniatures/${album.medias[0].id}" alt="${album.titre}" />
					</div>
				</a>
			</c:forEach>
		</div>
	</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>