public class Multiply2 {

	public static void main (String[] args){

	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);

		if(a < b){
			while(a < b) {
				System.out.println("El valor de a es: " + a);
				a = a * 2;
			}
		} else {
			while(b < a){
				System.out.println("El valor de b es: " + b);
				b = b * 2;
			}
		}
	}
}