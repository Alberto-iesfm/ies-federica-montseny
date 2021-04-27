package org.iesfm.Generic.Serializer;

import org.iesfm.Generic.Animal;
import org.iesfm.Generic.Deserializer.Deserializer;
import org.iesfm.Generic.Serializer.Serializer;

import java.util.HashMap;
import java.util.Map;

public class AnimalSerializer implements Serializer<Animal>, Deserializer<Animal> {
    @Override
    public String serialString(Animal animal) {
        return "color: " + animal.getColor() + ", ages: " + animal.getAge() + ", specie: " + animal.getSpecie();
    }

    @Override
    public Animal deserialString(String serial) {
        Map<String, String> fieldsMap = new HashMap<>();

        String[] fields = serial.split(", ");

        for (String field:fields){
            String[] fieldValues = field.split(": ");
            fieldsMap.put(fieldValues[0],fieldValues[1]);
        }
        return new Animal(fieldsMap.get("color"),Integer.parseInt(fieldsMap.get("ages")),fieldsMap.get("specie"));
    }
}
