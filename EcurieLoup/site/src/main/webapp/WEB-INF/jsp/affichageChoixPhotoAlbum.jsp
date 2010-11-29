<ul>
	<c:forEach var="album" items="${listesAlbums}">
		<li class="titre_album">${album.titre }
			<ul class="contenu_album">
				 <c:forEach var="photo" items="${album.photos}">
				 	<c:choose>
				 		<c:when test="${photo.id==valeurChamps}">
				 			<img id="selected" src="${ctx}/images/albumPhoto/miniatures/${photo.id }" alt="${photo.id }" onclick="selectionnePhoto(${photo.id })"/>
				 		</c:when>
				 		<c:otherwise>
				 			<img id="photo_num_${photo.id}" src="${ctx}/images/albumPhoto/miniatures/${photo.id }" alt="${photo.id }" onclick="selectionnePhoto(${photo.id })"/>
				 		</c:otherwise>
				 	</c:choose>
					
				</c:forEach>
			</ul>	
		</li>
	</c:forEach>
</ul>