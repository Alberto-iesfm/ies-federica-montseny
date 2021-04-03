function numberNotFound(x, y){
	return (x == "" || y == "");
}

function divisorIsZero(y){
	return y == 0;
}

function sum() {
	var x = document.getElementById("x").value;
	var y = document.getElementById("y").value;
	if (numberNotFound(x, y)) {
		document.getElementById("result").innerHTML = "";
		window.alert("Es necesario introducir los dos numeros!");
	} else {
		x = parseFloat(x);
		y = parseFloat(y);
		document.getElementById("result").innerHTML = "El resultado de " + x + " + " + y + " es: " + (x + y);
		document.getElementById("data").reset();
	}
}

function subtract() {
	var x = document.getElementById("x").value;
	var y = document.getElementById("y").value;
	if (numberNotFound(x, y)) {
		document.getElementById("result").innerHTML = "";
		window.alert("Es necesario introducir los dos numeros!");
	} else {
		x = parseFloat(x);
		y = parseFloat(y);
		document.getElementById("result").innerHTML = "El resultado de " + x + " - " + y + " es: " + (x - y);
		document.getElementById("data").reset();
	}
}

function multiply() {
	var x = document.getElementById("x").value;
	var y = document.getElementById("y").value;
	if (numberNotFound(x, y)) {
		document.getElementById("result").innerHTML = "";
		window.alert("Es necesario introducir los dos numeros!");
	} else {
		x = parseFloat(x);
		y = parseFloat(y);
		document.getElementById("result").innerHTML = "El resultado de " + x + " * " + y + " es: " + (x * y);
		document.getElementById("data").reset();
	}
}

function divide() {
	var x = document.getElementById("x").value;
	var y = document.getElementById("y").value;
	if (numberNotFound(x, y)) {
		document.getElementById("result").innerHTML = "";
		window.alert("Es necesario introducir los dos numeros!");
	} else {
		x = parseFloat(x);
		y = parseFloat(y);
		if (divisorIsZero(y)) {
			document.getElementById("result").innerHTML = "";
			window.alert("El divisor no puede ser 0!")
		} else {
			document.getElementById("result").innerHTML = "El resultado de " + x + " / " + y + " es: " + (x / y);
			document.getElementById("data").reset();
		}
	}
}