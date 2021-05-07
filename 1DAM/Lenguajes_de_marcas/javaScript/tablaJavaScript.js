function add(){
	var row = document.createElement("tr");

	var column1 = document.createElement ("td");
	var name = document.createTextNode(document.getElementById("Name").value);
	column1.appendChild(name);

	var column2 = document.createElement ("td");
	var number = document.createTextNode(document.getElementById("Number").value);
	column2.appendChild(number);

	row.appendChild(column1);
	row.appendChild(column2);

	document.getElementById("tabla").appendChild(row);
}