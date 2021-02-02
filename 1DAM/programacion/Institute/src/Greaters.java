import java.util.Scanner;

public class Greaters{
	static void mayor(double num1, double num2){
		Scanner scan = new Scanner(System.in);
		while (num1 < num2){
			System.out.println("Escriba otro numero mayor que " + num1 + "...");
			num2 = scan.nextDouble();
		}
		System.out.println(num2 + " no es mayor que " + num1);
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un numero...");
		double num1 = scan.nextDouble();
		System.out.println("introduzca un numero mayor que " + num1 + "...");
		double num2 = scan.nextDouble();
		mayor(num1, num2);
	}
}