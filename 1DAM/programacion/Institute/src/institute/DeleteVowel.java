import java.util.Scanner;

public class DeleteVowel {
    static String removeVowel(String text){
        String newText = "";
        for(int i = 0; i < text.length(); i++ ){
            if (text.charAt(i) != 'a' && text.charAt(i) != 'e' && text.charAt(i) != 'i' && text.charAt(i) != 'o' && text.charAt(i) != 'u'){
               newText = newText + text.charAt(i);
            }
        }
        return newText;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Introduzca un texto....");
        String text = scan.nextLine();
        System.out.println(removeVowel(text));
    }
}
