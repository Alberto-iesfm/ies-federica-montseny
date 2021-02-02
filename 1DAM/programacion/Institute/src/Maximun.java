import java.util.Scanner;

public class Maximun{
	
	static int maxim(int[] values){
		int max = values[0];
		for(int maxi:values){
			if(maxi > max){
				max = maxi;
			}
		}
	return max;
	}

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca cuantos numeros desea introducir...");
		int n = scan.nextInt();
		int[] values = new int[n];
		for(int i = 0; i < n; i++){
			System.out.println("Introduzca el valor...");
			values[i] = scan.nextInt();
		}
		System.out.println("El valor maximo es: " + maxim(values));
	}
}