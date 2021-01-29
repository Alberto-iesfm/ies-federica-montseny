public class Numbers{
	static int maximo(int[] numero){
		int m = numero[0];

		for(int max:numero){
			while(max > m){
			m = max;
			}
		}

		return m;
	}
	static int minimo(int[] numero){
		int l = numero[0];

		for(int min:numero){

			while(min < l){
			l = min;
			}
		}

		return l;
	}
	public static void main(String[] args){

		if (args.length == 2){
			int numero[] = new int[args.length];

				for(int i = 0; i < args.length; i++){
				int n = Integer.parseInt(args[i]);
				numero[i] = n;
			}

				int a = maximo(numero);
				int b = minimo(numero);

				for(int x = b; x <= a; x++){

					System.out.println(x);
			}

		} else {

			System.out.println("tiene que haber dos valores");
		}
	}
}