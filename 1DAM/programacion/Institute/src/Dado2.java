import java.util.Random;

public class Dado2 {

	public static void main (String[] args) {
		Random r = new Random();
		int dice = r.nextInt(10);
		int dado = dice + 1;
		System.out.println(dado);
	}
}