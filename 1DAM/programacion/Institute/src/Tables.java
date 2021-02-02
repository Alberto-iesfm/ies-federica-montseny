public class Tables{
	static void multiply(int n){
		for(int m = 1; m <= 10; m++){
			int multiply = n * m;
			System.out.println(n + " X " + m + " = " + multiply);
		}
	}
	public static void main(String[] args){
		for(int n = 1; n <= 10; n++){
			System.out.println();
			System.out.println("Tabla del " + n);
			multiply(n);
		}			
	}
}