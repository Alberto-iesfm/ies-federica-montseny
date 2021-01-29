public class CalculateMax{
	public int maximo(int[] maxi){

		for (int max:maxi){

			
			while(maxi > max){

			return max;
			}
		}
	}

	public static void main(String[] args){
		
		if (args.length > 0){
			int maxi[] = new int[args.length];	
		
				for (int i = 0; i < args.length; i++){
				int m = Integer.parseInt(args[i]);
				maxi[i] = m;
			}

				int maxim = maximo(maxi);

				
				System.out.println(maxim);
		} else {
		
			System.out.println("tiene que haber al menos un valor");
		}
	}
}