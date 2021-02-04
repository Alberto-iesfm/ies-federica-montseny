package org.iesfm.bank;

import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    static Account createAccount(){
        System.out.println("Introduzca los 16 digitos del numero de la cuenta...");
        scan.nextLine();
        String number = scan.nextLine();
        while (number.length() != 16){
            System.out.println("La cuenta tiene que tener 16 digitos. Por favor introduzca los 16 digitos del numero de cuenta....");
            number = scan.nextLine();
        }
        System.out.println("Introduzca el saldo de la cuenta en €....");
        double balance = scan.nextDouble();
        while (balance < 0){
            System.out.println("El saldo no puede ser negativo. Por favor introduzca el saldo de la cuenta en €....");
            scan.nextLine();
            balance = scan.nextDouble();
        }
        return new Account(number, balance);
    }

    static Account[] createAccounts(){
        System.out.println("Introduzca el numero de cuentas que posee el cliente....");
        int amount = scan.nextInt();
        while (amount < 1){
            System.out.println("El cliente debe tener al menos una cuenta. Por favor introduzca el numero de cuentas que posee el cliente....");
            amount = scan.nextInt();
        }
        Account[] accounts = new Account[amount];
        for (int i = 0; i < amount; i++) {
            accounts[i] = createAccount();
        }
        return accounts;
    }

    static Customer createCustomer(){
        System.out.println("Introduzca el nombre del cliente....");
        scan.nextLine();
        String name = scan.nextLine();
        System.out.println("Introduzca el primer apellido del cliente....");
        String surname1 = scan.nextLine();
        System.out.println("Introduzca el segundo apellido del cliente....");
        String surname2 = scan.nextLine();
        System.out.println("Introduzca el NIF del cliente....");
        String nif = scan.nextLine();
        return new Customer(name, surname1, surname2, nif, createAccounts());
    }

    static Customer[] createCustomers(){
        System.out.println("Introduzca el numero de clientes que tiene el banco....");
        int amount = scan.nextInt();
        while (amount < 1){
            System.out.println("El banco debe tener al menos un cliente. Por favor introduzca el numero de clientes que tiene el banco....");
            amount = scan.nextInt();
        }
        Customer[] customers = new Customer[amount];
        for (int i = 0; i < amount; i++) {
            customers[i] = createCustomer();
        }
        return customers;
    }

    static Bank createBank(){
        System.out.println("Introduzca el nombre del banco....");
        String name = scan.nextLine();
        return new Bank(name, createCustomers());
    }

    static void menu(){
        System.out.println("Seleccione la accion que desea realizar:");
        System.out.println("1) Imprimir la informacion de los clientes.");
        System.out.println("2) Imprimir la informacion de las cuentas de un cliente.");
        System.out.println("3) Imprimir la informacion de una cuenta de un cliente.");
        System.out.println("4) Depositar dinero en la cuenta de un cliente.");
        System.out.println("5) Retirar dinero de la cuenta de un cliente.");
        System.out.println("6) Traspasar dinero entre las cuentas de un cliente.");
        System.out.println("7) Transferir dinero entre las cuentas de dos clientes.");
        System.out.println("8) Imprimir los datos del cliente de una cuenta.");
        System.out.println("9) Transferir dinero entre dos numeros cuentas.");
        System.out.println("0) Salir.");
    }

    static String getOriginNif(){
        System.out.println("Indique el NIF del cliente de origen sobre el que desea operar...");
        return scan.nextLine();
    }

    static String getOriginAccount(){
        System.out.println("Indique el numero de cuenta de origen sobre la que desea operar...");
        return scan.nextLine();
    }

    static double getAmount (){
        System.out.println("Indique la cantidad de dinero en € con la que desea operar...");
        return scan.nextInt();
    }

    static String getDestinationAccount(){
        System.out.println("Indique el numero de cuenta de destino sobre la que desea operar...");
        return scan.nextLine();
    }

    static String getDestinationNif(){
        System.out.println("Indique el NIF del cliente de destino sobre el que desea operar...");
        return scan.nextLine();
    }

    public static void main(String[] args) {
        Banco bank = createBank();
        boolean exit = false;
        while (!exit){
            bank.nameBank();
            menu();
            int operation = scan.nextInt();
            scan.nextLine();
            if (operation == 1){
                bank.infoCustomers();
            } else if (operation == 2){
                bank.infoAccounts(getOriginNif());
            } else if (operation == 3){
                bank.infoAccount(getOriginNif(), getOriginAccount());
            } else if (operation == 4){
                bank.depositBalance(getOriginNif(), getOriginAccount(), getAmount());
            } else if (operation == 5){
                bank.takeBalance(getOriginNif(), getOriginAccount(), getAmount());
            } else if (operation == 6){
                bank.transfer(getOriginNif(), getOriginAccount(), getDestinationAccount(), getAmount());
            } else if (operation == 7){
                bank.transferCustomers(getOriginNif(), getOriginAccount(), getDestinationNif(), getDestinationAccount(), getAmount());
            } else if (operation == 8){
                bank.customerByAccount(getOriginAccount());
            } else if (operation == 9){
                bank.transferByAccount(getOriginAccount(), getDestinationAccount(), getAmount());
            } else if (operation == 0){
                exit = true;
            } else {
                System.out.println("¡Operacion invalida!");
            }
        }
    }
}