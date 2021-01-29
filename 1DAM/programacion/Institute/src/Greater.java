import java.util.Scanner;

public class Greater{
	
	static boolean mayor(int num1, int num2){
		if (num1 > num2){
			return true;
		}
		return false;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un numero...");
		int num1 = scan.nextInt();
		System.out.println("Introduzca un mumero mayor que " + num1 + "...");
		int num2 = scan.nextInt();
		while (mayor (num1, num2)){
			System.out.println(num2 + " no es mayor que " + num1 + ". Intentelo de nuevo...");
			num2 = scan.nextInt();
		}
		System.out.println("Los numeros que ha introducido son: " + num1 + " y " + num2);
	}
}