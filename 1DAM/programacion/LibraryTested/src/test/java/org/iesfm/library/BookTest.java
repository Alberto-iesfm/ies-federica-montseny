package org.iesfm.library;

import org.junit.Assert;
import org.junit.Test;

public class BookTest {

    @Test
    public void hasGenreTest(){
        String[] genres = new String[2];
        genres[0] = "terror";
        genres[1] = "drama";
        Book book = new Book(1, "titulo", "autor", genres);

        Assert.assertTrue(book.hasGenre("terror"));
    }

    @Test
    public void notHasGenreTest(){
        String[] genres = new String[2];
        genres[0] = "terror";
        genres[1] = "drama";
        Book book = new Book(1, "titulo", "autor", genres);

        Assert.assertFalse(book.hasGenre("historia"));
    }
}
