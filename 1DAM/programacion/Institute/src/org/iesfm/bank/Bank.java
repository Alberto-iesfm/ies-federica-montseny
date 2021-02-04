package org.iesfm.bank;

import java.util.Arrays;
import java.util.Objects;

public class Bank implements Banco {
    private String name;
    private Customer[] customers;

    public Bank(String name, Customer[] customers) {
        this.name = name;
        this.customers = customers;
    }

    @Override
    public void nameBank() {
        System.out.println(name);
    }

    @Override
    public void infoCustomers() {
        for (Customer customer : customers) {
            customer.info();
        }
    }

    public Customer searchCustomer(String nif) {
        Customer customer = null;
        for (Customer custom : customers) {
            if (custom.getNif().equals(nif)) {
                customer = custom;
            }
        }
        return customer;
    }

    @Override
    public void infoAccounts(String nif) {
        Customer customer = searchCustomer(nif);
        if (customer != null) {
            customer.info();
            customer.infoAccounts();
        } else {
            System.out.println("¡El cliente no existe!");
        }
    }

    @Override
    public void infoAccount(String nif, String number) {
        Customer customer = searchCustomer(nif);
        if (customer != null) {
            customer.infoAccount(number);
        } else {
            System.out.println("¡El cliente no existe!");
        }
    }

    @Override
    public void depositBalance(String nif, String number, double amount) {
        Customer customer = searchCustomer(nif);
        if (customer != null){
            customer.deposit(number, amount);
        } else {
            System.out.println("¡El cliente no existe!");
        }
    }

    @Override
    public void takeBalance(String nif, String number, double amount) {
        Customer customer = searchCustomer(nif);
        if (customer != null){
            customer.take(number, amount);
        } else {
            System.out.println("¡El cliente no existe!");
        }
    }

    @Override
    public void transfer(String nif, String originAccount, String destinationAccount, double amount) {
        Customer customer = searchCustomer(nif);
        if (customer != null){
            customer.transfer(originAccount, destinationAccount, amount);
        } else {
            System.out.println("¡El cliente no existe!");
        }
    }

    @Override
    public void transferCustomers(String originNif, String originAccount, String destinationNif, String destinationAccount, double amount) {
        Customer originCustomer = searchCustomer(originNif);
        Customer destinationCustomer = searchCustomer(destinationNif);
        if (originCustomer == null){
            System.out.println("¡No existe el cliente emisor!");
        } else if (destinationCustomer == null){
            System.out.println("¡No existe el cliente receptor!");
        } else {
            Account origin = originCustomer.searchAccount(originAccount);
            Account destination = destinationCustomer.searchAccount(destinationAccount);
            if (origin == null){
                System.out.println("¡No existe la cuenta emisora!");
            } else if (destination == null){
                System.out.println("¡No existe la cuenta destinataria!");
            } else {
                if (origin.enoughtBalance(amount)){
                    System.out.println("¡Transferencia realizada con exito!");
                    origin.take(amount);
                    destination.deposit(amount);
                } else {
                    System.out.println("¡No se puede transferir una cantidad de dinero mayor que la disponible en la cuenta de origen!");
                }
            }
        }
    }

    public Customer searchCustomerByAccount (String number){
        Customer customer = null;
        for (Customer custom:customers) {
            if (custom.searchAccount(number) != null) {
                customer = custom;
            }
        }
        return customer;
    }

    @Override
    public void customerByAccount(String number) {
        Customer customer = searchCustomerByAccount(number);
        if (customer != null){
            customer.info();
        } else {
            System.out.println("¡La cuenta no existe!");
        }
    }

    @Override
    public void transferByAccount(String originAccount, String destinationAccount, double amount) {
        Customer originCustomer = searchCustomerByAccount(originAccount);
        Customer destinationCustomer = searchCustomerByAccount(destinationAccount);
        if (originCustomer == null){
            System.out.println("¡No existe la cuenta emisora!");
        } else if (destinationCustomer == null){
            System.out.println("¡No existe la cuenta destinataria!");
        } else {
            Account origin = originCustomer.searchAccount(originAccount);
            Account destination = destinationCustomer.searchAccount(destinationAccount);
            if (origin.enoughtBalance(amount)){
                System.out.println("Transferencia realizada con exito!");
                origin.take(amount);
                destination.deposit(amount);
            } else {
                System.out.println("¡No se puede transferir una cantidad de dinero mayor que la disponible en la cuenta de origen!");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Arrays.equals(customers, bank.customers);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(customers);
        return result;
    }
}
