import java.util.Random;

public class whileexample {

	public static void main (String[] args) {
		Random r = new Random ();
		int dice = r.nextInt(6);
		while(dice != 5) {
			System.out.println("sigue probando");
			dice = r.nextInt(6);
		}
		System.out.println("conseguido");
	}
}