package org.iesfm.library;

import org.iesfm.library.reader.LibraryReader;

public class Main {

    public static void main(String[] args) {
        LibraryReader libraryReader = new LibraryReader();
        Library library = libraryReader.readLibrary();
        library.infoBooks();
    }
}
