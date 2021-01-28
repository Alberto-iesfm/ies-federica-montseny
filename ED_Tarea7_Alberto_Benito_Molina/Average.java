public class Average {

    public static void main(String[] args) {
        double[] numbers = {2.1, 4.2, 5.3};
        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }
        System.out.println("la media es: " + (sum / numbers.length));
    }
}

