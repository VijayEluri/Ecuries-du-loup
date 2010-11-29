
<form method="post" enctype="multipart/form-data">
	<p><fmt:message key="album_photo.photo.simple.form.consigne" /></p>

	<spring:bind path="photo.fichier">
		<fmt:message key="album_photo.photo.simple.form.photo" />
		<input type="file" name="fichier" value="${photo.fichier }"/> 
					      	
		&#160;
		<span class="error">
			<c:out value="${status.errorMessage}" />
		</span>
	</spring:bind>
	<br />
	<br />
	<spring:bind path="photo.description">
		<fmt:message key="album_photo.photo.simple.form.describe" />
		<textarea name="description">${photo.description }</textarea>
		&#160;
		<span class="error">
			<c:out value="${status.errorMessage}" />
		</span>
	</spring:bind>
	 <br />
	<br />
<input type="submit" value="<fmt:message key="album_photo.photo.simple.form.submit" />" /></form>