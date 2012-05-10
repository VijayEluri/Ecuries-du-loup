(function($) {
	var options =null;
	var album = null;
	var currentMedia = null;
	var currentMediaIndex = null;
	var element = null;
	$.fn.mediaDisplayer = function(param1) { 
		options = $.extend({}, $.fn.mediaDisplayer.defaults, param1);
		return this.each(function() {

			element = this;
			//load current album
			loadAlbum(function(){
				//select current index on album
				selectCurrentMediaWithBeginId();
				constructCurrentMedia(element);
			});

		});
	};

	$.fn.mediaDisplayer.defaults = {
			album: 0,
			beginMedia: 0,
			tag: ""
	};


	//load album with id get in option
	//return void
	var loadAlbum=  function (callbackSucess){
		var url;
		if(options.album != 0){
			url =  ctx+"/ws/albumPhoto/"+options.album;  	
		}else if(options.tag !=""){
			url =  ctx+"/ws/albumPhoto/photos/"+options.tag;  
		}
		$.ajax({
			url: url, 		  
			dataType: "json"

		}).done(function( json ) {
			album = json;
			callbackSucess();
		});
	};

	//Select current media with her id get in option
	//return : void	
	var selectCurrentMediaWithBeginId= function(){
		$.each( album.media.medias, function(index, value){
			if(value.id == options.beginMedia){
				currentMedia= value;
				currentMediaIndex = index;
			}
		});
	};
	
	var constructCurrentMedia = function(){
		//change main image
		createMainMedia();
		
		$("#navigation_album").empty();
		//change previous image
		$("#navigation_album").append(createBrowseMedia("photo_precedente", -1));
		//change next image				
		$("#navigation_album").append(createBrowseMedia("photo_suivante", +1));
		//change description
		$("#descriptionTextarea").val(currentMedia.description);
		$("#descriptionP").html(currentMedia.description);
		//change tag
		$("#tagsList" ).mediatag({mediaId:  currentMedia.id});
		//change comment
		$( "#comments" ).comments({mediaId : currentMedia.id});
		//change like button
		$("#facebookIframe").attr("src", "http://www.facebook.com/plugins/like.php?href=http%3A%2F%2F"+host+ctx+"%2Ffacebook%2FalbumPhoto%2FaffichagePhoto.do%idPhoto%3D"+currentMedia.id+"&amp;layout=standard&amp;show_faces=true&amp;width=450&amp;action=like&amp;font=arial&amp;colorscheme=light&amp;height=80");
		//change url
		try{
		var urlHistory = "";
		if(options.album != 0){
			urlHistory = "affichagePhoto.do?mediaId="+ currentMedia.id+"&albumId="+options.album;
		}else if(options.tag !=""){
			urlHistory = "affichagePhoto.do?mediaId="+ currentMedia.id+"&searchtag="+options.tag;
		}
		history.pushState(currentMedia, "photo "+currentMedia.id, urlHistory);
		}catch (e) {
		}
		//change title
		$(".mediaId").text(currentMedia.id);
		//change navigation
		$("#browneAlbum").text(album.media.name);
		$("#browneAlbum").attr("href", ctx+"/albumPhoto/affichage.do?idAlbum="+album.media.id);
		//change option button
		$("#downloadButton").attr("href", ctx+"/albumPhoto/download.do?idMedia="+currentMedia.id);
		$("#deleteButton").attr("href", ctx+"/albumPhoto/affichage.do?idAlbum="+album.media.id+"&deletePhoto="+currentMedia.id);
		
		//change addeur	
		$("#poster").text(currentMedia.poster);
		
	};
	//define main media
	var createMainMedia = function(){
		$(element).empty();
		if(currentMedia.type == "0"){
			$(element).append(createImageMainMedia());
		}else if(currentMedia.type == "1"){
			$(element).append(createVideoMainMedia());
		}else{
			alert("error media type");
		}
	};
	//create element is image
	var createImageMainMedia = function(){
		var image =  document.createElement("img");
		$(image).attr("id", "photo_taggage");
		$(image).attr("src", ctx+"/images/albumPhoto/view/"+currentMedia.id);
		$(image).attr("alt", currentMedia.id);
		return image;
	};
	//create element is media
	var createVideoMainMedia = function(){
		var video =  document.createElement("video");
		$(video).attr("class", "video_balise");
		$(video).attr("controls", "controls");
		$(video).text("Votre navigateur ne gère pas la balise vidéo. Veuillez mettre à jour votre navigateurs.");
		
		
		$(video).append(createVideoSource("mp4", "video/mp4"));
		$(video).append(createVideoSource("webm", "video/webm"));
		$(video).append(createVideoSource("ogv", "video/ogg"));
		
		return video;
	};
	//create source element
	var createVideoSource= function(extention, type){
		var source =  document.createElement("source");
		$(source).attr("src", ctx+"/images/albumPhoto/"+currentMedia.id+"."+extention);
		$(source).attr("type", type);
		return source;
	};
	
	var createBrowseMedia = function(classId, delta){
		//if no next 
		var nextMediaIndex = currentMediaIndex + delta;
		if((nextMediaIndex < 0) || (nextMediaIndex >= album.media.medias.length)){
			return null;
		}
		var photoVideoDiv =  document.createElement("div");
		 $(photoVideoDiv).attr("id", classId);
		 $(photoVideoDiv).attr("class", classId);
		 
		 var div =  document.createElement("div");
		 $(div).attr("class", "photo video");
		 
		if(album.media.medias[nextMediaIndex].type==1){
			var videoDiv =  document.createElement("div");
			 $(videoDiv).attr("class", "image_video");
			 $(div).append(videoDiv);
		}
		
		var previewImage =  document.createElement("img");
		 $(previewImage).attr("src", ctx+"/images/albumPhoto/miniatures/"+album.media.medias[nextMediaIndex].id);
		 $(previewImage).attr("alt", album.media.medias[nextMediaIndex].id);
		 $(previewImage).attr("title", album.media.medias[nextMediaIndex].id);
		 
		 $(div).append(previewImage);
		 $(photoVideoDiv).append(div);
		 
		 $(photoVideoDiv).click(function(){
				currentMediaIndex += delta;
				currentMedia= album.media.medias[currentMediaIndex];
				constructCurrentMedia();
		 });
		return photoVideoDiv;
	};
})(jQuery);