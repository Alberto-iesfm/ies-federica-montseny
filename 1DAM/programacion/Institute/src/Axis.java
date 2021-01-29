public class Axis{

	static boolean ejeY(String[] args){

		double x1 = Double.parseDouble(args[0]);
		double x2 = Double.parseDouble(args[2]);
		boolean y;

		y = x1 > 0 && x2 < 0 || x1 < 0 && x2 > 0;

		return y;
	}

	static boolean ejeX(String[] args){

		double y1 = Double.parseDouble(args[1]);
		double y2 = Double.parseDouble(args[3]);
		boolean x;

		x = y1 > 0 && y2 < 0 || y1 < 0 && y2 > 0;

		return x;
	}

	public static void main(String[] args){
		boolean yy = ejeY(args);
		boolean xx = ejeX(args);				


		System.out.println ("La linea cruza el eje Y " + yy);
		System.out.println ("La linea cruza el eje X " + xx);

	}
}