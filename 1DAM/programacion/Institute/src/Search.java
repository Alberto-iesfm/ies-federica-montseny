public class Search{
	static boolean find(Double[] datos, double valor){
		for(double data:datos){
			if(data == valor){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args){
		if(args.length == 1){
		Double valor = Double.parseDouble(args[0]);
		Double[] datos = { 1.2 , 2.5 , 3.5 };
		boolean b = find(datos, valor);
			if(b == true){
				System.out.println("Encontrado");
			} else {
				System.out.println("No encontrado");
			}
		} else {
			System.out.println("Es necesario introducir solo un valor de busqueda");
		}
	}
}