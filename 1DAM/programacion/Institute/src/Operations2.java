import java.util.Scanner;

public class Operations2{

	static Scanner scan = new Scanner(System.in);

	static int[] createArray(){
		System.out.println("Introduzca cuantos numeros desea introducir en su lista...");
		int n = scan.nextInt();
		while (n < 1){
			System.out.println("debe introducir al menos un numero en la lista. por favor, introduzca cuantos numeros desea introducir en su lista...");
			n = scan.nextInt();
		}
		int[] numbers = new int[n];
		System.out.println("Introduzca " + n + " numeros...");
		for (int i = 0; i < n; i++){
			numbers[i] = scan.nextInt();
		}
		return numbers;
	}
	static int minimum(){
		int[] numbers = createArray();
		int min = numbers[0];
		for(int number:numbers){
			if (number < min){
				min = number;
			}
		}
		return min;
	}
	static int maximum(){
		int[] numbers = createArray();
		int max = numbers[0];
		for(int number:numbers){
			if (number > max){
				max = number;
			}
		}
		return max;
	}
	static double average(){
		int[] numbers = createArray();
		double sum = 0;
		for(double number:numbers){
			sum = sum + number;
		}
		return sum / numbers.length;
	}
	static String operations(){
		System.out.println("Introduzca la operacion que desea realizar (minimo/maximo/media/exit)...");
		String operation = scan.next();
		while (!operation.equals("minimo") && !operation.equals("maximo") && !operation.equals("media") && !operation.equals("exit")){
			System.out.println("Operacion no valida. Por favor introduzca una operacion valida (minimo/maximo/media/exit)...");
			operation = scan.next();
		}
		return operation;
	}

	public static void main(String[] args){
		String operation = operations();
		while (!operation.equals("exit")) {
			if (operation.equals("minimo")) {
				System.out.println("El valor minimo de la lista es: " + minimum());
			} else if (operation.equals("maximo")) {
				System.out.println("El valor maximo de la lista es: " + maximum());
			} else {
				System.out.println("El valor medio de la lista es: " + average());
			}
			operation = operations();
		}
	}
}