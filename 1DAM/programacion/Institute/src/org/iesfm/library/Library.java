package org.iesfm.library;

import java.util.Arrays;
import java.util.Objects;

public class Library implements ILibrary {
    private String name;
    private Book[] books;
    private Member[] members;
    private Loan[] loans;

    public Library(String name, Book[] books, Member[] members, Loan[] loans) {
        this.name = name;
        this.books = books;
        this.members = members;
        this.loans = loans;
    }

    @Override
    public void infoBooks() {
        System.out.println("Los libros disponibles en la biblioteca son:");
        for (Book book:books) {
            book.info();
        }
    }

    @Override
    public void infoBooks(String askGenre) {
        System.out.println("Los libros disponibles del genero " + askGenre + " son:");
        for (Book book:books) {
            if (book.searchByGenre(askGenre)){
                book.info();
            }
        }
    }

    @Override
    public void infoMembers() {
        System.out.println("Los miembros de la biblioteca son:");
        for (Member member:members) {
            member.info();
        }
    }

    @Override
    public void infoMembers(int postCode) {
        System.out.println("Los miembros con el codigo postal " + postCode + " son:");
        for (Member member:members) {
            if (member.getPostCode() == postCode){
                member.info();
            }
        }
    }

    @Override
    public void infoMemberLoans(String nif) {
    }

    @Override
    public void infoMemberLoans(int numberMember) {
    }

    @Override
    public boolean memberHasLoan(int numberMember, int isbn) {
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public Member[] getMembers() {
        return members;
    }

    public void setMembers(Member[] members) {
        this.members = members;
    }

    public Loan[] getLoans() {
        return loans;
    }

    public void setLoans(Loan[] loans) {
        this.loans = loans;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(name, library.name) && Arrays.equals(books, library.books) && Arrays.equals(members, library.members) && Arrays.equals(loans, library.loans);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(books);
        result = 31 * result + Arrays.hashCode(members);
        result = 31 * result + Arrays.hashCode(loans);
        return result;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", books=" + Arrays.toString(books) +
                ", members=" + Arrays.toString(members) +
                ", loans=" + Arrays.toString(loans) +
                '}';
    }
}
