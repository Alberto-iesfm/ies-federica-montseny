import java.util.Scanner;

public class Averagescan{

	static double media(double[] valores){
		double suma = 0;
		for(double n:valores){
			suma = suma + n;
		}
		return suma / valores.length;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca cuantos valores desea introducir...");
		int n = scan.nextInt();
		while (n < 1){
			System.out.println("debe introducir al menos un valor");
			System.out.println("Introduzca cuantos valores desea introducir...");
			n = scan.nextInt();
		}
		double[] valores = new double[n];
		for(int i = 0; i < n; i++){
			System.out.println("Introduzca un valor...");
			valores[i] = scan.nextDouble();
			}
		System.out.println("la media calculada es: " + media(valores));
	}
}