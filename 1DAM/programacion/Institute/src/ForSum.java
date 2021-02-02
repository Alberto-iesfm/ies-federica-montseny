public class ForSum{

	static int sumaa(int[] suma){
		int v = 0;

		for(int ss:suma){
			v = v + ss;
		}
		return v;
	}
	public static void main(String[] args){
	
		if (args.length > 0){
			int suma[] = new int[args.length];
			for (int i = 0; i < args.length; i++){
				int s = Integer.parseInt(args[i]);
				suma[i] = s;
		
			}
			int sum = sumaa(suma);
		
			System.out.println("la suma total es igual a: " + sum);
		
		} else {
		
			System.out.println ("tiene que existir al menos un valor");
		}
	}
}