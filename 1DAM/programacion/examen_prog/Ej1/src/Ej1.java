import java.util.Scanner;

public class Ej1 {

    static Scanner scan = new Scanner(System.in);

    static int askInt(){
        System.out.println("Introduzca un numero entero mayor que 0...");
        int n = scan.nextInt();
        while (n < 1){
            System.out.println(n + " no es un entero mayor que 0. Por favor introduzca un numero entero myor que 0...");
            n = scan.nextInt();
        }
        return n;
    }
    static double[] createArrays(){
        int n = askInt();
        double[] arrayDouble = new double[n];
        System.out.println("Introduzca " + n + " numeros decimales...");
        for (int i = 0; i < n; i++){
            arrayDouble[i] = scan.nextDouble();
        }
        return arrayDouble;
    }
    static double sumArrays (double[] array1, double[] array2){
        double sum = 0;
        for(double value:array1){
            sum += value;
        }
        for(double value:array2){
            sum += value;
        }
        return sum;
    }
    static void printSum(double sum){
        System.out.println("El resultado es " + sum);
    }

    public static void main(String[] args){
        double[] array1 = createArrays();
        double[] array2 = createArrays();
        double sum = sumArrays(array1, array2);
        printSum(sum);
    }
}
