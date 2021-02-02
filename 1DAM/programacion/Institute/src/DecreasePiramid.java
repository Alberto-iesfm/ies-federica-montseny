import java.util.Scanner;
import java.text.Format;

public class DecreasePiramid{
	static void decreasePiramid(int n){
		for(int i = n; i > 0; i--){
			for(int j = 1; j <= i; j++){
				System.out.print(String.format("%2d ", i));
			}
			System.out.println();
		}
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un numero entero positivo...");
		int n = scan.nextInt();
		while(n < 1){
			System.out.println(n + " no es un entero positivo. Por favor, introduzca un numero entero positivo...");
			n = scan.nextInt();
		}
		System.out.println();
		decreasePiramid(n);
	}
}