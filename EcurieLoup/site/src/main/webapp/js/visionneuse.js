function openVisionneuse(){
	
	window.open(ctx+'/albumPhoto/visionneuse.do','visionneuse','fullscreen=yes,menubar=no,status=no,scrollbars=yes');
}

function openVisionneuseAlbum(album){
	
	window.open(ctx+'/albumPhoto/visionneuse.do?album='+album,'visionneuse','fullscreen=yes,menubar=no,status=no,scrollbars=yes');
}