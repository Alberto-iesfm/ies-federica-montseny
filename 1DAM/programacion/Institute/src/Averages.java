import java.util.Scanner;

public class Averages{
	static double avgPos(double[] nums){
		double sum = 0;
		int div = 0;
		for(double num:nums){
			if(num > 0){
				sum = sum + num;
				div++;
			}
		}
		return sum / div;
	}
	static double avgNeg(double[] nums){
		double sum = 0;
		int div = 0;
		for(double num:nums){
			if(num < 0){
				sum = sum + num;
				div++;
			}
		}
		return sum / div;
	}
	static int zero(double[] nums){
		int count = 0;
		for(double num:nums){
			if(num == 0){
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		double[] nums = new double[10];
		System.out.println("Introduzca 10 numeros...");
		for(int i = 0; i < nums.length; i++){
			nums[i] = scan.nextDouble();
		}
		System.out.println("La media de numeros positivos es: " + avgPos(nums));
		System.out.println("La media de numeros negativos es: " + avgNeg(nums));
		System.out.println("La cantidad de ceros es: " + zero(nums));
	}
}