import java.util.Scanner;

public class Factorial{

	static int factorial(int value){
		int factorial = 1;
		for (int i = 1; i <= value; i++){
			factorial = factorial * i;
		}
		return factorial;
	}
	public static void main(String[] args){
		Scanner valor = new Scanner(System.in);
		System.out.println("Introduce el valor del que desea calcular el factorial...");
		int value = valor.nextInt();
		System.out.println("El valor del factorial calculado es " + (factorial(value)));
	}
}