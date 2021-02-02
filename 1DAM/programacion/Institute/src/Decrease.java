public class Decrease{

	static int suma(int[] numero){
		int s = 0;

		for(int d = numero[0]; d > 0; d--){
		s = s + d;

		}
		return s;
	}
	public static void main(String[] args){
		if(args.length == 1){

			int numero[] = new int[args.length];
			for(int i = 0; i < args.length; i++){
			int n = Integer.parseInt(args[i]);
			numero[i] = n;
			}
			
			int total = suma(numero);
			if(numero[0] >= 0){

			System.out.println("el valor obtenido es: " + total);
			
			} else {
			
			System.out.println("el argumento no puede ser negativo");
			}
		} else {
			
			System.out.println("es obligatorio introducir un solo argumento");
		}
	}
}