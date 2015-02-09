var stack = [];
var valeur_courante = "";

//Number => (=>)
function cliquer_chiffre(numero){
	return function(){
		valeur_courante += numero;
		document.getElementById("invite").innerHTML = valeur_courante;
	}
}

//Nettoyer la pile
function clear(){
	stack = [];
	valeur_courante = "";
	rafraichir_ecran();
}

//Ecrire stack dans #pile
function rafraichir_ecran(){
	var liste_pile = document.getElementById("pile");
	liste_pile.innerHTML = "";
	for(var i=0; i<stack.length; i++){
		liste_pile.innerHTML += "<li>" + stack[i] +"</li>";
	}
}

//Mettre valeur_courante sur la pile
function push(){
	stack.push(parseInt(valeur_courante));
	rafraichir_ecran();
	valeur_courante = "";
	document.getElementById("invite").innerHTML = valeur_courante;
}

//Appelle quand operateur cliqué
function effectuer_operation(){

}

window.onload = function(){
	var boutons_chiffre = document.getElementsByClassName("nombre");
	for(var i=0; i<boutons_chiffre.length; i++){
		boutons_chiffre[i].onclick = cliquer_chiffre(boutons_chiffre[i].innerText);
	}
	
	var boutons_operateurs = document.getElementsByClassName("operateur");
	for(var j=0; j<boutons_operateurs.length; j++){
		boutons_operateurs[j].onclick = effectuer_operation;
	}
	
	document.getElementById("push").onclick = push;
	document.getElementById("clear").onclick = clear;
}