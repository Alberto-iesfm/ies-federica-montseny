package org.iesfm.library;

import org.iesfm.library.exceptions.BookNotFoundException;
import org.iesfm.library.exceptions.MemberNotFoundException;

public interface ILibrary {

    void infoBooks();

    void infoBooks(String askGenre);

    void infobook(int isbn) throws BookNotFoundException;

    void infoMembers();

    void infoMembers(int postCode);

    void memberInfo(String nif) throws MemberNotFoundException;

    void infoMemberLoans(String nif);

    void infoMemberLoans(int numberMember);

    boolean memberHasLoan(int numberMember, int isbn);
}
