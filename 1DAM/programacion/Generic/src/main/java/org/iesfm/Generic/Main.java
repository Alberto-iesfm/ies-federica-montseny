package org.iesfm.Generic;

import org.iesfm.Generic.Deserializer.Deserializer;
import org.iesfm.Generic.Serializer.AnimalSerializer;
import org.iesfm.Generic.Serializer.Serializer;
import org.iesfm.Generic.Serializer.UserSerializer;

public class Main{

    public static void main(String[] args){
        Serializer<User> userSerializer = new UserSerializer();
        Serializer<Animal> animalSerializer = new AnimalSerializer();
        Deserializer<Animal> animalDeserializer = new AnimalSerializer();
        Deserializer<User> userDeserializer = new UserSerializer();

        User user1 = new User("Pedro", "5641651werew", "empleado");
        Animal animal1 = new Animal("verde", 3, "serpiente");
        User user2 = new User("Pepe", "dewfjff44ewf", "jefe");
        Animal animal2 = new Animal("marron", 7, "perro");

        System.out.println(userSerializer.serialString(user1));
        System.out.println(userSerializer.serialString(user2));
        System.out.println(animalSerializer.serialString(animal1));
        System.out.println(animalSerializer.serialString(animal2));

        String animal = animalSerializer.serialString(animal1);

        Animal animaldeserializer = animalDeserializer.deserialString(animal);

        System.out.println(animaldeserializer.toString());

        String user = userSerializer.serialString(user1);

        User userdeseializer = userDeserializer.deserialString(user);

        System.out.println(userdeseializer.toString());

    }
}
