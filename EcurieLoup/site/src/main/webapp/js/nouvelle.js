
function confirmerSuppresionNews(prepath, direction){
	if (confirm("Etes vous sur de vouloir supprimer cette nouvelle?" )){
		alert(prepath+"/news/affichageNews.do?deleteNouvelle="+ direction);
	}
}