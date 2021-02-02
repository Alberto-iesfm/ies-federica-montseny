public class SumaArgumentos {

	public static void main (String[] args) {

		int suma = 0;
		for (int i = 0; i < args.length; i++){
			int n = Integer.parseInt(args[i]);
			suma = suma + n;
		}
	System.out.println(suma);
	}
}