import java.util.Scanner;

public class Calculator2 {

    static Scanner scan = new Scanner(System.in);

    static void sum(){
        System.out.println("Introduzca dos valores enteros...");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int suma = num1 + num2;
        System.out.println("El resultado de sumar " + num1 + " + " + num2 + " es igual a: " + suma);
    }
    static void subtract(){
        System.out.println("Introduzca dos valores enteros...");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int resta = num1 - num2;
        System.out.println("El resultado de restar " + num1 + " - " + num2 + " es igual a: " + resta);
    }
    static void multiply(){
        System.out.println("Introduzca dos valores enteros...");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int multiplicar = num1 * num2;
        System.out.println("El resultado de multiplicar " + num1 + " X " + num2 + " es igual a: " + multiplicar);
    }
    static void divide(){
        System.out.println("Introduzca dos valores ...");
        double num1 = scan.nextDouble();
        double num2 = scan.nextDouble();
        while(num2 == 0){
            System.out.println("El divisor no puede ser 0. Por favor, introduzca otro divisor...");
            num2 = scan.nextInt();
        }
        double dividir = num1 / num2;
        System.out.println("El resultado de dividir " + num1 + " / " + num2 + " es igual a: " + dividir);
    }
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
    static int average(){
        int[] numbers = createArray();
        int sum = 0;
        for(int number:numbers){
            sum = sum + number;
        }
        return sum / numbers.length;
    }
    static String operations(){
        System.out.println("Introduzca la operacion que desea realizar (suma/resta/multiplicacion/division/minimo/maximo/media/exit)...");
        String operation = scan.next();
        while (!operation.equals("minimo") && !operation.equals("maximo") && !operation.equals("media") && !operation.equals("exit")
                && !operation.equals("suma") && !operation.equals("resta") && !operation.equals("multiplicacion") && !operation.equals("division")){
            System.out.println("Operacion no valida. Por favor introduzca una operacion valida (suma/resta/multiplicacion/division/minimo/maximo/media/exit)...");
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
            } else if (operation.equals("media")){
                System.out.println("El valor medio de la lista es: " + average());
            } else if (operation.equals("suma")){
                sum();
            } else if (operation.equals("resta")){
                subtract();
            } else if (operation.equals("multiplicacion")){
                multiply();
            } else {
                divide();
            }
            operation = operations();
        }
    }
}
