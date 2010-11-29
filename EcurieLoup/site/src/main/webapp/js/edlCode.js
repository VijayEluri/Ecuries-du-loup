var isMozilla = (navigator.userAgent.toLowerCase().indexOf('gecko')!=-1) ? true : false;
var regexp = new RegExp("[\r]","gi");

function strlen(string){
	return string.length;
}

function storeCaretPareil(selec)
{
	storeCaret(selec, selec);
}

function storeCaret(selecAvant, selecApres)
{
	oField = document.getElementById('texteareaEdlCode');
	if (isMozilla) 
	{
	// Si on est sur Mozilla
		//oField = document.forms['news'].elements['newst'];

		objectValue = oField.value;

		deb = oField.selectionStart;
		fin = oField.selectionEnd;

		objectValueDeb = objectValue.substring( 0 , oField.selectionStart )+"";
		objectValueFin = objectValue.substring( oField.selectionEnd , oField.textLength )+"";
		objectSelected = objectValue.substring( oField.selectionStart ,oField.selectionEnd );

	//	alert("Debut:'"+objectValueDeb+"' ("+deb+")\nFin:'"+objectValueFin+"' ("+fin+")\n\nSelectionné:'"+objectSelected+"'("+(fin-deb)+")");
			
		oField.value = objectValueDeb + "[" + selecAvant + "]" + objectSelected + "[/" + selecApres + "]" + objectValueFin;
		oField.selectionStart = strlen(objectValueDeb);
		oField.selectionEnd = strlen(objectValueDeb + "[" + selecAvant + "]" + objectSelected + "[/" + selecApres + "]");
		oField.focus();
		oField.setSelectionRange(
			objectValueDeb.length + selecAvant.length + 2,
			objectValueDeb.length + selecApres.length + 2);
	}
	else
	{
	// Si on est sur IE
		
	//	oField = document.forms['news'].elements['newst'];
		var str = document.selection.createRange().text;

		if (str.length>0)
		{
		// Si on a selectionné du texte
			var sel = document.selection.createRange();
			sel.text = "[" + selecAvant + "]" + str + "[/" + selecApres + "]";
			sel.collapse();
			sel.select();
		}
		else
		{
			oField.focus(oField.caretPos);
		//	alert(oField.caretPos+"\n"+oField.value.length+"\n")
			oField.focus(oField.value.length);
			oField.caretPos = document.selection.createRange().duplicate();
			
			var bidon = "%~%";
			var orig = oField.value;
			oField.caretPos.text = bidon;
			var i = oField.value.search(bidon);
			oField.value = orig.substr(0,i) + "[" + selecAvant + "][/" + selecApres + "]" + orig.substr(i, oField.value.length);
			var r = 0;
			for(n = 0; n < i; n++)
			{if(regexp.test(oField.value.substr(n,2)) == true){r++;}};
			pos = i + 2 + selec.length - r;
			//placer(document.forms['news'].elements['newst'], pos);
			var r = oField.createTextRange();
			r.moveStart('character', pos);
			r.collapse();
			r.select();

		}
	}
}

function monoBalise(balise)
{
	oField = document.getElementById('texteareaEdlCode');
	if (isMozilla) 
	{
	// Si on est sur Mozilla
		//oField = document.forms['news'].elements['newst'];

		objectValue = oField.value;

		deb = oField.selectionStart;
		fin = oField.selectionEnd;

		objectValueDeb = objectValue.substring( 0 , oField.selectionStart );
		objectValueFin = objectValue.substring( oField.selectionEnd , oField.textLength );
		objectSelected = objectValue.substring( oField.selectionStart ,oField.selectionEnd );

	//	alert("Debut:'"+objectValueDeb+"' ("+deb+")\nFin:'"+objectValueFin+"' ("+fin+")\n\nSelectionné:'"+objectSelected+"'("+(fin-deb)+")");
			
		oField.value = objectValueDeb + "[" + balise + "]" + objectValueFin;
		oField.selectionStart = strlen(objectValueDeb);
		oField.selectionEnd = strlen(objectValueDeb + "[" + balise + "]");
		oField.focus();
		oField.setSelectionRange(
			objectValueDeb.length + balise.length + 2,
			objectValueDeb.length + balise.length + 2);
	}
	else
	{
	// Si on est sur IE
		
	//	oField = document.forms['news'].elements['newst'];
		var str = document.selection.createRange().text;

		if (str.length>0)
		{
		// Si on a selectionné du texte
			var sel = document.selection.createRange();
			sel.text = "[" + balise + "]";
			sel.collapse();
			sel.select();
		}
		else
		{
			oField.focus(oField.caretPos);
		//	alert(oField.caretPos+"\n"+oField.value.length+"\n")
			oField.focus(oField.value.length);
			oField.caretPos = document.selection.createRange().duplicate();
			
			var bidon = "%~%";
			var orig = oField.value;
			oField.caretPos.text = bidon;
			var i = oField.value.search(bidon);
			oField.value = orig.substr(0,i) + "[" + balise + "]" + orig.substr(i, oField.value.length);
			var r = 0;
			for(n = 0; n < i; n++)
			{if(regexp.test(oField.value.substr(n,2)) == true){r++;}};
			pos = i + 2 + selec.length - r;
			//placer(document.forms['news'].elements['newst'], pos);
			var r = oField.createTextRange();
			r.moveStart('character', pos);
			r.collapse();
			r.select();

		}
	}
}

function ajoutSmiley(balise)
{
	oField = document.getElementById('texteareaEdlCode');
	if (isMozilla) 
	{
	// Si on est sur Mozilla
		//oField = document.forms['news'].elements['newst'];

		objectValue = oField.value;

		deb = oField.selectionStart;
		fin = oField.selectionEnd;

		objectValueDeb = objectValue.substring( 0 , oField.selectionStart );
		objectValueFin = objectValue.substring( oField.selectionEnd , oField.textLength );
		objectSelected = objectValue.substring( oField.selectionStart ,oField.selectionEnd );

	//	alert("Debut:'"+objectValueDeb+"' ("+deb+")\nFin:'"+objectValueFin+"' ("+fin+")\n\nSelectionné:'"+objectSelected+"'("+(fin-deb)+")");
			
		oField.value = objectValueDeb +  balise + objectValueFin;
		oField.selectionStart = strlen(objectValueDeb);
		oField.selectionEnd = strlen(objectValueDeb + balise );
		oField.focus();
		oField.setSelectionRange(
			objectValueDeb.length + balise.length + 2,
			objectValueDeb.length + balise.length + 2);
	}
	else
	{
	// Si on est sur IE
		
	//	oField = document.forms['news'].elements['newst'];
		var str = document.selection.createRange().text;

		if (str.length>0)
		{
		// Si on a selectionné du texte
			var sel = document.selection.createRange();
			sel.text = "[" + balise + "]";
			sel.collapse();
			sel.select();
		}
		else
		{
			oField.focus(oField.caretPos);
		//	alert(oField.caretPos+"\n"+oField.value.length+"\n")
			oField.focus(oField.value.length);
			oField.caretPos = document.selection.createRange().duplicate();
			
			var bidon = "%~%";
			var orig = oField.value;
			oField.caretPos.text = bidon;
			var i = oField.value.search(bidon);
			oField.value = orig.substr(0,i) + balise + orig.substr(i, oField.value.length);
			var r = 0;
			for(n = 0; n < i; n++)
			{if(regexp.test(oField.value.substr(n,2)) == true){r++;}};
			pos = i + 2 + selec.length - r;
			//placer(document.forms['news'].elements['newst'], pos);
			var r = oField.createTextRange();
			r.moveStart('character', pos);
			r.collapse();
			r.select();

		}
	}
}

function ajoutPolice()
{
	var police = document.getElementById('policeEdlCode').value;
	storeCaret("police=\""+police+"\"", "police");
}

function ajoutTaille()
{
	var taille = document.getElementById('tailleEdlCode').value;
	storeCaret("taille=\""+taille+"\"", "taille");
}


function ajoutLien()
{
	var lien = "";
	lien = prompt("Saisissez votre lien :");
	storeCaret("lien=\""+lien+"\"", "lien");
}

function ajoutImage()
{
	window.open(ctx+'/eldCode/choixImage.do','popupchoix','fullscreen=yes,menubar=no,status=no,scrollbars=yes');

	/*var image = "";
	image = prompt("Saisissez l'adresse de l'image :");*/
	//monoBalise("image=\""+image+"\"");
}

function ajoutCouleur()
{
	var couleur = document.getElementById('couleurEdlCode').value;
	storeCaret("couleur=\""+couleur+"\"", "couleur");
}

function ajoutFond()
{
	var fond = document.getElementById('couleurFondEdlCode').value;
	storeCaret("fond=\""+fond+"\"", "fond");
}


function changementCategorieSmiley(categorieSelectionner){
	
	var noms = document.getElementById("nom_categorie_smiley");
	var elements = noms.getElementsByTagName("span");
	
	for (var i = 0; i < elements.length; i++) { 
	    var element = elements[i];
	    if(categorieSelectionner == element.id ){
	    	element.className= "categorieSelectionner";
	    	document.getElementById("smiley_"+element.id).className ="smiley_de_categorie_visible";
	    }else{
	    	element.className= "categorieNonSelectionner";
	    	document.getElementById("smiley_"+element.id).className ="smiley_de_categorie_non_visible";
	    }
	}

}

function changeModeImageEdlCode(){
	var url = document.getElementById("url").checked;
	var id = document.getElementById("id").checked;
	if(url){
		document.getElementById("imageUrl").className="choix_type_image_selected";
		document.getElementById("imageAlbum").className="choix_type_image_non_selected";
		modificationUrl();
		
	}else if(id){
		document.getElementById("imageUrl").className="choix_type_image_non_selected";
		document.getElementById("imageAlbum").className="choix_type_image_selected";
		if(document.getElementById("selected")!=null){
			selectionnePhoto(document.getElementById("selected").alt);
		}
		
	}
}

function modificationUrl(){
	var valeurUrl = document.getElementById("valeurUrl").value;
	document.getElementById("photoSelectionner").src= valeurUrl;
}

function validerChoixImage() {
	var url = document.getElementById("url").checked;
	var id = document.getElementById("id").checked;
	if(url){
		var valeurUrl = document.getElementById("valeurUrl").value;
		window.opener.monoBalise("image=\""+valeurUrl+"\"");
		window.close();
		
	}else if(id){
		var valeur=document.getElementById("idPhoto").value;
		window.opener.monoBalise("imageSite=\""+valeur+"\"");
		window.close();
		
	}
	
}

