import java.util.Scanner;

public class Ej2 {

    static Scanner scan = new Scanner(System.in);

    static int menu(){
        System.out.println("Seleccione una opcion del menu:");
        System.out.println("1) Calcular sumatorio.");
        System.out.println("2) Calcular media.");
        System.out.println("3) Salir.");
        int option = scan.nextInt();
        return option;
    }
    static void sumatory(){
        int sum = 0;
        System.out.println("Introduzca un numero entero positivo...");
        int num = scan.nextInt();
        while(num < 1){
            System.out.println(num + " no es un numero entero positivo. Por favor introduzca un numero entero positivo...");
            num = scan.nextInt();
        }
        for(int i = 1; i <= num; i++){
            sum += i;
        }
        System.out.println("El resultado del sumatorio es: " + sum);
    }
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
    static void average(double[] array){
        double sum = 0;
        for(double value:array){
            sum += value;
        }
        System.out.println("El valor de la media es: " + sum/array.length);
    }


    public static void main(String[] args){
        int option = menu();
        while(option > 3 || option < 1){
            System.out.println("Comando no valido.");
            option = menu();
        }
        while(option != 3){
            if(option == 1){
                sumatory();
            } else {
                average(createArrays());
            }
            option = menu();
        }
    }
}
