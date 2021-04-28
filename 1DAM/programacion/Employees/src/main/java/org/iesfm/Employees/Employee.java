package org.iesfm.Employees;

import java.util.Objects;

public class Employee {

    private int idEmployee;
    private String nameAndSurnames;
    private double workedHours;
    private String role;

    public Employee(int idEmployee, String nameAndSurnames, double workedHours, String role) {
        this.idEmployee = idEmployee;
        this.nameAndSurnames = nameAndSurnames;
        this.workedHours = workedHours;
        this.role = role;
    }

    public void info(){
        System.out.println(toString());
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getNameAndSurnames() {
        return nameAndSurnames;
    }

    public void setNameAndSurnames(String nameAndSurnames) {
        this.nameAndSurnames = nameAndSurnames;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return idEmployee == employee.idEmployee && Double.compare(employee.workedHours, workedHours) == 0 && Objects.equals(nameAndSurnames, employee.nameAndSurnames) && Objects.equals(role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployee, nameAndSurnames, workedHours, role);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", nameAndSurnames='" + nameAndSurnames + '\'' +
                ", workedHours=" + workedHours +
                ", role='" + role + '\'' +
                '}';
    }
}
