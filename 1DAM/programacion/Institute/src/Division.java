public class Division{
	static double div(double a, double b){
		return a / b;
	}
	static void print(double d){
		System.out.println("el resultado de la division es " + d);
	}
	public static void main(String[] args){
		if (args.length == 2){
			double a = Double.parseDouble(args[0]);
			double b = Double.parseDouble(args[1]);
			if (b == 0){
				System.out.println("el segundo valor no puede ser 0");
			} else {
			double d = div(a, b);
			print(d);
			}
		} else {
			System.out.println("se deben introducir solo dos valores");
		}
	}
}