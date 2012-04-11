<script>
var user = "${userOfCard.login}";
$(function() {
	$( "#photosAlbums" ).photosAlbum({tag : user});
});
</script>
<div id="photosAlbums">
</div>