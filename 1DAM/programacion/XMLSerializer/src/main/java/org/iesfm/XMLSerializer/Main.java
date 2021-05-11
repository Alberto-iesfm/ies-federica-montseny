package org.iesfm.XMLSerializer;

import org.iesfm.XMLSerializer.serializer.AddressSerializer;
import org.iesfm.XMLSerializer.serializer.DogSerializer;
import org.iesfm.XMLSerializer.serializer.XMLSerializer;

public class Main {

    public static void main(String[] args) {
        DogSerializer dogSerializer = new DogSerializer();
        Dog dog = new Dog("perro", 5, "marron");
        AddressSerializer addressSerializer = new AddressSerializer();
        Address address = new Address("calle 1", 35, "D", "Madrid");


        System.out.println(dogSerializer.toXml(dog));
        System.out.println(addressSerializer.toXml(address));
    }
}
