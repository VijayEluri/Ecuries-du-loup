<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://jakarta.apache.org/taglibs/datetime" prefix="dt"%>


<%@ include file="../header.jsp"%>


<!-- on importe le haut de la page -->
<%@ include file="../menu.jsp"%>


<fmt:setBundle basename="i18n.album_photo"/>

<div id="corps">

	<div class="navigation">
		&gt; <a href="${ctx}/albumPhoto/affichage.do"><fmt:message key="album_photo.navigation.album.list"/></a>
		&gt; <a	href="${ctx}/albumPhoto/affichage.do?idAlbum=${photo.album.id}">${photo.album.titre}</a>
		&gt; <fmt:message key="album_photo.navigation.picture"/> ${photo.id}
	</div>
	
	<div class="albumPhoto">
		<div id="nouveauTage" class="cadreTague">
		</div>
		
		
		<div id="saisisTag">
			<input id="input_tag_nom" name="input_tag_nom" type="text"/>
			<input id="tag_valid" value="Ok" type="button" />
			
			<input id="input_tag_photo" name="tag_photo" type="hidden" value="${photo.id}" />
			<input id="input_tag_x" name="tag_x" type="hidden" />
			<input id="input_tag_y" name="tag_y" type="hidden"/>
			<input id="id_tag" name="id_tag" type="hidden" />
		</div>
		
		
	<div class="visualisationPhoto">
		<form method="post">
			<h1><fmt:message key="album_photo.photo.title"/>${photo.id} 
				<a	href="${ctx}/albumPhoto/download.do?idMedia=${photo.id}">
						<img class="title_action" src="${ctx}/images/button_download.png" alt="<fmt:message key="album_photo.photo.download.alt"/>" title="<fmt:message key="album_photo.photo.download.title"/>" />
					</a>
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_PHOTO">
					<a	href="${ctx}/albumPhoto/affichage.do?idAlbum=${photo.album.id}&deletePhoto=${photo.id}">
						<img src="${ctx}/images/delete.png" alt="<fmt:message key="album_photo.photo.delete.alt"/>" title="<fmt:message key="album_photo.photo.delete.title"/>" />
					</a>
				</security:authorize>
			</h1>

			<fmt:message key="album_photo.photo.by"/>${photo.posteur.login}
			
			
			
			<div class="navigation_album">
				<!-- affichage en miniatude de la photo précédente -->
				<div class="photo_precedente">
					
					<c:if test="${photoPrecedente != null}">
						
						<a href="${ctx}/albumPhoto/affichagePhoto.do?idPhoto=${photoPrecedente.id}" >
							<div class="photo video">
								<c:if test="${photoPrecedente.type==1}">
									<div class="image_video">
									</div>				
								</c:if>	
								<img src="${ctx}/images/albumPhoto/miniatures/${photoPrecedente.id}" alt="<fmt:message key="album_photo.photo.previous.alt"/>" title="<fmt:message key="album_photo.photo.previous.title"/>" />
							</div>
						</a>
					</c:if>
				</div>
				<!-- affichage en miniatude de la photo suivante -->
				<div class="photo_suivante">
					
					<c:if test="${photoSuivante != null}">
						
						<a href="${ctx}/albumPhoto/affichagePhoto.do?idPhoto=${photoSuivante.id}" >
							<div class="photo video" >
								<c:if test="${photoSuivante.type==1}">
									<div class="image_video">
									</div>				
								</c:if>	
								<img src="${ctx}/images/albumPhoto/miniatures/${photoSuivante.id}" alt="<fmt:message key="album_photo.photo.next.alt"/>" title="<fmt:message key="album_photo.photo.next.title"/>"/>
							</div>
						</a>
					</c:if>
				</div>
			</div>
			<!-- affichage de la photo en cours -->
			<div class="photo_principal">
				<c:choose >
					<c:when test="${photo.type == 0}">
						<img id="photo_taggage"	src="${ctx}/images/albumPhoto/view/${photo.id}" alt="${photo.id}"/>
					</c:when>
					<c:when test="${photo.type == 1}">
						<video class="video_balise" controls="controls" >
							<source src="${ctx}/images/albumPhoto/${photo.id}.mp4" type="video/mp4" /> 
							<source src="${ctx}/images/albumPhoto/${photo.id}.webm" type="video/webm" /> 
							<source src="${ctx}/images/albumPhoto/${photo.id}.ogv" type="video/ogg" /> 
							Votre navigateur ne gère pas la balise vidéo. Veuillez mettre à jour votre navigateurs.
						</video> 
					</c:when>
					<c:otherwise>Erreur</c:otherwise>
				</c:choose>
			
			</div>
			
			
			
			
			<div id="tags">
				<img id="tagActivateButton" src="${ctx}/images/tag.jpeg" alt="<fmt:message key="album_photo.photo.tag"/>" title="Activer le taggage"/>			
				<c:if test="${!empty photo.tags}">					
					<c:forEach var="tag" items="${photo.tags}">						
						 <script language="javascript">
						 var infos =  { id : "${tag.id}", display : "${tag.display}", x :"${tag.x}", y : "${tag.y}", path: "${tag.path}"};
						 loadedTag.push(infos);
						</script>
					</c:forEach>
				</c:if>
			</div>

			<div class="description">
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_PHOTO">
					<textarea name="description">${photo.description}</textarea>
					<br />
					<input type="submit" value="<fmt:message key="album_photo.photo.description.submit"/>" />
				</security:authorize>
				<security:authorize ifNotGranted="ROLE_ADMINISTRATEUR_PHOTO">
					<p>${photo.description}</p>
				</security:authorize>
			</div>
			<!-- facebook like ${ctx}-->
			<iframe src="http://www.facebook.com/plugins/like.php?href=http%3A%2F%2F${header['host']}${ctx}%2Ffacebook%2FalbumPhoto%2FaffichagePhoto.do%3FidPhoto%3D${photo.id}&amp;layout=standard&amp;show_faces=true&amp;width=450&amp;action=like&amp;font=arial&amp;colorscheme=light&amp;height=80" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:450px; height:80px;" allowTransparency="true"></iframe>
			
			
			

			<%@ include file="./affichageCommentaires.jsp"%>

		</form>
	</div>
</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>
