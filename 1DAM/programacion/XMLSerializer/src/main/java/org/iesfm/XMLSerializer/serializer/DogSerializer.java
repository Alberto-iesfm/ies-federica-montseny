package org.iesfm.XMLSerializer.serializer;

import org.iesfm.XMLSerializer.Dog;

public class DogSerializer implements XMLSerializer<Dog>{

    @Override
    public String toXml(Dog dog) {
        String name = "<name>" + dog.getName() + "</name>";
        String age = "<age>" + dog.getAge() + "</age>";
        String color = "<color>" + dog.getColor() + "</color>";
        return "<Dog>" + name + age + color + "</Dog>";
    }
}
