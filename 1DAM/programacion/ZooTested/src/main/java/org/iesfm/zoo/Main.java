package org.iesfm.zoo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        Integer numero = null;
        while (numero == null){
            try {
                numero = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("debe introducir un numero");
                scan.nextLine();
            }
        }

    }
}
