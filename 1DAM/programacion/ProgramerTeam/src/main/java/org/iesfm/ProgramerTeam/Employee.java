package org.iesfm.ProgramerTeam;

import java.util.Objects;

public abstract class Employee {
    private int idEmployee;
    private String name;
    private int workedHours;

    public Employee(int idEmployee, String name, int workedHours) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.workedHours = workedHours;
    }

    public final void logWork (int hours){
        workedHours += hours;
    }

    protected abstract void infoEmployee();

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return idEmployee == employee.idEmployee && workedHours == employee.workedHours && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployee, name, workedHours);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + idEmployee +
                ", name='" + name + '\'' +
                ", workedHours=" + workedHours +
                '}';
    }
}
