import java.util.Scanner;

public class Operations{

	static Scanner scan = new Scanner(System.in);

	static void sum(int num1, int num2){
		int suma = num1 + num2;
		System.out.println("El resultado de sumar " + num1 + " + " + num2 + " es igual a: " + suma);
	}
	static void subtract(int num1, int num2){
		int resta = num1 - num2;
		System.out.println("El resultado de restar " + num1 + " - " + num2 + " es igual a: " + resta);
	}
	static void multiply(int num1, int num2){
		int multiplicar = num1 * num2;
		System.out.println("El resultado de multiplicar " + num1 + " X " + num2 + " es igual a: " + multiplicar);
	}
	static void divide(int num1, int num2){
		while(num2 == 0){
			System.out.println("El divisor no puede ser 0. Por favor, introduzca otro divisor...");
			num2 = scan.nextInt();
		}
		int dividir = num1 / num2;
		System.out.println("El resultado de dividir " + num1 + " / " + num2 + " es igual a: " + dividir);
	}
	static String operations(){
		System.out.println("Introduzca la operacion que desea realizar (suma/resta/multiplicacion/division/exit)...");
		String operation = scan.nextLine();
		if (operation.equals("")) {
			operation = scan.nextLine();
		}
		while (!operation.equals("suma") && !operation.equals("resta") && !operation.equals("multiplicacion") && !operation.equals("division") && !operation.equals("exit")){
			System.out.println("Operacion no valida. Por favor introduzca una operacion valida (suma/resta/multiplicacion/division/exit)...");
			operation = scan.nextLine();
		}
		return operation;
	}

	public static void main(String[] args){
		String operation = operations();
		while (!operation.equals("exit")){
			System.out.println("Introduzca dos valores enteros...");
			int num1 = scan.nextInt();
			int num2 = scan.nextInt();
			if (operation.equals("suma")){
				sum(num1, num2);
			} else if (operation.equals("resta")){
				subtract(num1, num2);
			} else if (operation.equals("multiplicacion")){
				multiply(num1, num2);
			} else {
				divide(num1, num2);
			}
			operation = operations();
		}
	}
}