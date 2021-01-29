import java.util.Scanner;

public class Negatives{

	static int negativos(int[] values){
		int neg = 0;
		for(int value:values){
			if(value < 0){
				neg++;
			}
		}
		return neg;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Indique cuantos numeros desea introducir...");
		int n = scan.nextInt();
		int[] values = new int[n];
		for(int i = 0; i < n; i++){
			System.out.println("Introduzca el valor...");
			values[i] = scan.nextInt();
		}
		System.out.println("La cantidad de numeros negativos es: " + (negativos(values)));
	}
}