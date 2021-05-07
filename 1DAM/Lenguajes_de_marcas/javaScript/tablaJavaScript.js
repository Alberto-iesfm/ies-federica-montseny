function createUser(){
	var newUser = {name:document.getElementById("Name").value, phone:document.getElementById("Number").value};
	add(newUser);
}

function add(user){
	var row = document.createElement("tr");

	var column1 = document.createElement ("td");
	var name = document.createTextNode(user.name);
	column1.appendChild(name);

	var column2 = document.createElement ("td");
	var number = document.createTextNode(user.phone);
	column2.appendChild(number);

	row.appendChild(column1);
	row.appendChild(column2);

	document.getElementById("tabla").appendChild(row);
}