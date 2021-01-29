public class ForAverage{

	static double medias(double[] valores){
		double v = 0.0;
			
		for (double x:valores){
			v = v + x;		
		}
		return v / valores.length;
	}
	public static void main(String[] args){

		if (args.length > 0){
			double valores[] = new double[args.length];
			for (int i= 0; i < args.length; i++){
				double valor = Double.parseDouble(args[i]);
				valores[i] = valor;
			}
			double avg = medias(valores);
			
			System.out.println(avg);
		} else {
			System.out.println("tiene que haber al menos un numero");
		}
	}
}