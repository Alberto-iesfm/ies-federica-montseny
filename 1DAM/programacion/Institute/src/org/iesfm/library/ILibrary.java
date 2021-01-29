package org.iesfm.library;

public interface ILibrary {

    void infoBooks();

    void infoBooks(String askGenre);

    void infoMembers();

    void infoMembers(int postCode);

    void infoMemberLoans(String nif);

    void infoMemberLoans(int numberMember);

    boolean memberHasLoan(int numberMember, int isbn);
}
