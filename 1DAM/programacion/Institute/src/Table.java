import java.util.Scanner;
import java.text.Format;

public class Table{

	static void table(int n){
		for (int i = 1; i <= n; i++){
			for(int j = 0; j < n; j++){
				int num = i + j;
				System.out.print(String.format ("%2d ", num));
			}
			System.out.println();
		}

	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un entero positivo...");
		int n = scan.nextInt();
		while (n < 1){
			System.out.println(n + " no es un entero positivo. Por favor introduzca un entero positivo...");
			n = scan.nextInt();
		}
		table(n);
	}
}