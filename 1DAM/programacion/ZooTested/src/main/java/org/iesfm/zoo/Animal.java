package org.iesfm.zoo;

import java.util.Objects;

public class Animal {
    private String species;
    private String feeding;
    private int cage;

    public Animal(String species, String feeding, int cage) {
        this.species = species;
        this.feeding = feeding;
        this.cage = cage;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getFeeding() {
        return feeding;
    }

    public void setFeeding(String feeding) {
        this.feeding = feeding;
    }

    public int getCage() {
        return cage;
    }

    public void setCage(int cage) {
        this.cage = cage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return cage == animal.cage && Objects.equals(species, animal.species) && Objects.equals(feeding, animal.feeding);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, feeding, cage);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", feeding='" + feeding + '\'' +
                ", cage=" + cage +
                '}';
    }
}