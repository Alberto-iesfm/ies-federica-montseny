import java.util.Scanner;

public class SearchChar {

    static int charCount(String text, char caract){
        int count= 0;
        for (int i = 0; i < text.length(); i++){
            if (text.charAt(i) == caract){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args){
     Scanner scan = new Scanner(System.in);
     System.out.println("Introduzca un texto...");
     String text = scan.nextLine();
     System.out.println("Introduzca un caracter a buscar...");
     char caract = scan.next().charAt(0);
     System.out.println("El caracter " + caract + " aparece " + charCount(text,caract) + " veces");
    }
}
