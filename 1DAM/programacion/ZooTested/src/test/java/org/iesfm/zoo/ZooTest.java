package org.iesfm.zoo;

import org.iesfm.zoo.exceptions.CageNotExistsException;
import org.iesfm.zoo.exceptions.FeedingNotFoundException;
import org.junit.Assert;
import org.junit.Test;

public class ZooTest {

    Animal animal1 = new Animal("Tigre", "Carnivoro", 1);
    Animal animal2 = new Animal("Cabra", "Hervivoro", 2);
    Animal animal3 = new Animal("Tigre Blanco", "Carnivoro", 1);
    Animal[] animals = {animal1, animal2, animal3};

    Zoo zoo = new Zoo("Test", animals);

    @Test
    public void numAnimalsInCageTest () throws CageNotExistsException{

        int result = zoo.numAnimalsByCage(1);

        Assert.assertEquals(2, result);
    }

    @Test (expected = CageNotExistsException.class)
    public void numAnimalsIfCageNotExistsTest () throws CageNotExistsException{

        zoo.numAnimalsByCage(50);
    }

    @Test
    public void numAnimalsByFeedingTest () throws FeedingNotFoundException{

        int result = zoo.numAnimalsByFeeding("Carnivoro");

        Assert.assertEquals(2, result);
    }

    @Test (expected = FeedingNotFoundException.class)
    public void numAnimalsIfFeedingNotExistsTest () throws FeedingNotFoundException{

        zoo.numAnimalsByFeeding("Otro");
    }

    @Test
    public void numAnimalsByCageAndSpeciesTest () throws CageNotExistsException{

        int result = zoo.numAnimalsByCageAndSpecies(1, "Tigre");

        Assert.assertEquals(1, result);
    }

    @Test (expected = CageNotExistsException.class)
    public void numAnimalsByCageAndSpeciesIfCageNotExistTest () throws CageNotExistsException {

        zoo.numAnimalsByCageAndSpecies( 50, "Tigre");
    }
}
