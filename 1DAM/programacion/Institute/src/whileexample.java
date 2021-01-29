import java.util.Random;

public class whileexample {

	public static void main (String[] args) {
		Ramdom r = new Random ();
		int dice = r.nextInt(bound:6);
		while(dice != 5) {
			System.out.println("sigue probando");
			dice = r.nextInt(bound:6)
		}

		System.out.println("conseguido")
	}
}