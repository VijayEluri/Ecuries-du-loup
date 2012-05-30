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
		&gt; <a	id="browneAlbum" href=""></a>
		&gt; <fmt:message key="album_photo.navigation.picture"/> <span class="mediaId"></span>
	</div>
	
	<div class="albumPhoto">
		<div id="nouveauTage" class="cadreTague">
		</div>
		
		
		<div id="saisisTag">
			
			<input id="id_tag" name="id_tag" type="hidden" />			
			<input id="input_tag_x" name="tag_x" type="hidden" />
			<input id="input_tag_y" name="tag_y" type="hidden"/>
			<input id="tag_valid" value="Ok" type="button" />
		</div>
		
		
	<div class="visualisationPhoto">
		<form method="post">
			<h1><fmt:message key="album_photo.photo.title"/><span class="mediaId"></span>
				<a id="fullImage" class="nyroModal"	href="#fullImageElement">
					<img class="title_action" src="${ctx}/images/loupe.png" alt="<fmt:message key="album_photo.photo.zoom.alt"/>" title="<fmt:message key="album_photo.photo.zoom.title"/>" />
				</a>
				<a id="downloadButton"	href="">
					<img class="title_action" src="${ctx}/images/button_download.png" alt="<fmt:message key="album_photo.photo.download.alt"/>" title="<fmt:message key="album_photo.photo.download.title"/>" />
				</a>
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_PHOTO">
					<a id="deleteButton"	href="">
						<img src="${ctx}/images/delete.png" alt="<fmt:message key="album_photo.photo.delete.alt"/>" title="<fmt:message key="album_photo.photo.delete.title"/>" />
					</a>
				</security:authorize>
			</h1>
			<div id="fullImageElement" style="display: none">
				<img src="" style="max-width: 100%; max-height: 100%"  />
			</div>
			<fmt:message key="album_photo.photo.by"/><span id="poster"></span>
			
			
			
			<div id="navigation_album" class="navigation_album">
			</div>
			<!-- affichage de la photo en cours -->
			<div id="photo_principal" class="photo_principal">				
			</div>
			
			
			<div id="tags">
				<span id="tagsList"></span>
			</div>

			<div class="description">
				<security:authorize ifAllGranted="ROLE_ADMINISTRATEUR_PHOTO">
					<textarea id="descriptionTextarea" name="description"></textarea>
					<br />
					<input type="submit" value="<fmt:message key="album_photo.photo.description.submit"/>" />
				</security:authorize>
				<security:authorize ifNotGranted="ROLE_ADMINISTRATEUR_PHOTO">
					<p id="descriptionP" ></p>
				</security:authorize>
			</div>
			<!-- facebook like ${ctx}-->
			<iframe id="facebookIframe" src="" scrolling="no" frameborder="0" style="border:none; overflow:hidden; width:450px; height:80px;" allowTransparency="true"></iframe>
			
			<script type="text/javascript" >
				var albumId = "${albumId}";
				var mediaId = "${mediaId}";
				var searchTag = "${searchTag}";
				var options = "${options}";
				$("#photo_principal" ).mediaDisplayer({album:albumId, beginMedia: mediaId, tag : searchTag, options: options });
				$("#tags" ).tagAppender();
				$(function() {
				    $('.nyroModal').nyroModal();
				  });
				
				</script>
			<div id="fullImage" class="commentaires"></div>


		</form>
	</div>
</div>
</div>



<!-- on importe le pied de la page -->
<%@ include file="../foot.jsp"%>
