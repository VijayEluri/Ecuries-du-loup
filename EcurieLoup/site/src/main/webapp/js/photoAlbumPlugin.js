/**
*/

(function($) {


    $.fn.photosAlbum = function(options) {
        
        var opts = $.extend({}, $.fn.photosAlbum.defaults, options);
        return this.each(function() {
            var $this = $(this);
            addPhotosAlbum($this, opts);
        });
    };

    /**
* Store default options
* @type {object}
*/
    $.fn.photosAlbum.defaults = {
        tag: null //filtre on tagged personn or horse
    };

    var addPhotosAlbum = function(element, options) {
    	createLoading(element);
    	var url = ctx+"/ws/albumPhoto/photos/"+options.tag;
		$.ajax({
			  url: url, 		  
			  dataType: "xml"
		
		}).done(function( xml ) {
			parseXml(element, xml, options.tag);
			
		});
    };

    var createLoading = function(element) {
    	$(element).append("<img class='loading' src='"+ctx+"/images/WaitImg.gif' alt='loading' />");
    };
    var parseXml = function(element, xml, tag) {
    	$(element).empty();
    	$(xml).find('media').each( function(){
    		var id = $(this).find('id').text();
    		var description = $(this).find('description').text();
    		var datePostage = $(this).find('datePostage').text();
    		var type = $(this).find('type').text();
    		appendPhoto(element, {id: id, description: description, datePostage : datePostage, type : type}, tag);
		});
    };
    
    var appendPhoto = function(element, photo, tag) {
    	var html = "<a href='"+ctx+"/albumPhoto/affichagePhoto.do?mediaId="+photo.id+"&searchtag="+tag+"'>";
    	html+="<div class='photo video'><img alt='photo "+photo.id+"' src='"+ctx+"/images/albumPhoto/miniatures/"+photo.id+"'>";
    	html+="</div>";
    	html+="</a>";
    	$(element).append(html);
    };

 

})(jQuery);