var running;

//nombre, nombre -> [[]]
function create_matrix(nb_lines, nb_columns){
	var result = [];
	
	for(var i=0; i<nb_lines; i++){
		var columns = [];
		for(var j=0; j<nb_columns; j++){
			columns[j] = 0;
		}
		result[i] = columns;
	}
	
	return result;
}

function cell_click(){
	this.classList.toggle("full");
}

window.onload = function(){
	// Assigner un callback aux cellules lors du click
	var cellules = document.getElementsByTagName("td");
	
	for(var i=0; i<cellules.length; i++){
		cellules[i].onclick = cell_click;
	}
	
	document.getElementById("next").onclick=step;
	document.getElementById("play").onclick=play;
	document.getElementById("stop").onclick=stop;
}

function play(){
	running = window.setInterval(step, 500);
}

function stop(){
	window.clearInterval(running);
}

function step(){
	var world = document.getElementById("plateau");
	
	var current_state = create_matrix(world.rows.length, world.rows[0].cells.length);
	var next_state = create_matrix(world.rows.length, world.rows[0].cells.length);
	
	for(var i=0; i<world.rows.length; i++){
		for(var j=0; j<world.rows[i].cells.length; j++){
			if(world.rows[i].cells[j].classList.contains("full"))
				current_state[i][j] = 1;
		}
	}
	
	for(var i=0; i<next_state.length; i++){
		for(var j=0; j<next_state[i].length; j++){
			var neighbours = neighbours_count(current_state, i, j);
			//Verification cellule vivante
			if((current_state[i][j] === 1 && (neighbours === 2 || neighbours === 3)) || (current_state[i][j] === 0 && neighbours === 3)){//Cellule vivante
						next_state[i][j] = 1;
			}
		}
	}
	
	for(var i=0; i<world.rows.length; i++){
		for(var j=0; j<world.rows[i].cells.length; j++){
			if(next_state[i][j] == 1){
				world.rows[i].cells[j].classList.add("full");
			}else{
				world.rows[i].cells[j].classList.remove("full");
			}
		}
	}
}

function neighbours_count(t, x, y){//Compte tous les voisins de la cellules (x,y)
	var min_x = Math.max(0, x-1);
	var max_x = Math.min(t.length-1, x+1);
	var min_y = Math.max(0, y-1);
	var max_y = Math.min(t[0].length-1, y+1);
	
	var result = 0;
	for(var i=min_x; i<=max_x; i++){
		for(var j=min_y; j<=max_y; j++){
			result += t[i][j];
		}
	}
	
	result -= t[x][y];//La cellule n'est pas sa propre voisine
	return result;
}