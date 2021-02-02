public class Surface {
	static double calculateArea(double x1, double y1, double x2, double y2) {
		double a = x1 - x2;
		if (a < 0) {
			a = -a;
		}
		double b = y1 - y2;
		if (b < 0) {
			b = -b;
		}
		double area = a * b;

		return area;
	}

	public static void main (String[] args){
		double Vertice1x, Vertice1y, Vertice2x, Vertice2y, a, g, b, h;
		Vertice1x = -1.5; 
		Vertice1y = -1.0;
		
		Vertice2x = -3.5;
		Vertice2y = -5.0;

		a = (Vertice1x - Vertice2x);
		g = (Vertice1y - Vertice2y);

		if(a < 0) {
			b = (-1 * a);
		} else {
			b = a;
		}

		if(g < 0) {
			h = (-1 * g);
		} else {
			h = g;
		}

		double surface=(b * h);

		System.out.println("el area del rectangulo es:" + surface);		
	}
}