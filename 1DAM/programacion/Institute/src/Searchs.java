import java.util.Scanner;

public class Searchs{
	static int[] createArray(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Ingrese cuantos numeros desea introducir...");
		int n = scan.nextInt();
		while(n < 1){
			System.out.println("Debe ingresar al menos 1 numero. por favor introduzca un numero mayor que 0...");
			n = scan.nextInt();
		}
		int[] numbers = new int[n];
		System.out.println("Introduzca " + n + " numeros...");
		for(int i = 0; i < n; i++){
			numbers[i] = scan.nextInt();
		}
	return numbers;
	}
	static boolean search(int num1, int[] numbers2){
		boolean encontrado = false;
		for(int num2:numbers2){
			if(num1 == num2){
				encontrado = true;
				break;
			}
		}
		return encontrado;
	}
	public static void main(String[] args){
		int[] numbers1 = createArray();
		int[] numbers2 = createArray();
		for(int num1:numbers1){
			if(search(num1, numbers2)){
				System.out.println("El numero " + num1 + " se encuentra en ambos arrays");
			}
		}
	}
}