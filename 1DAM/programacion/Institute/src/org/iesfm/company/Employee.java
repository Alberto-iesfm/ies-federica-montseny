package org.iesfm.company;

import java.util.Objects;

public class Employee {

    private String nif;
    private String name;
    private String surnames;
    private String position;

    public static final String ROLE_DIRECTOR = "director";

    public Employee(String nif, String name, String surnames, String position) {
        this.nif = nif;
        this.name = name;
        this.surnames = surnames;
        this.position = position;
    }

    public void info(){
        System.out.println("nombre: " + name + " apellidos: " + surnames + " con nif: " + nif + " y posicion: " + position);
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(nif, employee.nif) && Objects.equals(name, employee.name) && Objects.equals(surnames, employee.surnames) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surnames, position);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
