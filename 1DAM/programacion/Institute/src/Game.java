import java.util.Scanner;
import java.util.Random;

public class Game{
	static String search(int n, int x){
		String erroneo;
		if(x < n){
			erroneo = "El numero introducido es menor";
		} else {
			erroneo = "El numero introducido es mayor";
		}
		return erroneo;
	}
	public static void main(String[] args){
		Random r = new Random();
		int n = r.nextInt(100);
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un numero del 0 al 100...");
		int x = scan.nextInt();
		while(n != x){
			System.out.println(search(n , x));
			System.out.println("Introduzca otro numero...");
			x = scan.nextInt();
		}
		System.out.println("¡Exacto!");
	}
}