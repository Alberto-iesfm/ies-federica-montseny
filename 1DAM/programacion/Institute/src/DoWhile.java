public class DoWhile{

	public static void main(String[] args){
		
		int a = Integer.parseInt(args[0]);
		int x = 0;
		
			do{
			System.out.println("hola mundo " + x);
			x++;
		} while (a > x);
	}
}