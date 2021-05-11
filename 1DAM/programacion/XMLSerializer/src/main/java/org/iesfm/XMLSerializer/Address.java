package org.iesfm.XMLSerializer;

import org.iesfm.XMLSerializer.serializer.XMLSerializer;

import java.util.Objects;

public class Address{
    private String street;
    private int number;
    private String door;
    private String city;

    public Address(String street, int number, String door, String city) {
        this.street = street;
        this.number = number;
        this.door = door;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return number == address.number && Objects.equals(street, address.street) && Objects.equals(door, address.door) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, door, city);
    }

    @Override
    public String toString() {
        return "org.iesfm.org.iesfm.XMLSerializer.serializer.XMLSerializer.Address{" +
                "street='" + street + '\'' +
                ", number=" + number +
                ", door='" + door + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
