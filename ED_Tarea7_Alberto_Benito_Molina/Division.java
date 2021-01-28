public class Division {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("ERROR. Tiene que haber dos argumentos.");
        } else {
            double dividend = Double.parseDouble(args[0]);
            double divider = Double.parseDouble(args[1]);
            if (divider == 0) {
                System.out.println("ERROR. El segundo argumento no puede ser 0.");
            } else {
                printResult(dividend, divider);
            }
        }
    }

    static double division(double dividend, double divider) {
        return dividend / divider;
    }

    static void printResult (double dividend, double divider) {
        System.out.println("El resultado de la división es: " + division(dividend, divider));
    }

}

