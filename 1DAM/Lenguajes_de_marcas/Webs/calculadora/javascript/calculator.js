
function sum() {
	var num1 = parseInt(document.getElementById("num1").value);
	var num2 = parseInt(document.getElementById("num2").value);
	document.getElementById("result").innerHTML = num1 + num2;
}

function subtract(num1, num2) {
	return num1 - num2;
}

function multuply(num1, num2) {
	return num1 * num2;
}

function divide(num1, num2) {
	return num1 / num2;
}