
function changeModeAjout(){
	var simple = document.getElementById("simple").checked;
	var zip = document.getElementById("zip").checked;
	if(simple){
		document.getElementById("formulaireAlbumSimple").className="ajout_album_parti_selected";
		document.getElementById("formulaireAlbumZip").className="ajout_album_parti_non_selected";
		
		
	}else if(zip){
		document.getElementById("formulaireAlbumSimple").className="ajout_album_parti_non_selected";
		document.getElementById("formulaireAlbumZip").className="ajout_album_parti_selected";
	}
	
	
}

function changeModeAjoutPhoto(){
	var simple = document.getElementById("simple").checked;
	var zip = document.getElementById("zip").checked;
	if(simple){
		
		document.getElementById("formulairePhotoSimple").className="ajout_album_parti_selected";
		document.getElementById("formulairePhotoZip").className="ajout_album_parti_non_selected";
		
	}else if(zip){
		document.getElementById("formulairePhotoSimple").className="ajout_album_parti_non_selected";
		document.getElementById("formulairePhotoZip").className="ajout_album_parti_selected";
		
	}
}
