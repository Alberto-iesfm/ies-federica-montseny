public class AverageCasting{
	static double average(int[] valores){
		int media = 0;
		for(int valor:valores){
			media = media + valor;
		}
		double med = media;
		return med / valores.length;
	}
	public static void main(String[] args){
		if (args.length >= 1){
			int[] valores = new int[args.length];
			for ( int i = 0; i < args.length; i++){
				valores[i] = Integer.parseInt(args[i]);
			}
			double m = average(valores);
			System.out.println("el valor de la media es: " + m);
		} else {
			System.out.println("Debe introducir al menos un valor");
		}
	}
}