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
		<form method="post" onsubmit="return submitTagage()">
		<p><fmt:message key="album_photo.photo.tag.form.name"/></p>
			<input id="input_tag_photo" name="tag_photo" type="hidden" value="${photo.id}" />
			<input id="input_tag_x" name="tag_x" type="hidden" />
			<input id="input_tag_y" name="tag_y" type="hidden"/>
			<input id="input_tag_nom" name="tag" type="text" />
			<br />
			<br />
			<input value="<fmt:message key="album_photo.photo.tag.form.submit"/>" type="submit" />
			<input value="<fmt:message key="album_photo.photo.tag.form.cancel"/>"	type="button" onclick="cachageSaisiTag()" />
		</form>
	</div>
	
		
	<div class="visualisationPhoto">
		<form method="post">
			<h1><fmt:message key="album_photo.photo.title"/>${photo.id} 
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
						<img id="photo_taggage"	src="${ctx}/images/albumPhoto/${photo.id}" alt="${photo.id}"	onclick="taggage()" />
					</c:when>
					<c:when test="${photo.type == 1}">
						<video width="80%" controls="controls" src="${ctx}/images/albumPhoto/${photo.id}.ogv">
							Ici la description alternative
						</video> 
					</c:when>
					<c:otherwise>Erreur</c:otherwise>
				</c:choose>
			
			</div>
			
			
			
			
			
			
			<c:if test="${!empty photo.tags}">
				<fmt:message key="album_photo.photo.tag.on_photo"/>-
				<c:forEach var="tag" items="${photo.tags}">
					<span class="nom_tag" onmouseover="rendreVisibleRectangle('tagage_${tag.id}')"	onmouseout="rendreInvisibleRectangle('tagage_${tag.id}')">
					<c:choose>
						<c:when test="${tag.path != null}">
							<a href="${ctx}${tag.path}" >${tag.display}</a>
						</c:when>
						<c:otherwise>
							${tag.display}
						</c:otherwise>
					</c:choose>
					
					 </span> - 
					<div id="tagage_${tag.id}" class="cadreTague" title="${tag.display}"></div>
					<script language="javascript">
					
								positonnerRectangle("tagage_${tag.id}",${tag.x}, ${tag.y}, 100, 100);
								
					</script>
				</c:forEach>
			</c:if>

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

			<span id="lien_activation_tagage" onclick="cours_tagage()">
				<fmt:message key="album_photo.photo.tag.add"/>
			</span>

			<%@ include file="./affichageCommentaires.jsp"%>

		</form>
	</div>
</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>