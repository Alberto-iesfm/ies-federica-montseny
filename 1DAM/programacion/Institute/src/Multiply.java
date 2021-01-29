import java.util.Scanner;

public class Multiply{
    static int[] createArray(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca cuantos numeros desea introducir...");
        int n = scan.nextInt();
        while (n < 1){
            System.out.println("Debe ingresar al menos un numero. Por favor, introduzca cuantos numeros desea introducir...");
            n = scan.nextInt();
        }
        int[] numbers = new int[n];
        System.out.println("introduzca " + n + " numeros...");
        for(int i = 0; i < n; i++){
            numbers[i] = scan.nextInt();
        }
        return numbers;
    }
    static void printResult(int[] numbers1, int[] numbers2){
        for (int number1:numbers1){
            int result = number1;
            for (int number2:numbers2){
                result = result * number2;
            }
            System.out.println("Resultado de " + number1 + " por el segundo array: " + result);
        }
    }

    public static void main(String[] args){
        int [] numbers1 = createArray();
        int [] numbers2 = createArray();
        System.out.println();
        printResult(numbers1, numbers2);
    }
}