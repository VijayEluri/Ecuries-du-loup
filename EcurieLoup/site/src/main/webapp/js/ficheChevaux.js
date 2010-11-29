function convertirDateNaissance(){

	var avant = document.getElementById("dateNaissanceCheval").value;

	var tabDate = avant.split("/");
	var date = new Date(tabDate[2], (tabDate[1]-1), tabDate[0]);
	document.getElementById("dateDateNaissanceInTimestamp").value = date.getTime();
}

function changementTypeDateNaissance(){
	var annee = document.getElementById("radio_annee_naissance").checked;
	var date = document.getElementById("radio_date_naissance").checked;
	if(annee){
		document.getElementById("dateNaissance").className="date_invisible";
		document.getElementById("anneeNaissance").className="date_visible";
	}else if(date){
		document.getElementById("dateNaissance").className="date_visible";
		document.getElementById("anneeNaissance").className="date_invisible";
	}
}

function ouvrirPopupChoixPhotoFicheCheval(idChamps){
	var valeurChamps = document.forms["ficheCheval"].elements[idChamps].value;
	window.open(ctx+'/ficheChevaux/administration/choixPhoto.do?champs='+idChamps+"&valeur="+valeurChamps,'popupchoix','fullscreen=yes,menubar=no,status=no,scrollbars=yes');

}

function reporter(idChamps) {
	var valeur=document.getElementById("idPhoto").value;
	window.opener.document.forms["ficheCheval"].elements[idChamps].value=valeur;
	window.opener.document.getElementById("img_"+idChamps).src=ctx+'/images/albumPhoto/miniatures/'+valeur;
	window.close();
}

function selectionnePhoto(idPhoto){
	if(document.getElementById("selected")!=null){
		document.getElementById("selected").id="photo_num_"+document.getElementById("selected").alt;
	}
	document.getElementById("photo_num_"+idPhoto).id="selected";
	document.getElementById("photoSelectionner").src= document.getElementById("selected").src;
	document.getElementById("idPhoto").value=idPhoto;
}

/*********************************************************************/
function affichePhotoGrand(event, idPhoto){
	var x = 10 + event.clientX + (document.body.scrollLeft || document.documentElement.scrollLeft);
	var y = 10 + event.clientY + (document.body.scrollTop || document.documentElement.scrollTop);

	/*x-=document.getElementById(idPhoto).width;
	y-=document.getElementById(idPhoto).height;*/

	document.getElementById(idPhoto).style.top=y+"px";
	document.getElementById(idPhoto).style.left=x+"px";

	document.getElementById(idPhoto).style.display = "block";
	
	//alert("hauteur : "+document.body.clientHeight+ ", largeur "+document.body.clientWidth+"\nh "+document.getElementById(idPhoto).height+", w "+document.getElementById(idPhoto).width)
}

function cachePhotoGrand(idPhoto){
	document.getElementById(idPhoto).style.display = "none";
}
