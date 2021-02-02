public class AverageLoop {
	
	public static void main (String[] args) {

		for(String arg: args){
			
		double x[] = Double.parseDouble(arg);
		for (double numero: x){
			double media = numero / args.length;
			System.out.println(media);
			}	
		}
	}
}
