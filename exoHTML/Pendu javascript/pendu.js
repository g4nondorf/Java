var tab = [];
var mot = '';
var motSecret = '';

function initRep()
{
	for (var i = 0 ; i < motSecret.length ; i++) {
		tab.push('*');
		mot = mot + tab[i];
	}
}

var game = 1;
var compte =0;
var savoir = 0;
var test = 0;

function verifDouble(lettre1){
	do{
		for(var i = 0 ; i < mot.length ; i++)
		{
			if(mot.charAt(i) == lettre1)
			{
				test = 1;
			}else{
				test = 0;
				alert(mot.charAt(i));
			}
		}
		
		if(test == 1)
		{
			var lettre = prompt("Vous avez déja regarder cette lettre. Il vous reste " + nbreEss + " essais\n Le mot a trouver : " + mot)
		}
	}while(test == 1);
	
}

function chekChar(car)
{
	savoir = 0;
	for (var i = 0 ; i < motSecret.length ; i++) {
		if (motSecret.charAt(i) == car )
		{
			savoir = 1;
			tab[i] = motSecret.charAt(i) ;
			compte++;
		}else if (mot.charAt(i) != '*'){
			tab[i] = mot.charAt(i);
		}else{
			tab[i] = '*';
		}
	}
	mot	= ""
}

do{
	var motSecret = prompt("Rentrer le mot a chercher") ;
	var nbreEss = 7;
	initRep();
	var lettre = prompt("Quelle lettre voulez vous tester il vous reste " + nbreEss + " essais\n Le mot a trouver : " + mot);
	chekChar(lettre);
	
	while(nbreEss != 0){
		
		for (var i = 0 ; i < motSecret.length ; i++) {
			mot = mot + tab[i];
		}
		
		if(savoir == 1)
		{
			verifDouble(lettre = prompt("Bravo!!\nMaintenant quelle lettre voulez vous tester il vous reste " + nbreEss + " essais\n Le mot a trouver : " + mot));
		}else if(savoir == 0){
			nbreEss--;
			if(nbreEss == 0)
			{
				alert("perdu");
				break;
			}
			lettre = prompt("Raté\nMaintenant quelle lettre voulez vous tester il vous reste " + nbreEss + " essais\n Le mot a trouver : " + mot)
			verifDouble(lettre);
		}else{
			alert("il y a un probléme");
		}
		
		chekChar(lettre);
	}
	
	var t = 1;
	do{
		var play = prompt("Voulez-vous rejouer ?(o/n)");
		if(play=='o'||play=='O')
		{
			game = 1;
			t = 0;
		}else if(play=='n'||play=='N'){
			game = 0;
			t = 0;
		}else{
			alert("Veuillez donner une réponse correcte")
		}
	}while(t!=0);
	
}while(game == 1);
