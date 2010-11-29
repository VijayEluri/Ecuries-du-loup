<p>
	<div class="lien">
		<c:choose>
			<c:when test="${albumPhotoNombreNouvellesPhotos == 0}">
				<fmt:message key="facebook.acceuil.album.nouvelle_photo.aucune" />
			</c:when>
			<c:when test="${albumPhotoNombreNouvellesPhotos == 1}">
				<a href="${ctx}/albumPhoto/affichage.do?nonVu" target="_blank" >
					<fmt:message key="facebook.acceuil.album.nouvelle_photo.une" />
				</a>
			</c:when>
			<c:otherwise>
				<a href="${ctx}/albumPhoto/affichage.do?nonVu" target="_blank" >
					<fmt:message key="facebook.acceuil.album.nouvelle_photo.plusieurs">
						<fmt:param>${ albumPhotoNombreNouvellesPhotos}</fmt:param>
					</fmt:message>
				</a>
			</c:otherwise>
		</c:choose>
	</div>
</p>