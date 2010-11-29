
var position_souris = new Array();
var en_cours_de_tagage = false;


function cours_tagage(){
	en_cours_de_tagage =!en_cours_de_tagage;
	var objet = document.getElementById("nouveauTage");
	var lien = document.getElementById("lien_activation_tagage");
	
	if(!en_cours_de_tagage){

		cachageSaisiTag();
		objet.style.cursor= "crosshair";
		objet.style.cursor= "default";
		document.getElementById("photo_taggage").style.cursor= "default";
		
		lien.innerHTML ="Tagger des gens";

	}else{
		objet.style.cursor= "crosshair";
		document.getElementById("photo_taggage").style.cursor= "crosshair";
		lien.innerHTML ="Arreter le taggage";
	}
}


function taggage(){
	if(en_cours_de_tagage){
		var objet = document.getElementById("nouveauTage");
		objet.style.border= "4px solid black";
		
		var position_photo = getPosition("photo_taggage");


		var position_tague_x = position_souris[0] - position_photo[0];
		var position_tague_y = position_souris[1] - position_photo[1];
		positonnerRectangle("nouveauTage", position_tague_x,  position_tague_y, 100, 100);
		
		affichageSaisiTag(position_tague_x , position_tague_y);
	}
}

function affichageSaisiTag(x, y){
	var objet = document.getElementById("saisisTag");
	
	var position_photo = getPosition("photo_taggage");
	

	document.getElementById("input_tag_x").value = x;
	document.getElementById("input_tag_y").value = y;
	
	x += position_photo[0];
	y += position_photo[1];
	
	objet.style.left = (x+100)+"px";
	objet.style.top = y+"px";
	objet.style.visibility = "visible";
	
	document.getElementById("input_tag_nom").focus();
}

function submitTagage(){
	var nom = document.getElementById("input_tag_nom").value;
	var x = document.getElementById("input_tag_x").value;
	var y = document.getElementById("input_tag_y").value;
	var photo = document.getElementById("input_tag_photo").value;
	
	var taillePhotoX = document.getElementById("photo_taggage").width;
	var taillePhotoY = document.getElementById("photo_taggage").height;
	var xEnPC = x/taillePhotoX*100;
	var yEnPC = y/taillePhotoY*100;
	
	if(nom != ""){
		
		enregistrementTag(photo, xEnPC, yEnPC, nom);
	}
	cachageSaisiTag();
	
	return false;
}

function enregistrementTag(photo, x, y, nom){
	var xhr=null;
    
    if (window.XMLHttpRequest) { 
        xhr = new XMLHttpRequest();
    }
    else if (window.ActiveXObject) 
    {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }

    var url =ctx+"/albumPhoto/tagage.do?photo="+photo+"&x="+x+"&y="+y+"&nom="+nom;
   
    xhr.open("GET", url, false);
    xhr.send(null);
    

}

function cachageSaisiTag(){
	var objet = document.getElementById("saisisTag");
	objet.style.visibility = "hidden";
	rendreInvisibleRectangle("nouveauTage");
	
	document.getElementById("input_tag_nom").value = "";
	document.getElementById("input_tag_x").value = "";
	document.getElementById("input_tag_y").value = "";
}


function getPosition(element)
{
	var left = 0;
	var top = 0;
	/*On récupère l'élément*/
	var e = document.getElementById(element);
	/*Tant que l'on a un élément parent*/
	while (e.offsetParent != undefined && e.offsetParent != null)
	{
		/*On ajoute la position de l'élément parent*/
		left += e.offsetLeft + (e.clientLeft != null ? e.clientLeft : 0);
		top += e.offsetTop + (e.clientTop != null ? e.clientTop : 0);
		e = e.offsetParent;
	}
	return new Array(left,top);
}

function positonnerRectangle(identifiant, x, y, largeur, hauteur){
	
	var objet = document.getElementById(identifiant);
	//on récupère les anciens sur onlaod
	var fonctionLoad = document.getElementById("photo_taggage").onload;
	document.getElementById("photo_taggage").onload = function(){
		//on appell les anciens onload
		if(fonctionLoad != null && typeof(fonctionLoad) == 'function') {
			fonctionLoad();
		}
		var position_photo = getPosition("photo_taggage");
		
		
		var taillePhotoX = document.getElementById("photo_taggage").width;
		var taillePhotoY = document.getElementById("photo_taggage").height;
		
		var xEnPx = x/100*taillePhotoX;
		var yEnPx = y/100*taillePhotoY;
	
		xEnPx+=position_photo[0];
		yEnPx+=position_photo[1];
		
		objet.style.left = xEnPx-(largeur/2)+"px";
		objet.style.top = yEnPx-(hauteur/2)+"px";
		objet.style.width = largeur+"px";
		objet.style.height = hauteur+"px";
		
		objet.style.visibility = "visible";
		//alert(taillePhotoX+" "+taillePhotoY )
	}
}
function rendreVisibleRectangle(identifiant){
	var objet = document.getElementById(identifiant);
	objet.style.border = "4px solid black";
}
function rendreInvisibleRectangle(identifiant){
	var objet = document.getElementById(identifiant);
	objet.style.border = "none";
}


function WhereMouse( e ){
	var DocRef;    
	if( e){              
		position_souris[0] = e.pageX;
		position_souris[1] = e.pageY;
	}else{
		position_souris[0] = event.clientX;
		position_souris[1] = event.clientY;

		if( document.documentElement && document.documentElement.clientWidth)
			DocRef = document.documentElement; 
		else
			DocRef = document.body;

		position_souris[0] += DocRef.scrollLeft;
		position_souris[1] += DocRef.scrollTop;
	}
}
document.onmousemove = WhereMouse;