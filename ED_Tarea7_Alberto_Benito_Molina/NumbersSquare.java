import java.text.Format;
import java.util.Scanner;

public class NumbersSquare {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca número un mayor que 1");
        int number = scan.nextInt();
        while (number < 1) {
            System.out.println("Introduzca número un mayor que 1");
        }
        for (int i = 1; i <= number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print(String.format ("%02d ", (i + j)));
            }
            System.out.println();
        }
    }
}
