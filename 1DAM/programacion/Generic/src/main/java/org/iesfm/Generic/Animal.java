package org.iesfm.Generic;

import java.util.Objects;

public class Animal{
    private String color;
    private int age;
    private String specie;

    public Animal(String color, int age, String specie) {
        this.color = color;
        this.age = age;
        this.specie = specie;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && Objects.equals(color, animal.color) && Objects.equals(specie, animal.specie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, age, specie);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "color='" + color + '\'' +
                ", age=" + age +
                ", specie='" + specie + '\'' +
                '}';
    }
}
