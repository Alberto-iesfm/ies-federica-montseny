package org.iesfm.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static Scanner scan = new Scanner(System.in);

    static int getNumber() {
        Integer number = null;
        while (number == null) {
            try {
                number = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("¡ERROR!. Debe introducir un numero");
                scan.nextLine();
            }
        }
        return number;
    }

    static Employee getEmployee() {
        System.out.println("Introduzca el nif del empleado....");
        String nif = scan.nextLine();
        System.out.println("Introduzca el nombre del empleado....");
        String name = scan.nextLine();
        System.out.println("Introduzca los apellidos del empleado....");
        String surnames = scan.nextLine();
        System.out.println("Introduzca el puesto del empleado....");
        String position = scan.nextLine();
        System.out.println("Introduzca el codigo postal del empleado....");
        int cp = getNumber();
        return new Employee(nif, name, surnames, position, cp);
    }

    static Employee[] getEmployees() {
        Employee[] employees = null;
        while (employees == null) {
            try {
                System.out.println("Introduzca el numero de empleados...");
                int amount = getNumber();
                Employee[] result = new Employee[amount];
                for (int i = 0; i < amount; i++) {
                    result[i] = getEmployee();
                }
                employees = result;
            } catch (NegativeArraySizeException e) {
                System.out.println("¡ERROR!. El array no puede tener un tamaño negativo");
            }
        }
        return employees;
    }

    public static void main(String[] args) {
        Employee[] employees = getEmployees();
        for (Employee employee : employees) {
            employee.info();
        }
    }
}
