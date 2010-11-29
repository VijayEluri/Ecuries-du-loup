<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<%@ include file="headerFacebook.jsp"%>

<fmt:setBundle basename="i18n.facebook"/>

<div id="facebook">
	<div id="corps">
		<div class="lien">
			<a href="${ctx }" target="_blank">
				<fmt:message key="facebook.acceuil.link.site" />
			</a>
		</div>
	
		<div class="forum">
			<%@ include file="acceuil_ajoutForum.jsp" %>
		</div>
	
		<div class="album_photo">
			<%@ include file="acceuil_ajoutAlbumPhotos.jsp" %>
		</div>
		
		<div class="lien">
			<a href="${ctx}/facebook/entrerUtilisateur.do"  >
				<fmt:message key="facebook.acceuil.changer_compte_associer"/>
			</a>
		</div>
	</div>

</div>