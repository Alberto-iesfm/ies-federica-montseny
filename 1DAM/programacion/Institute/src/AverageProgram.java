import java.util.Scanner;

public class AverageProgram {
    static double[] parseDouble(String numbersChain){
        String[] nums = numbersChain.split(",");
        double[] numbers = new double[nums.length];
        for(int i = 0; i < nums.length; i++){
           numbers[i] = Double.parseDouble(nums[i].trim());
        }
        return numbers;
    }
    static double average(double[] numbers){
        double sum = 0;
        for(double number:numbers) {
            sum += number;
        }
        return sum / numbers.length;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca los numeros de los que desea calcular la media");
        String numbersChain = scan.nextLine();
        double[] numbers = parseDouble(numbersChain);
        System.out.println("La media calculada es igual a: " + average(numbers));
    }
}
