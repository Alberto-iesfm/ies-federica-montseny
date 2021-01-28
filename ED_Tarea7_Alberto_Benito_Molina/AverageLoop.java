public class AverageLoop {

    static double getAvg(double[] numbers) {
        double sum = 0;
        for (double number : numbers) {
            sum = sum + number;
        }
        return sum / numbers.length;
    }

    public static void main(String[] args) {
        double[] numbers = new double[args.length];
        if (args.length > 0) {
            double number = 0;
            for (int i = 0; i < args.length; i++) {
                numbers[i] = Double.parseDouble(args[i]);
            }
            System.out.println("La media es " + getAvg(numbers));
        } else {
            System.out.println("Añade los argumentos");
        }
    }
}
