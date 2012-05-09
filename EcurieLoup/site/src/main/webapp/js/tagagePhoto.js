
(function($) {
	var tagging = false;
	var cadreSize = 100;
	var isfieldTagOpen = false;
	var isMouseOnFieldTag = false;
	var isOpenClick = false;
	var options;
	var element;
	var loadRequest;

	$.fn.tagAppender = function() { 

		createTagButton($(this));
		$("#tag_valid").click(function (){
			saveTag();
			hideTagField();
		});
		$("#photo_taggage").live("click", function(e){
			if(tagging){
				taggage(e.pageY, e.pageX);
			}
		});
		$("#photo_taggage").live("hover", function(e){

			tagActivate();
		});

		var options ={
				horses: true,//get horses
				humans: true, //get humans
				loadOnCreate : false,
				pressEnterCallBack : function (){
					saveTag();
					hideTagField();
				}
		};
		$("#id_tag").edlSuggest(options);

		$("body").click(function (){
			if(isfieldTagOpen && !isMouseOnFieldTag && !isOpenClick){
				hideTagField();
			}else if(isOpenClick){
				isOpenClick= false;			
			}
		});



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
	};

	var createTagButton= function(adderElement){
		var tagButton = document.createElement("img");
		$(tagButton).attr("id", "tagActivateButton");
		//add the tag field comportement
		$(tagButton).click(function(){
			if(tagging){
				stopTag();
			}else{
				startTag();
			}
		});	
		adderElement.prepend( tagButton);
		offTagButton();
	};

	$.fn.mediatag = function(param1) { 
		if(loadRequest != null){
			loadRequest.abort();
		}
		options = $.extend({}, $.fn.mediatag.defaults, param1);
		return this.each(function() {
			element = $(this);
			element.empty();
			createLoading();

			//add tags of media
			loadMediaTags();
			//add element to adding tags


		});
	};

	$.fn.mediatag.defaults = {
			mediaId: 0
	};


	var createLoading = function() {
		var div = document.createElement("div");
		div.className="loadingDiv";
		$(div).append("<img class='loading mini' src='"+ctx+"/images/WaitImg.gif' alt='loading' />");
		$(element).append(div);
	};
	var loadMediaTags = function(){
		var url = ctx+"/ws/albumPhoto/tag/"+options.mediaId+"/tags";
		loadRequest = $.ajax({
			url: url, 		  
			dataType: "json"

		}).done(function( json ) {
			$(element).empty();
			var list = json.tags;
			$.each( list, function(index, value){
				appendTag(value);

			});
		});
	};

	var appendTag = function (tag){
		var span = document.createElement ("span");
		span.className= "nom_tag";
		if(tag.path == null){
			$(span).html(tag.display+" - ");
		}else{
			var link = document.createElement ("a");
			$(link).attr("href", ctx+tag.path);
			$(link).html(tag.display+" - ");
			$(span).append(link);
		}

		$(element).append(span);

		var cadreTag = document.createElement ("div");
		cadreTag.className = "cadreTague cadreTague2";
		$(cadreTag).attr("title", tag.display);
		var photoTop= $("#photo_taggage").offset().top;
		var postionTop =photoTop + (tag.y* $("#photo_taggage").height() / 100)-(cadreSize/2);
		var photoLeft= $("#photo_taggage").offset().left;
		var postionLeft =photoLeft + (tag.x* $("#photo_taggage").width() / 100)-(cadreSize/2);
		$(cadreTag).offset({top: postionTop, left: postionLeft});
		$(cadreTag).css({"position" : "absolute"});
		element.append(cadreTag);

		$(span).bind("mouseover", { cadre : cadreTag },function(event){
			$(event.data.cadre).css({"border-style" : "solid"});
		});
		$(span).bind("mouseout", { cadre : cadreTag },function(event){
			$(event.data.cadre).css({"border-style" : "none"});
		});
	};


	var startTag = function(){
		tagging =true;
		tagActivate();
		onTagButton();
		$("#id_tag").edlSuggest("load");
	};
	var tagActivate = function(){
		if(tagging){
			$("#nouveauTage").css({"cursor": "crosshair"});
			$("#photo_taggage").css({"cursor": "crosshair"});
		}
	};

	var stopTag = function(){
		tagging = false;
		hideTagField();
		$("#nouveauTage").css({"cursor": "default"});
		$("#photo_taggage").css({"cursor": "default"});
		offTagButton();
	};

	var offTagButton= function(){
		var tagButton = $("#tagActivateButton");
		tagButton.attr("src", ctx+"/images/tag.jpeg");
		tagButton.attr("alt", "commencer tag");
		tagButton.attr("title", "Activer le taggage");
	};
	var onTagButton= function(){
		var tagButton = $("#tagActivateButton");
		tagButton.attr("title", "Stopper le taggage");
		tagButton.attr("src", ctx+"/images/tag_actif.jpeg");
		tagButton.attr("alt", "stoper tag");
	};

	var cleanTagField = function (){
		$("#id_tag").edlSuggest("clear");
		$("input_tag_x").val("");
		$("input_tag_y").val("");
	};

	var showTagField = function (x, y){	
		isOpenClick= true;
		x += 30;
		y += 30;

		$("#saisisTag").offset({ top : y, left : x });
		$("#saisisTag").css({"visibility": "visible"});


		$("#id_tag").edlSuggest("focus");
		isfieldTagOpen = true;
	};

	var recordTag = function (mediaId, x, y, name){

		var position = {x:x, y:y};
		$.ajax ({
			url : ctx+"/ws/albumPhoto/tag/"+mediaId+"/"+name,
			data: position, 
			context : position,
			type :"post",
			success : function (response, textStatus, xhr)
			{
				var id = $( xhr.responseXML).find("value").text();
				var tag = {
						name : name,
						display : name,
						path : null,
						x : x,
						y : y

				};
				appendTag(tag);
			},
			error : function (xhr, textStatus)
			{
				alert("error");
			}

		});
	};


	var saveTag = function (){
		var id = $("#id_tag").val();
		var x = $("#input_tag_x").val();
		var y = $("#input_tag_y").val();

		var widthPhoto = $("#photo_taggage").width();
		var heightPhoto = $("#photo_taggage").height();
		var widthPercent = parseInt(x/widthPhoto*100);
		var heightPercent =  parseInt(y/heightPhoto*100);

		if(id != ""){
			recordTag(options.mediaId, widthPercent, heightPercent, id);
		}
	};
	var hideTagField = function (){
		isfieldTagOpen = false;
		$("#saisisTag").css({"visibility": "hidden"});
		$("#nouveauTage").css({"visibility": "hidden"});

		cleanTagField();
	};
	var taggage = function (top, left){
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
	};


})(jQuery);