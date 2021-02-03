package org.iesfm.library.reader;

import org.iesfm.library.Book;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookReader {

    private Scanner scan = new Scanner(System.in);

    private int readNumbers() {
        Integer number = null;
        while (number == null || number < 0){
            try{
                number = scan.nextInt();
                scan.nextLine();
                if (number < 0){
                    System.err.println("¡ERROR! El valor no puede ser menor que 0");
                }
            } catch (InputMismatchException e){
                System.err.println("¡ERROR! El valor debe ser un numero...");
            }
        }
        return number;
    }

    private String[] readGenres() {
        System.out.println("Indique el numero de generos....");
        int numGenres = readNumbers();
        String[] genres = new String[numGenres];
        for (int i = 0; i < numGenres; i++) {
            genres[i] = scan.nextLine();
        }
        return genres;
    }

    public Book readBook(){
        System.out.println("Introduzca los datos del libro:");
        System.out.println("ISBN....");
        int isbn = readNumbers();
        System.out.println("Titulo....");
        String title = scan.nextLine();
        System.out.println("Autor....");
        String author = scan.nextLine();
        System.out.println("Generos....");
        String[] genres = readGenres();
        return new Book(isbn, title, author, genres);
    }
}
