package org.iesfm.buiding;

import java.util.Objects;

public class Owner {
    private String name;
    private String surnames;

    public Owner(String name, String surnames) {
        this.name = name;
        this.surnames = surnames;
    }

    public void info() {
        System.out.println("Nombre: " + name + ". Apellidos: " + surnames);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return Objects.equals(name, owner.name) && Objects.equals(surnames, owner.surnames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surnames);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                '}';
    }
}
