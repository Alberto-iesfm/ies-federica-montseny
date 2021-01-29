public class SearchNum {
	static boolean buscar(int[] numeros, int dato){
		boolean encontrado = false;
		for(int numero:numeros){
			if(numero == dato){
				encontrado = true;
				break;
			}
		}
		return encontrado;
	}
	public static void main(String[] args){
		int[] numeros = {1, 3, 2, 7};
		if(args.length == 1){
			int dato = Integer.parseInt(args[0]);
			if(buscar(numeros, dato)){
				System.out.println("encontrado");
			} else {
				System.out.println("no encontrado");
			}
		} else {
			System.out.println("debe introducirse un solo argumento");
		}
	}
}