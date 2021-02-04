package org.iesfm.library.reader;

import org.iesfm.library.Loan;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LoanReader {

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

    public Loan readLoan(){
        System.out.println("Introduzca los datos del prestamo:");
        System.out.println("ISBN....");
        int isbn = readNumbers();
        System.out.println("Fecha del prestamo....");
        String dateLoan = scan.nextLine();
        System.out.println("NIF del miembro....");
        String nifMember = scan.nextLine();
        System.out.println("Fecha de la devolucion....");
        String dateReturn = scan.nextLine();
        return new Loan(isbn, dateLoan, nifMember, dateReturn);
    }
}
