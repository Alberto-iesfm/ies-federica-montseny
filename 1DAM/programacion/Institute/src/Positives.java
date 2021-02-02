import java.util.Scanner;

public class Positives{

	static boolean positive(int n){
		boolean pair = false;
		if(n > 0){
			pair = true;
		}
		return pair;
	}

	public static void main(String[] main){
		int x = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un numero positivo...");
		int n = scan.nextInt();
		while(positive(n)){
			x++;
			System.out.println("Introduzca otro numero positivo...");
			n = scan.nextInt();
		}
		System.out.println("Ha introducido " + x + " numeros positivos");	
	}
}