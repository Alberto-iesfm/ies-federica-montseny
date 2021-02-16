package org.iesfm.zoo;

import org.iesfm.zoo.exceptions.CageNotExistsException;
import org.iesfm.zoo.exceptions.FeedingNotFoundException;

import java.util.Arrays;
import java.util.Objects;

public class Zoo implements IZoo{
    private String name;
    private Animal[] animals;

    public Zoo(String name, Animal[] animals) {
        this.name = name;
        this.animals = animals;
    }

    @Override
    public int numAnimalsByCage(int cage) throws CageNotExistsException {
        int numAnimals = 0;
        for (Animal animal:animals){
            if (animal.getCage() == cage){
                numAnimals++;
            }
        }
        if (numAnimals == 0) {
            throw new CageNotExistsException();
        }
        return numAnimals;
    }

    @Override
    public int numAnimalsByFeeding(String feeding) throws FeedingNotFoundException{
        int numAnimals = 0;
        if (!feeding.equals("Carnivoro") && !feeding.equals("Hervivoro") && !feeding.equals("Omnivoro")){
            throw new FeedingNotFoundException();
        } else {
            for (Animal animal:animals){
                if (animal.getFeeding().equals(feeding)){
                    numAnimals++;
                }
            }
        }
        return numAnimals;
    }

    @Override
    public int numAnimalsByCageAndSpecies(int cage, String species) throws CageNotExistsException{
        int numAnimals = 0;
        Animal[] cageAnimals = new Animal[numAnimalsByCage(cage)];
        int i = 0;
        for (Animal animal:animals){
            if (animal.getCage() == cage) {
                cageAnimals[i] = animal;
                i++;
            }
        }
        for (Animal animal:cageAnimals){
            if (animal.getSpecies().equals(species)){
                numAnimals++;
            }
        }
        return numAnimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    public void setAnimals(Animal[] animals) {
        this.animals = animals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Zoo zoo = (Zoo) o;
        return Objects.equals(name, zoo.name) && Arrays.equals(animals, zoo.animals);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(animals);
        return result;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", animals=" + Arrays.toString(animals) +
                '}';
    }
}
