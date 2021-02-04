package org.iesfm.bank;

import java.util.Arrays;
import java.util.Objects;

public class Customer {
    private String name;
    private String surname1;
    private String surname2;
    private String nif;
    private Account[] accounts;

    public Customer(String name, String surname1, String surname2, String nif, Account[] accounts) {
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.nif = nif;
        this.accounts = accounts;
    }

    void info() {
        System.out.println("Nombre: " + name + " Apellidos: " + surname1 + " " + surname2 + " NIF: " + nif);
    }

    void infoAccounts() {
        for (Account account : accounts) {
            account.info();
        }
    }

    public Account searchAccount(String number) {
        Account account = null;
        for (Account acco : accounts) {
            if (acco.getNumber().equals(number)) {
                account = acco;
            }
        }
        return account;
    }

    public void infoAccount(String number) {
        Account account = searchAccount(number);
        if (account != null){
            info();
            account.info();
        } else {
            System.out.println("¡La cuenta no existe!");
        }
    }

    public void deposit(String number, double amount) {
        Account account = searchAccount(number);
        if (account != null){
            account.deposit(amount);
        } else {
            System.out.println("¡La cuenta no existe!");
        }
    }

    public void take(String number, double amount) {
        Account account = searchAccount(number);
        if (account != null){
            account.take(amount);
        } else {
            System.out.println("¡La cuenta no existe!");
        }
    }

    public void transfer(String originAccount, String destinationAccount, double amount) {
        Account origin = searchAccount(originAccount);
        Account destination = searchAccount(destinationAccount);
        if (origin == null){
            System.out.println("¡La cuenta de origen no existe!");
        } else if (destination == null){
            System.out.println("¡La cuenta de destino no existe!");
        } else {
            if (origin.enoughtBalance(amount)) {
                System.out.println("Transferencia realizada con exito");
                origin.take(amount);
                destination.deposit(amount);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname1() {
        return surname1;
    }

    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public void setSurname2(String surname2) {
        this.surname2 = surname2;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer client = (Customer) o;
        return Objects.equals(name, client.name) && Objects.equals(surname1, client.surname1) && Objects.equals(surname2, client.surname2) && Objects.equals(nif, client.nif) && Arrays.equals(accounts, client.accounts);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, surname1, surname2, nif);
        result = 31 * result + Arrays.hashCode(accounts);
        return result;
    }
}
