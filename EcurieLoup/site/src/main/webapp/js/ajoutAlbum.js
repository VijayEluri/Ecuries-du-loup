function addMessageConfirmToExitInUpload(){
	 window.onbeforeunload = confirmExit;
	  function confirmExit()
	  {
	    return 'Envoi de photo en cours. Changer de page provoquera l\'arret de l\'envoi.';
	  }
}

function removeMessageConfirmToExitInUpload(){
	 window.onbeforeunload = "";
	
}

function selectPossibleForm(){
	if(!window.File){
		document.getElementById("formulairePhotoSimple").className="ajout_album_parti_selected";
		document.getElementById("formulaireDaD").className="ajout_album_parti_non_selected";
	
	}
}

function getUrlParam(name){
	var result = null;

    // On enlève le ?
    param = window.location.search.slice(1,window.location.search.length);

    // On sépare le paramètres....
    // first[0] est de la forme param=valeur

    first = param.split("&");

    for(i=0;i<first.length;i++){
        second = first[i].split("=");
        if(second[0]==name){
        	result = second[1];
        }
    }
        
    return result;
	
}

function getSiteLocation(){
	return ctx;// window.location.split("albumPhoto")[0];
}

var iNbFiles = 0;
var XHR2Uploader = {
		aQueue :[], //contien la liste des objects File a envoyer
		oXHR : new XMLHttpRequest(),
		oCurrentFile:null,
		iCurrentIndex:0,
		iCurrentAdd:0,
		addNewFiles: function (aFiles){
			iNbFiles += aFiles.length;
			//on boucle sur la collection FileList pour récupéré le nom et la taille de chaque fichier
			for(var i = 0; i < aFiles.length; i++){
				var oFile = aFiles[i];
				//check is supported type
				if(oFile.type.match('image.*')||oFile.type.match('video.*')){
					//add traitement and displayed table
					XHR2Uploader.aQueue.push(oFile);
					XHR2Uploader.addHtmlElementToAdd(oFile);
					XHR2Uploader.iCurrentAdd++;
				}else{
					//add on table on error
					XHR2Uploader.addHtmlElementInError(oFile);
				}
			}
			//si la requete n'a jamais été lancé ou si la resquete précétence est terminer
			if((XHR2Uploader.oXHR.readyState ===0) ||(XHR2Uploader.oXHR.readyState ===4)){
				XHR2Uploader.startUpload();
			}
		},
		addHtmlElementToAdd:function(oFile){
			//ceci nous servira a identifier la ligne du fichier
			var currentName = XHR2Uploader.iCurrentAdd;

			//liste des fichier mis à jour dans l'interface
			var oLine = document.createElement('TR');
			oLine.innerHTML = '<td>'+oFile.name +'</td><td>'+oFile.size+' octets</td>';		
			
			
			var oTd = document.createElement('TD');
			oTd.id="tdprogress"+currentName;
			oTd.appendChild(XHR2Uploader.createProgress(oFile, currentName));
			oLine.appendChild(oTd);
			
			document.getElementById('list_files').appendChild(oLine);
		},
		createProgress:function(oFile, currentName){
			//affichage de la barre de progression
			var oProgress = document.createElement('PROGRESS');
			oProgress.id = 'progress'+currentName;
			oProgress.max = oFile.size;
			oProgress.value = 0;
			oProgress.innerHTML = '<img alt="wait" src="'+ctx+'/images/WaitImg.gif" title="Attente de la fin de l\'envoi d\'autres fichiers."/>';
			return oProgress;
		},

		addHtmlElementInError:function(oFile){
			var oLine = document.createElement('TR');
			oLine.innerHTML = '<td>'+oFile.name +'</td><td>'+oFile.size+' octets</td><td><img alt="ignore" src="'+ctx+'/images/non_droit.png" title="Format du fichier incorrect." /></td>';
			document.getElementById('list_files').appendChild(oLine);
		},

		startUpload:function(){
			//reste t ilqqc a envoyer?
			if(XHR2Uploader.aQueue.length <1){
				return;
			}
			addMessageConfirmToExitInUpload();
			var path = getSiteLocation();
			var album = getUrlParam("album");
			XHR2Uploader.oCurrentFile = XHR2Uploader.aQueue.shift();
			
			var currentFile = XHR2Uploader.oCurrentFile;
			if(currentFile.type.match('image.*')){
				XHR2Uploader.oXHR.open("POST", path+"/ws/albumPhoto/photo/"+album, true);
			}else if(currentFile.type.match('video.*')){
				XHR2Uploader.oXHR.open("POST", path+"/ws/albumPhoto/video/"+album, true);
			}
			
			//on construit l'équivalent du formulaire HTML
			var oFormData = new FormData();
			oFormData.append('file', currentFile);
			XHR2Uploader.oXHR.send(oFormData);		
		},
		onUploading:function(e){
			var oProgress = document.getElementById('progress'+XHR2Uploader.iCurrentIndex);
			oProgress.value = e.loaded;
			oProgress.innerHTML = Math.round(oProgress.value /oProgress.max * 100)+'%';
		}
		,
		onUploaded:function(e){
			if (XHR2Uploader.oXHR.readyState ==4){
				var oProgress = document.getElementById('tdprogress'+XHR2Uploader.iCurrentIndex);
				oProgress.value = XHR2Uploader.oCurrentFile.size;
				oProgress.innerHTML = '<img alt="finish" src="'+ctx+'/images/tick.png" title="Fichier envoyer."/>';

				XHR2Uploader.iCurrentIndex++;
				XHR2Uploader.startUpload();
				if(XHR2Uploader.aQueue.length <1){
					removeMessageConfirmToExitInUpload();
				}
			}
		}
		
};

if(XHR2Uploader.oXHR.upload){
	XHR2Uploader.oXHR.upload.onprogress = XHR2Uploader.onUploading;
}

XHR2Uploader.oXHR.onreadystatechange = XHR2Uploader.onUploaded;
