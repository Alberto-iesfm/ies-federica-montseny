public class Average {


	public static void main(String[] args) {
		double a, b, c;
		a = 0.3;
		b = 10.6;
		c = 3.7;
		double average=(a + b + c / 3);
		if(average > 0){
			System.out.println("media positiva");
		} else if(average < 0){
			System.out.println("media negativa");
		} 
		if(average > c){
			System.out.println("C esta por debajo de la media");
		}
	}
}
