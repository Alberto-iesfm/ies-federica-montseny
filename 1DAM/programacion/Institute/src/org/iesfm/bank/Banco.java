package org.iesfm.bank;

public interface Banco {
    void nameBank();
    void infoCustomers();
    void infoAccounts(String nif);
    void infoAccount(String nif, String number);
    void depositBalance(String nif, String number, double amount);
    void takeBalance(String nif, String number, double amount);
    void transfer (String nif, String originAccount, String destinationAccount, double amount);
    void transferCustomers(String originNif, String originAccount, String destinationNif, String destinationAccount, double amount);
    void customerByAccount(String number);
    void transferByAccount(String originAccount, String destinationAccount, double amount);
}
