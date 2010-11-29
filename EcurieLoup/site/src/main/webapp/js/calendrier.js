function convertir(){
	
	var avant = document.getElementById("dateTypeEvenement").value;
	
	var tabDate = avant.split("/");
	var date = new Date(tabDate[2], (tabDate[1]-1), tabDate[0]);
	document.getElementById("dateTypeEvenementInTimestamp").value = date.getTime();
}