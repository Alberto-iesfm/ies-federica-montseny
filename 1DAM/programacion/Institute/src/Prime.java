import java.util.Scanner;

public class Prime{
	static boolean primos(int n){
		for(int i = 2; i < n; i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Inserte un valor mayor que 1...");
		int n = scan.nextInt();
		while(n <= 1){
			System.out.println("Debe introducir un numero mayor que 1...");
			n = scan.nextInt();
		}
		if(primos(n)){
			System.out.println("El valor " + n + " es primo");
		} else {
			System.out.println("El valor " + n + " no es primo");
		}
	}
}