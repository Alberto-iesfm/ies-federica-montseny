package org.iesfm.bank;

import java.util.Objects;

public class Account {
    private String number;
    private double balance;

    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    void info(){
        System.out.println("Numero de cuenta: " + number + " Saldo: " + balance + "€");
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Ha ingresado " + amount + " € en la cuenta " + number);
        System.out.println("Saldo total de la cuenta: " + balance + "€.");
    }

    public boolean enoughtBalance (double amount){
        return balance >= amount;
    }

    public void take(double amount) {
        if (!enoughtBalance(amount)){
            System.out.println("¡No se puede retirar/transferir una cantidad de dinero mayor que la disponible en la cuenta de origen!");
        } else {
            balance -= amount;
            System.out.println("Ha retirado " + amount + " € de la cuenta " + number);
            System.out.println("Saldo total de la cuenta: " + balance + "€.");
        }
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return number == account.number && Double.compare(account.balance, balance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, balance);
    }
}
