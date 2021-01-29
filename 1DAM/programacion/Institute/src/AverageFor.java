public class AverageFor{
	static double media(double[] valores){
		double v = 0;
		for (double val:valores){
			v = v + val;
		}
		return v / valores.length;
	}
	static void print(double m){
		System.out.println("la media es: " + m);
	}
	public static void main(String[] args){
		if (args.length == 0){
			System.out.println("Tiene que haber al menos un argumento");
		} else {
			double[] valores = new double[args.length];
			for (int i = 0; i < args.length; i++){
				valores[i] = Double.parseDouble(args[i]);
			}
			double m = media(valores);
			print(m);
		}
	}
}