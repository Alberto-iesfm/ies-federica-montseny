import java.util.Scanner;

public class StarPiramid {

    static void piramid(int n){
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca un numero mayor que 0...");
        int n = scan.nextInt();
        while(n < 1){
            System.out.println(n + " no es un numero mayor que 0. Por favor introduzca un numero mayor que 0...");
            n = scan.nextInt();
        }
        System.out.println();
        piramid(n);
    }
}
