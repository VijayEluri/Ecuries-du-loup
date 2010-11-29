function convertirProfilBirthDate(){
	
	var avant = document.getElementById("birthDateFormat").value;
	
	var tabDate = avant.split("/");
	var date = new Date(tabDate[2], (tabDate[1]-1), tabDate[0]);
	document.getElementById("birthDate").value = date.getTime();
}