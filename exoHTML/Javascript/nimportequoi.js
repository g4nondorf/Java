function hello(nom, prenom){
	var texte = "hello " + nom + " " + prenom;
	console.log(texte);
}

hello("Nom", "Prenom");

if (3<2){
	console.log("!!!")
}
else{
	console.log("ok")
}

for(var i=5; i<21; i++){
	console.log(i*i*i);
	if(i===10){
		break;
	}
}

var x = [45,1,876,3,67,567];

for(var i=0; i<x.length; i++){
	console.log(x[i]);
}