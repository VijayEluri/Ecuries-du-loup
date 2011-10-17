<div id="drop-area" class="drop-zone">
	Posez vos photos ici!
</div>

<table id="list_files">
	<tr>
		<th>Fichier</th>
		<th>Taille</th>
		<th>Status</th>
	</tr>
</table>

<script>

document.getElementById("drop-area").ondragover = function(e){

 	if (e.preventDefault) e.preventDefault(); // allows us to drop

    e.dataTransfer.dropEffect = 'move';

 	if(e.dataTransfer.effectAllowed)e.dataTransfer.effectAllowed = 'move';
	e.stopPropagation();
	
	return false;
}
document.getElementById("drop-area").ondrop = function(e){
	 if (e.stopPropagation) e.stopPropagation(); // stops the browser from redirecting...why???

	if('files' in e.dataTransfer){
		XHR2Uploader.addNewFiles(e.dataTransfer.files);
	}else{
		document.getElementById("drop-area").innerHTML = "Navigateur incapable";
	}

	document.getElementById("drop-area").className='drop-zone';
	 return false;
}

document.body.ondragover = function(e){

 	if (e.preventDefault) e.preventDefault(); // allows us to drop

	e.stopPropagation();
	e.dataTransfer.dropEffect = 'none';

 	if(e.dataTransfer.effectAllowed)e.dataTransfer.effectAllowed = 'none';
	
	
	return false;
}

document.getElementById("drop-area").ondragenter = function(e){
	document.getElementById("drop-area").className='drop-zone dragEnter';
}

document.getElementById("drop-area").ondragleave = function(e){
	document.getElementById("drop-area").className='drop-zone';
}

document.body.ondrop = function(e){

 	if (e.preventDefault) e.preventDefault(); // allows us to drop

	e.stopPropagation();
	
	return false;
}
</script>