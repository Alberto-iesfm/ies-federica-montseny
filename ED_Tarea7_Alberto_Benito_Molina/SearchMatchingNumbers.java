import java.util.Scanner;

public class SearchMatchingNumbers {

    static Scanner scan = new Scanner(System.in);

    static int[] getNumbers() {
        System.out.print("Introduzca el tamaño del array...");
        int size = scan.nextInt();
        while(size <= 0) {
            System.out.print("El array debe tener al menos un valor, introduzca un tamaño superior a 0...");
            size = scan.nextInt();
        }
        int[] numbers = new int[size];
        System.out.println("Introduce los " + size + " numeros del array...");
        for(int i = 0; i < size; i++) {
            numbers[i] = scan.nextInt();
        }
        return numbers;
    }

    static boolean searchValue(int[] numbers, int value) {
        boolean found = false;
        for(int number : numbers) {
            if (number == value) {
                found = true;
            }
        }
        return found;
    }

    public static void main(String[] args) {
        int[] numbers1 = getNumbers();
        int[] numbers2 = getNumbers();
        for (int value : numbers1) {
            if (searchValue(numbers2, value)) {
                System.out.println("El numero " + value + " se encuentra en ambas listas.");
            }
        }
    }
}
