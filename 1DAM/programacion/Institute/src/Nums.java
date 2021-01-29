import java.util.Scanner;

public class Nums{
	
	static int sum(int n){
		Scanner scan = new Scanner(System.in);
		int suma = 0;
		while(n != 0){
			suma = suma + n;
			System.out.println("Introduzca otro numero...");
			n = scan.nextInt();
		}
		return suma;
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un numero...");
		int n = scan.nextInt();
		System.out.println("La suma de todos los numeros introducidos es: " + sum(n));
	}
}