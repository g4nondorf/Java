var nbAlu = 13;
var liste = document.getElementsByTagName("ol")[0];
var tag = document.getElementsByTagName("ul")[0];
liste.innerHTML = "";

function tour(){
	var entier = parseInt(document.getElementById("soumettre").value);//récupere l'élément de l'ID "soumettre" et la passe en entier
	var nbMachine;
	
	//faire jouer l'humain
	if(entier<=0 || entier>3 || entier>nbAlu){
		alert("Valeur hors liste");
		return;
	}
	
	nbAlu -= entier;//met a jour la variables allumettes totale
	liste.innerHTML += "<li>Vous avez pris " + entier + " allumettes.</li>";//complete le suivi des coups
	
	if(nbAlu === 0){//verif PERDU
		tag.innerHTML = "";
		alert("T'a PERDU")
		return;
	}
	
	//faire jouer la machine
	var nbMachine = Math.ceil(Math.random()*Math.min(nbAlu,3))//nbre aléatoire entre 1 et 3
	nbAlu -= nbMachine;//met a jour la variables allumettes totale
	liste.innerHTML += "<li>L'ordinateur a pris " + nbMachine + " allumettes.</li>";//complete le suivi des coups
	
	if(nbAlu === 0){//verif PERDU
		tag.innerHTML = "";
		alert("L'ordinateur a PERDU")
		return;
	}
	
	tag.innerHTML = "";
	
	for(i =0; i<nbAlu; i++){
		tag.innerHTML +=  "<li>-alualu-</li>";//création de la nouvelle balise <ul></ul>
	}
}