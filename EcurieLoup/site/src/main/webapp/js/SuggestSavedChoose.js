/**
 */

(function($) {
	var items =null;
	var inputId;
	var inputLabel;

	$.fn.suggestSavedChoose = function(param1) { 
		var opts = $.extend({}, $.fn.edlSuggest.suggestSavedChoose, param1);
		return this.each(function() {

			//this is the input to insert result (login or id)
			inputId = $(this);
			//create the element is visible : for display selected label
			createDisplayedInput();
			inputId.before(inputLabel);

			//load displayed data
			loadSuggest(function(){
				var selectedItem = getItemById(inputId.val());
				if(selectedItem != null){
					inputLabel.val(selectedItem.value);
				}
			});
			
			createAutocomplete(opts);	
			$("a", ".ui-autocomplete").live("keydown", function(event) {
				//key press is suppr
				if(event.which==46)
				{
					var item = getExactItem($(event.currentTarget).text());
					if(item!=null){
						$(event.currentTarget).remove();
						deleteCategory(item.id, function(){
							
						});
					}
					
				}
				
			});

		});
	};

	$.fn.suggestSavedChoose.defaults = {
	};

	var loadSuggest=  function (callback){
		if(items== null){
			items = new Array();
			var url =  ctx+"/ws/horsecard/categorys";   	

			$.ajax ({
				url : url,
				type :"get",
				success : function (response, textStatus, xhr)
				{
					var response = xhr.responseXML;
					// récupération des titres
					$(response).find ("Category").each (function (){

						var item = {
								id : $(this).find("id").text(),
								value:$(this).find("name").text()
						};
						items.push (item);
					});	
					callback();
				},
				error : function (xhr, textStatus)
				{
					alert("error");
				}
			});

		}
	};

	var createNewCategory=  function (name, callbackSucess){
		var url =  ctx+"/ws/horsecard/categorys/"+name;   	

		$.ajax ({
			url : url,
			type :"post",
			success : function (response, textStatus, xhr)
			{
				var category = null;
				var response = xhr.responseXML;
				// récupération des titres
				$(response).find ("Category").each (function (){

					category = {
							id : $(this).find("id").text(),
							value:$(this).find("name").text()
					};
				});		
				callbackSucess(category);
			},
			error : function (xhr, textStatus)
			{
				alert("error");
			}
		});
	};
	var deleteCategory=  function (id, callbackSucess){
		var url =  ctx+"/ws/horsecard/categorys/"+id;   	

		$.ajax ({
			url : url,
			type :"delete",
			success : function (response, textStatus, xhr)
			{
				callbackSucess(category);
			},
			error : function (xhr, textStatus)
			{
				alert("error");
			}
		});
	};

	var createDisplayedInput = function() {
		var element = document.createElement("input");
		$(element).attr("type", "text");
		inputLabel = $(element);
	};



	var listOfSearch = function (search){
		var selectedValue = $.grep(items, function(value, index){
			var searchComparable = search.toLowerCase();
			var labelComparable = value.value.toLowerCase();

			if(labelComparable.indexOf(searchComparable) !=-1){
				return true;
			}else{
				return false;
			}
		});
		return selectedValue;
	};
	
	var getExactItem= function(search){
		var item = null;
		for(var i = 0; i < items.length; i++){
			if(items[i].value  == search){
				item = items[i];
			}
		}
		return item;
	}
	var getItemById= function(id){
		var item = null;
		for(var i = 0; i < items.length; i++){
			if(items[i].id  == id){
				item = items[i];
			}
		}
		return item;
	}

	var createAutocomplete =  function (options){

		//add the autocomplete 
		inputLabel.autocomplete ({
			autoFocus: false,
			minLength: 0,

			source : function(request, callback){
				var searchTerm =  request.term;

				if(searchTerm==""){
					callback(items);
				}else{
					callback(listOfSearch(searchTerm));
				}
			},
			//define fixed width for suggest
			open : function (event) {
				var ul = $(this).autocomplete ("widget");
				ul.css ("width", "250px");
			},
			//fill hidden field on select
			select: function( event, ui ) {
				inputLabel.val( ui.item.value );
				inputId.val( ui.item.id );

				return false;
			},
			change: function(event, ui) { 
				//item is not select
				if(ui.item ==null){
					var item = getExactItem(this.value);
					//if one proposation
				
					if(item!= null){					  
						inputLabel.val( item.value );
						inputId.val( item.id );
					}else{
						createNewCategory(this.value, function(category){
							inputLabel.val( category.value );
							inputId.val( category.id );
							items.push (category);
						});
					}			 
				}
			}
		}).data( "autocomplete" )._renderItem = function( ul, item ) {

			return $( "<li></li>" )
			.data( "item.autocomplete", item )
			.append( "<a>" + item.value + "</a>" )
			.appendTo( ul );
		};

	};

})(jQuery);