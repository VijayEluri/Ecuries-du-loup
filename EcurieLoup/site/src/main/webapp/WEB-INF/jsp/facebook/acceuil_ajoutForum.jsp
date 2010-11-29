<p>
	<div class="lien">
		<c:choose>
			<c:when test="${forumNombreNouveauxMessages == 0}">
				<fmt:message key="facebook.acceuil.forum.nouveaux_messages.aucun" />
			</c:when>
			<c:when test="${forumNombreNouveauxMessages == 1}">
				<a href="${ctx}/forum/affichage.do?nonLu" target="_blank"> <fmt:message
					key="facebook.acceuil.forum.nouveau_message.un" /> </a>
			</c:when>
			<c:otherwise>
		
				<a href="${ctx}/forum/affichage.do?nonLu" target="_blank"> <fmt:message
					key="facebook.acceuil.forum.nouveau_message.plusieurs">
					<fmt:param>${ nombreNouvellesPhotos}</fmt:param>
				</fmt:message> </a>
			</c:otherwise>
		
		</c:choose>
	</div>
</p>