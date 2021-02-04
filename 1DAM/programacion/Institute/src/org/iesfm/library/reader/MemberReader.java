package org.iesfm.library.reader;


import org.iesfm.library.Member;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberReader {

    private Scanner scan = new Scanner(System.in);

    private int readNumbers() {
        Integer number = null;
        while (number == null || number < 0){
            try{
                number = scan.nextInt();
                if (number < 0){
                    System.err.println("¡ERROR! El valor no puede ser menor que 0");
                }
            } catch (InputMismatchException e){
                System.err.println("¡ERROR! El valor debe ser un numero...");
            }
            scan.nextLine();
        }
        return number;
    }

    public Member readMember(){
        System.out.println("Introduzca los datos del miembro:");
        System.out.println("NIF....");
        String nif = scan.nextLine();
        System.out.println("Nombre....");
        String name = scan.nextLine();
        System.out.println("Apellidos....");
        String surnames = scan.nextLine();
        System.out.println("Numero de miembro....");
        int numberMember = readNumbers();
        System.out.println("Codigo postal...");
        int postCode = readNumbers();
        return new Member(nif, name, surnames, numberMember, postCode);
    }
}
