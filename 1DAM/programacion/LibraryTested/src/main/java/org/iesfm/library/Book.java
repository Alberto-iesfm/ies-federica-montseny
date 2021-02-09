package org.iesfm.library;

import java.util.Arrays;
import java.util.Objects;

public class Book {
    private int isbn;
    private String title;
    private String author;
    private String[] genres;

    public Book(int isbn, String title, String author, String[] genres) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genres = genres;
    }

    public boolean hasGenre(String askGenre) {
        boolean found = false;
        for (String genre:genres) {
            if (genre.equals(askGenre)){
                found = true;
            }
        }
        return found;
    }

    public void printGenres(){
        for (String genre:genres) {
            System.out.print(" " + genre);
        }
    }

    public void info() {
        System.out.print("ISBN: " + isbn + ". Titulo: " + title + ". Autor: " + author + ". Generos:");
        printGenres();
        System.out.println();
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn == book.isbn && Objects.equals(title, book.title) && Objects.equals(author, book.author) && Arrays.equals(genres, book.genres);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(isbn, title, author);
        result = 31 * result + Arrays.hashCode(genres);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genres=" + Arrays.toString(genres) +
                '}';
    }
}
