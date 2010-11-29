<div class="commentaires">
	<div class="lien">
		<a	href="${ctx }/albumPhoto/formulaireCommentaire.do?photo=${photo.id}">
			<fmt:message key="album_photo.photo.comment.add"/>
		 </a>
	</div>

	<c:forEach var="commentaire" items="${photo.commentaires}">
		<div class="commentaire">
			<div class="entete">
				<fmt:message key="album_photo.photo.comment.by"/> ${commentaire.posteur.login} <dt:format	pattern="dd/MM/yyyy HH:mm"> ${commentaire.date}</dt:format>
			</div>
			<div class="body">
				${commentaire.contenu}
			</div>
		</div>
	</c:forEach>
</div>