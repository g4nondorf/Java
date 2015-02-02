var nbAlu = 13;

function tour(){
	var entier = parseInt(document.getElementById("soumettre").value);
	var rdg;
	
	if(entier<=0 || entier>3 || entier>nbAlu){
		alert("Valeur hors liste");
		return;
	}else{
		nbAlu = nbAlu - entier;
	}
	if(nbAlu === 0){//verif PERDU
		alert("T'a PERDU")
		return;
	}
	var rdg = Math.ceil(Math.random()*Math.min(nbAlu,3))
	nbAlu = nbAlu - rdg;
	
	if(nbAlu === 0){//verif gagner
		alert("L'ordinateur a PERDU")
		return;
	}
	var tag = document.getElementsByTagName("ul")[0];
	tag.innerHTML = "";
			
	for(i =0; i<nbAlu; i++){
		tag.innerHTML +=  "<li>-alualu-</li>";
	}
}