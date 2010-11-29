<form method="post">
	<spring:bind path="album">
		<div class="error">
			<c:out value="${status.value}" />
			<c:out value="${status.errorMessage}" />
		</div>
	</spring:bind>

	<p><fmt:message key="album_photo.album.simple.form.consigne"/></p>
	<spring:bind path="album.titre">
				<fmt:message key="album_photo.album.simple.form.title"/>
				<input type="text" name="titre" value="<c:out value="${album.titre}"/>" size="15" maxlength="50" />
				&#160;
				<span class="error">
					<c:out value="${status.errorMessage}" />
				</span>
	</spring:bind>
	<br />
	<br />
	<input type="submit" value="<fmt:message key="album_photo.album.simple.form.submit"/>" />

</form>