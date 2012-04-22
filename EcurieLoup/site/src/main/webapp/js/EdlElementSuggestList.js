/**
*/

(function($) {
	var items =null;
	var inputId;
	var inputLabel;
	var optionsGlobal;
	
    $.fn.edlSuggest = function(param1) { 
    	if(typeof(param1) ==="object"){
	        var opts = $.extend({}, $.fn.edlSuggest.defaults, param1);
	        return this.each(function() {
		        optionsGlobal = opts;
	        	//this is the input to insert result (login or id)
	            inputId = $(this);
	            //create the element is visible : for display selected label
	            createDisplayedInput();
	            inputId.before(inputLabel);
	            createAutocomplete(opts);
	            if(opts.loadOnCreate){
	            	load(opts);
	            };
	            inputLabel.keypress (function (event){
					 if(event.keyCode == 13){  
						 opts.pressEnterCallBack();
					 }
	            });
	        });
    	}else if(typeof(param1) ==="string"){
    		if(param1=="clear"){
    			clear();
    		}else if(param1=="focus"){
    			focus();
    		}
    		else if(param1=="load"){
    			load(optionsGlobal);
    		}
    	}
    };

    $.fn.edlSuggest.defaults = {
    		horses: true,//get horses
    		humans: true, //get humans
    		loadOnCreate: true,
    		pressEnterCallBack : function(){}
    };

    var clear = function(){
    	inputId.val("");
    	inputLabel.val("");
    };
    var focus = function(){
    	inputLabel.focus();
    };
    var load = function(options){
    	 loadSuggest(options, function(){
         	insertLabel();
         });
    };
    var createDisplayedInput = function() {
    	var element = document.createElement("input");
    	$(element).attr("type", "text");
    	$(element).val(inputId.val());
    	inputLabel = $(element);
    };
    
    var insertLabel = function(){
    	var currentVal  = inputLabel.val();
    	$.each(items, function(index, value){
    		if(value.id == currentVal){
    			inputLabel.val(value.value);
    		}
    	});
    };
    
    var loadSuggest=  function (options, endLoadCallback){
    	if(items== null){
    		items = new Array();
	    	var url = "";
	    	if(options.horses){
	    		if(options.humans){
	    			url = ctx+"/ws/usershorses";
	    		}else{
	    			return;
	    		}
	    	}else{
	    		if(options.humans){
	    			url = ctx+"/ws/users";
	    		}else{
	    			return;
	    		}
	    	}
	    	
	    	$.ajax ({
	    		url : url,
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

	    			endLoadCallback();    		
	    		},
	    		error : function (xhr, textStatus)
	    		{
	    			alert("error");
	    		}
	    	});
    	
    	}
    };
    
    var listOfSearch = function (search){
	   var selectedValue = $.grep(items, function(value, index){
		   var searchComparable = search.toLowerCase();
		   var idComparable = value.id.toLowerCase();
		   var labelComparable = value.value.toLowerCase();
		   
		   if((idComparable.indexOf(searchComparable) !=-1) 
			   ||
			   (labelComparable.indexOf(searchComparable) !=-1)){
			   return true;
		   }else{
			   return false;
		   }
	   });
	   return selectedValue;
    };
    var createAutocomplete =  function (options){
    	
    	//add the autocomplete 
    	inputLabel.autocomplete ({
    		autoFocus: false,
    		minLength: 0,
    		source : function(request, callback){
    			var searchTerm =  request.term;
    			if(items == null){
    				loadSuggest(options, function(){
    					insertLabel(resultInput);
    					if(searchTerm==""){
        					callback(items);
        				}else{
        					callback(listOfSearch(searchTerm));
        				}  					
    				});
    			}else{
    				if(searchTerm==""){
    					callback(items);
    				}else{
    					callback(listOfSearch(searchTerm));
    				}
    			}
    		},
    		open : function (event) {
    			var ul = $(this).autocomplete ("widget");
    			ul.css ("width", "250px");
    		},
    		focus: function( event, ui ) {
    			inputLabel.val( ui.item.value );
    			return false;
    		},
    		select: function( event, ui ) {
    			inputLabel.val( ui.item.value );
    			inputId.val( ui.item.id );

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
    			
    };
})(jQuery);