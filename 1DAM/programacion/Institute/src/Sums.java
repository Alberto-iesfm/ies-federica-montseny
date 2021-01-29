import java.util.Scanner;

public class Sums{
	static int min(int v1, int v2){
		if(v1 > v2){
			v1 = v2;
		}
	return v1;
	}
	static int sum(int n){
		int suma = 0;
		for(int num = 0; num <= n; num++){
			suma = suma + num;
		}
	return suma;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese un numero positivo...");
		int v1 = scan.nextInt();
		while (v1 < 0){
			System.out.println(v1 + " no es un numero positivo. Por favor ingrese un numero positivo...");
			v1 = scan.nextInt();
		}
		System.out.println("Ingrese otro numero positivo...");
		int v2 = scan.nextInt();
		while (v2 < 0){
			System.out.println(v2 + " no es un numero positivo. Por favor ingrese un numero positivo...");
			v2 = scan.nextInt();
		}
		int min = min(v1, v2);
		for(int n = min; n <= v1 || n <= v2; n++){
			System.out.println("El sumatorio de " + n + " es : " + sum(n));
		}
	}
}