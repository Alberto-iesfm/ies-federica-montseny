package org.iesfm.library.reader;


import org.iesfm.library.Book;
import org.iesfm.library.Library;
import org.iesfm.library.Loan;
import org.iesfm.library.Member;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryReader {

    private Scanner scan = new Scanner(System.in);

    private BookReader bookReader = new BookReader();
    private LoanReader loanReader = new LoanReader();
    private MemberReader memberReader = new MemberReader();

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

    private Book[] readbooks() {
        System.out.println("Indique el numero de libros....");
        int numBooks = readNumbers();
        Book[] books = new Book[numBooks];
        for (int i = 0; i < numBooks; i++) {
            books[i] = bookReader.readBook();
        }
        return books;
    }

    private Member[] readMembers() {
        System.out.println("Indique el numero de miembros....");
        int numMembers = readNumbers();
        Member[] members = new Member[numMembers];
        for (int i = 0; i < numMembers; i++) {
            members[i] = memberReader.readMember();
        }
        return members;
    }

    private Loan[] readLoans() {
        System.out.println("Indique el numero de prestamos....");
        int numLoans = readNumbers();
        Loan[] loans = new Loan[numLoans];
        for (int i = 0; i < numLoans; i++) {
            loans[i] = loanReader.readLoan();
        }
        return loans;
    }

    public Library readLibrary(){
        System.out.println("Introduzca los datos de la biblioteca:");
        System.out.println("Nombre....");
        String name = scan.nextLine();
        Book[] books = readbooks();
        Member[] members = readMembers();
        Loan[] loans = readLoans();
        return new Library(name, books, members, loans);
    }
}
