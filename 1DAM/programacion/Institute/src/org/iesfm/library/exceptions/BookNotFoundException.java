package org.iesfm.library.exceptions;

import java.util.Objects;

public class BookNotFoundException extends Exception {

    private int isbn;

    public BookNotFoundException(int isbn) {
        this.isbn = isbn;
    }

    public int getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookNotFoundException that = (BookNotFoundException) o;
        return isbn == that.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
