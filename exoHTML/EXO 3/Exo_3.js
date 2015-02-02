var game = 1;
while(game==1){
	var essai = prompt("Choisissez le nombre d'essais :");
	var rdg = Math.ceil(Math.random()*10);
	var tent = 1;
	var tab =[];
	while(essai>0){
		var test = prompt("Tentative n°"+tent);
		if(essai!=1){
			if(test<rdg&&test>=0){
				tab.push(test);
				alert("Trop petit");
				essai--;
				tent++;
			}else if(test>rdg&&test<=10){
				tab.push(test);
				alert("Trop grand");
				essai--;
				tent++;
			}else if(test==rdg){
				tab.push(test);
				alert("Gagné !!\nNombre d'essais: "+tent+"\nNombres joués: "+tab.join(" ; "))
				essai = 0;
			}else{
			alert("Veuillez taper un nombre entre 1 et 10!!");
			}
		}else if(essai==1){
			if(test<rdg&&test>=0){
				tab.push(test);
				alert("Perdu !!\nNombre d'essais: "+tent+"\nNombres joués: "+tab.join(" ; "))
				essai--;
			}else if(test>rdg&&test<=10){
				tab.push(test);
				alert("Perdu !!\nNombre d'essais: "+tent+"\nNombres joués: "+tab.join(" ; "))
				essai--;
			}else if(test==rdg){
				tab.push(test);
				alert("Gagné !!\nNombre d'essais: "+tent+"\nNombres joués: "+tab.join(" ; "))
				essai = 0;
			}else{
				alert("Veuillez taper un nombre entre 1 et 10!!");
			}
		}
	}
	var t = 1;
	while(t!=0){
		var play = prompt("Voulez-vous rejouer ?(o/n)");
		if(play=='o'||play=='O'){
			game = 1;
			t = 0;
		}else if(play=='n'||play=='N'){
			game = 0;
			t = 0;
		}else{
			alert("Veuillez donner une réponse correcte")
		}
	}
}