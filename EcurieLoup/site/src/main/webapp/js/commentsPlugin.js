/**
*/

(function($) {

	var loadRequest;
    $.fn.comments = function(options) {        
        var opts = $.extend({}, $.fn.comments.defaults, options);
        return this.each(function() {
            var $this = $(this);
            $this.empty();
        	if(loadRequest != null){
    			loadRequest.abort();
    		}
            addComments($this, opts);
        });
    };

    $.fn.comments.defaults = {
    		mediaId: null //id of media of comment
    };

    var addComments = function(rootElement, options) {
    	createPart(rootElement);
    	createLoading(rootElement);
    	createCommentSeize(rootElement, options.mediaId);
    	loadComments(rootElement, options);
    };
    
    var loadComments = function(rootElement, options) {
    	var url = ctx+"/ws/albumPhoto/"+options.mediaId+"/comments/";
    	loadRequest = $.ajax({
			  url: url, 		  
			  dataType: "json"
		
		}).done(function( json ) {
			createComments(rootElement, json);
			
		});
    };

    
    var createPart = function(rootElement) {
    	$(rootElement).append("<div id='view'></div>");
    	$(rootElement).append("<div id='seize'></div>");
    };
    
    var createLoading = function(rootElement) {
    	var div = document.createElement("div");
    	div.className="loadingDiv";
    	$(div).append("<img class='loading' src='"+ctx+"/images/WaitImg.gif' alt='loading' />");
    	$('#view', rootElement).append(div);
    };
    
    var createCommentSeize = function(rootElement, mediaId) {
    	var textarea = document.createElement("textarea"); 
    	$(textarea).attr('placeholder', 'Ecrivez votre commentaire');
    	$(textarea).keypress(function(event) {
    		 if ( !event.shiftKey && event.which == 13 ) {
    		     event.preventDefault();
    		     $(textarea).attr("disabled", true);
    		     var content = $(this).val();
    		     sendContent(mediaId, content, rootElement, function(){
    		    	 $(textarea).attr("disabled", false);
    		    	 $(textarea).val("");
    		     });
    		   }

    		});
    	$('#seize', rootElement).append(textarea);
    };
    
    var sendContent = function(photoId, comment, rootElement, atEndCallBack){
    	var url = ctx+"/ws/albumPhoto/"+photoId+"/comments/";
		$.ajax({
			  url: url, 
			  data: "content="+comment,
			  type: "POST",
			  dataType: "json"
		
		}).done(function( json ) {	
	    	atEndCallBack();	
	    	appendComment(rootElement, json.comment);		
		});
    };
   
    var createComments = function(rootElement, list) {
    	$('#view', rootElement).empty();
    	$.each(list.comments, function(index, value){ 
    		appendComment(rootElement, value);
		});
    };
    
    var appendComment = function(rootElement, comment) {
    	var html = "<div class='commentaire'>";
		html+="<div class='body'><span class='login'>"+comment.posterLogin+"</span> "+comment.content+"</div>";
		html+="<div class='date'>"+new Date(comment.date).toLocaleString()+"</div>";
		html+="</div>";
    	
		$('#view', rootElement).append(html);
    };

 

})(jQuery);