var tagging = false;
var cadreSize = 100;
var isfieldTagOpen = false;
var isMouseOnFieldTag = false;
var isOpenClick = false;
var loadedTag = [];



function createCookie(name,value,days) {
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else var expires = "";
	document.cookie = name+"="+value+expires+"; path=/";
}

function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

function eraseCookie(name) {
	createCookie(name,"",-1);
}


function saveStartTag(){
	createCookie("tag","open",1);
}
function saveStopTag(){
	eraseCookie("tag");
}
function isSaveTagOpenStared(){
	var open = readCookie("tag");
	if((open!=null)&&(open=="open")){
		return true;
	}else{
		return false;
	}
}

function startTag(){
	tagging =true;
	$("#nouveauTage").css({"cursor": "crosshair"});
	$("#photo_taggage").css({"cursor": "crosshair"});
	$("#tagActivateButton").attr("title", "Stopper le taggage");
	$("#tagActivateButton").attr("src", ctx+"/images/tag_actif.jpeg");
	saveStartTag();
}
function stopTag(){
	tagging = false;
	hideTagField();
	$("#nouveauTage").css({"cursor": "default"});
	$("#photo_taggage").css({"cursor": "default"});
	$("#tagActivateButton").attr("title", "Activer le taggage");
	$("#tagActivateButton").attr("src", ctx+"/images/tag.jpeg");
	saveStopTag();

}

function cleanTagField(){
	$("#id_tag").val("");
	$("#input_tag_nom").val("");
	$("input_tag_nom").val("");
	$("input_tag_x").val("");
	$("input_tag_y").val("");
}

function showTagField(x, y){	
	isOpenClick= true;
	x += 30;
	y += 30;
	
	$("#saisisTag").offset({ top : y, left : x });
	$("#saisisTag").css({"visibility": "visible"});
	
	$("#input_tag_nom").focus();
	isfieldTagOpen = true;
}

function recordTag(mediaId, x, y, name){
	
	var position = {x:x, y:y};
	$.ajax ({
		url : ctx+"/ws/albumPhoto/tag/"+mediaId+"/"+name,
		data: position, 
		context : position,
		type :"post",
		success : function (response, textStatus, xhr)
		{
			var id = $( xhr.responseXML).find("value").text();
			appendTag(id, name,this.x, this.y);
		},
		error : function (xhr, textStatus)
		{
			alert("error");
		}
		
	});
}
function saveTag(){
	var id = $("#id_tag").val();
	var x = $("#input_tag_x").val();
	var y = $("#input_tag_y").val();
	var photoId = $("#input_tag_photo").val();
	
	var widthPhoto = $("#photo_taggage").width();
	var heightPhoto = $("#photo_taggage").height();
	var widthPercent = parseInt(x/widthPhoto*100);
	var heightPercent =  parseInt(y/heightPhoto*100);
	
	if(id != ""){
		recordTag(photoId, widthPercent, heightPercent, id);
	}
}

function hideTagField(){
	isfieldTagOpen = false;
	$("#saisisTag").css({"visibility": "hidden"});
	$("#nouveauTage").css({"visibility": "hidden"});
	
	cleanTagField();
}


function taggage(top, left){
	$("#nouveauTage").css({"border": "4px solid black"});
	
	var leftPosition = left;
	var topPosition = top;
	
	var photoTop= $("#photo_taggage").offset().top;
	var photoLeft= $("#photo_taggage").offset().left;
	
	$("#input_tag_x").val(leftPosition-photoLeft);
	$("#input_tag_y").val(topPosition-photoTop);
	
	//mark position
	$("#nouveauTage").offset({top:top-(cadreSize/2), left: left-(cadreSize/2)});
	$("#nouveauTage").css({"visibility": "visible"});
	
	showTagField(leftPosition , topPosition);
}

function appendTag(id, displayName, x, y, path){
	var span = document.createElement ("span");
	span.className= "nom_tag";
	if(path == null){
		$(span).html(displayName+" - ");
	}else{
		var link = document.createElement ("a");
		$(link).attr("href", ctx+path);
		$(link).html(displayName+" - ");
		$(span).append(link)
	}

	$("#tags").append(span);
	
	
	
	var cadreTag = document.createElement ("div");
	cadreTag.className = "cadreTague cadreTague2";
	$(cadreTag).attr("title", displayName);
	var photoTop= $("#photo_taggage").offset().top;
	var postionTop =photoTop + (y* $("#photo_taggage").height() / 100)-(cadreSize/2);
	var photoLeft= $("#photo_taggage").offset().left;
	var postionLeft =photoLeft + (x* $("#photo_taggage").width() / 100)-(cadreSize/2);
	$(cadreTag).offset({top: postionTop, left: postionLeft});
	$(cadreTag).css({"position" : "absolute"});
	$("#tags").append(cadreTag);
	
	$(span).bind("mouseover", { cadre : cadreTag },function(event){
		$(event.data.cadre).css({"border-style" : "solid"});
	});
	$(span).bind("mouseout", { cadre : cadreTag },function(event){
		$(event.data.cadre).css({"border-style" : "none"});
	});
	
	
}
var items = [];
function fieldAutocomplete(){
	$.ajax ({
		url : ctx+"/ws/users",
		type :"get",
		success : function (response, textStatus, xhr)
		{
			var response = xhr.responseXML;
			
			// récupération des titres
			$(response).find ("item").each (function ()
			{
				var item = {
							id : $(this).find("id").text(),
							value:$(this).find("value").text(),
							type:$(this).find("type").text()
							};
				items.push (item);
			});
			createAutocomplete();
		
		},
		error : function (xhr, textStatus)
		{
		}

	});
}

function createAutocomplete(){
	
	//add the autocomplete 
	$("#input_tag_nom").autocomplete ({
		autoFocus: false,
		minLength: 0,
		source : items
		,
		open : function (event)
		{
			var ul = $(this).autocomplete ("widget");
			ul.css ("width", "250px");
		},
		focus: function( event, ui ) {
			$( "#input_tag_nom" ).val( ui.item.value );
			return false;
		},
		select: function( event, ui ) {
			$( "#input_tag_nom" ).val( ui.item.value );
			$( "#id_tag" ).val( ui.item.id );

			return false;
		}
	}).data( "autocomplete" )._renderItem = function( ul, item ) {
			var src="";
			if(item.type=="human"){
				src =ctx+"/images/personne.png";				
			}else if(item.type=="horse"){
				src= ctx+"/images/logo.png";
			}else{
				src="";
			}
				return $( "<li></li>" )
					.data( "item.autocomplete", item )
					.append( "<a><table><tr><td><img src="+src+" /></td><td>" + item.value + "</td></tr></table></a>" )
					.appendTo( ul );
			};
			
			$("#saisisTag").mouseover (function(){
				isMouseOnFieldTag  = true;
			});	
			$("#saisisTag").mouseout (function(){
				isMouseOnFieldTag  = false;
			});	
			$(".ui-autocomplete").mouseover (function(){
				isMouseOnFieldTag  = true;
			});	
			$(".ui-autocomplete").mouseout (function(){
				isMouseOnFieldTag  = false;
			});	
			
}

//add suggest list
$(document).ready(function(){
	
	if(isSaveTagOpenStared()){
		startTag();
	}
	
	while(loadedTag.length != 0){
		var tagInfos = loadedTag[0];
		loadedTag.shift();
		//add tag
		appendTag(tagInfos.id, tagInfos.display,tagInfos.x, tagInfos.y,tagInfos.path);
	}
	if($("#input_tag_nom").length!=0){
			
	
		$("body").click(function (){
			if(isfieldTagOpen && !isMouseOnFieldTag && !isOpenClick){
				hideTagField();
			}else if(isOpenClick){
				isOpenClick= false;			
			}
		});
		fieldAutocomplete();
		
		
		//add the tag field comportement
		$("#tagActivateButton").click(function(){
			if(tagging){
				stopTag();
			}else{
				startTag();
			}
		});	
		
		$("#input_tag_nom").keypress (function (event){
			 if(event.keyCode == 13){  
				 saveTag();
				 hideTagField();
			 }
		});

				
		$("#tag_valid").click(function (){
			saveTag();
			hideTagField();
		});
		
		$("#photo_taggage").click(function(e){
			if(tagging){
				taggage(e.pageY, e.pageX);
			}
		});
	}
});







