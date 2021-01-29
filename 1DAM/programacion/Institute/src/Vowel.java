public class Vowel{

	static void vocal(String[] args){
		
		String letra = args[0];
		char v = letra.charAt(0);

		if (v == 'a' || v == 'e' || v == 'i' || v == 'o' || v == 'u' 
		|| v == 'A' || v == 'E' || v == 'I' || v == 'O' || v == 'U'){
			System.out.println("El caracter es una vocal " + v);

		} else if (v == 'b' || v == 'c' || v == 'd' || v == 'f' 
		|| v == 'g' || v == 'h' || v == 'j' || v == 'k' || v == 'l' 
		|| v == 'm' || v == 'n' || v == 'p' || v == 'q' || v == 'r' 
		|| v == 's' || v == 't' || v == 'v' || v == 'w' || v == 'x' 
		|| v == 'y' || v == 'z' || v == 'B' || v == 'C' || v == 'D' 
		|| v == 'F' || v == 'G' || v == 'H' || v == 'J' || v == 'K' 
		|| v == 'L' || v == 'M' || v == 'N' || v == 'P' || v == 'Q' 
		|| v == 'R' || v == 'S' || v == 'T' || v == 'V' || v == 'W' 
		|| v == 'X' || v == 'Y' || v == 'Z'){
			System.out.println("El caracter es una consonante " + v);
		
		} else {
			System.out.println("el caracter es otro tipo de caracter " + v);
		}

	}

	public static void main(String[] args){
		
		vocal(args);
	}

}