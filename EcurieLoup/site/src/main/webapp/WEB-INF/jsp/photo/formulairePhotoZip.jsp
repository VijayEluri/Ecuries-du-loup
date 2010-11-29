<form method="post" enctype="multipart/form-data">
	<p><fmt:message key="album_photo.photo.zip.form.consigne" /></p>
	
	<spring:bind path="photo.zip">
		<fmt:message key="album_photo.photo.zip.form.zip" />
		<input type="File" name="zip" />
						      	
		&#160;
		<span class="error">
			<c:out value="${status.errorMessage}" />
		</span>
	</spring:bind>
	<br />
	<br />
	<input type="submit" value="<fmt:message key="album_photo.photo.zip.form.submit" />" />
</form>
