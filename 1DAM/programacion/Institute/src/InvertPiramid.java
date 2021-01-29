import java.util.Scanner;
import java.text.Format;

public class InvertPiramid{

	static void piramidNums(int n){
		for(int i = 1; i <= n; i++){
			int num = 1;
			for(int k = n; k > i; k--){
				char space = ' ';
				System.out.print(String.format("   ", space));
			}
				for(int j = 0; j < i; j++){
					System.out.print(String.format("%2d ", num));
					num++;
				}
			System.out.println();
		}
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un numero entero positivo...");
		int n = scan.nextInt();
		while(n < 1){
			System.out.println(n + " no es un entero positivo. Por favor introduzca un entero positivo...");
			n = scan.nextInt();
		}
		System.out.println();
		piramidNums(n);
	}
}