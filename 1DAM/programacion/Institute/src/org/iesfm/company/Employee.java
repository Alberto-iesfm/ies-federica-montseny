package org.iesfm.company;

import java.util.Objects;

public class Employee {

    private String nif;
    private String name;
    private String surnames;
    private String position;
    private int cp;

    public static final String ROLE_DIRECTOR = "director";

    public Employee(String nif, String name, String surnames, String position, int cp) {
        this.nif = nif;
        this.name = name;
        this.surnames = surnames;
        this.position = position;
        this.cp = cp;
    }

    public void info(){
        System.out.println("nombre: " + name + " apellidos: " + surnames + " con nif: " + nif + " y posicion: " + position + " y codigo postal: " + cp);
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

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return cp == employee.cp && Objects.equals(nif, employee.nif) && Objects.equals(name, employee.name) && Objects.equals(surnames, employee.surnames) && Objects.equals(position, employee.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, surnames, position, cp);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", position='" + position + '\'' +
                ", cp=" + cp +
                '}';
    }
}
