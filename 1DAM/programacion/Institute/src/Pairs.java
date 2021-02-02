import java.util.Scanner;

public class Pairs{

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca un numero par...");
		int num = scan.nextInt();
		int pares = 0;
		while(num % 2 != 0){
			System.out.println(num + " no es un numero par. Intentelo de nuevo:");
			num = scan.nextInt();
		}
		pares = 1;
		System.out.println("Desea introducir otro numero par? (S/N):");
		char r = scan.next().charAt(0);
		while (r == 's' || r == 'S'){
			System.out.println("Introduzca un numero par...");
			num = scan.nextInt();
			while (num % 2 != 0){
				System.out.println(num + " no es un numero par. Intentelo de nuevo:");
				num = scan.nextInt();
			}
			System.out.println("Desea introducir otro numero par? (S/N):");
			r = scan.next().charAt(0);
			pares++;
		}
		System.out.println("Ha introducido " + pares + " numeros pares");
	}
}