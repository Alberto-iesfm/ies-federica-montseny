import java.text.Format;
import java.util.Scanner;

public class NumbersPiramid {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca número un mayor que 1");
        int n = scan.nextInt();
        while (n < 1) {
            System.out.println("Introduzca número un mayor que 1");
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(String.format ("%02d ", (i + j)));
            }
            System.out.println();
        }
    }
}
