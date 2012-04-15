<!-- if user connected : display photos-->
<security:authorize ifAllGranted="ROLE_AUTHENTIFIER">
var idFiche = "${ficheCheval.id}";
$(function() {
	$( "#photosAlbums" ).photosAlbum({tag : idFiche});
});
</script>
<div id="photosAlbums">
</div>
</security:authorize>

<!-- if user not connected : not display photos, display connected message-->
<security:authorize ifNotGranted="ROLE_AUTHENTIFIER">
	<fmt:message key="requiredAutentification" />
</security:authorize>
