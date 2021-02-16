package org.iesfm.zoo;

import org.iesfm.zoo.exceptions.CageNotExistsException;
import org.iesfm.zoo.exceptions.FeedingNotFoundException;

public interface IZoo{
    int numAnimalsByCage(int cage) throws CageNotExistsException;
    int numAnimalsByFeeding (String feeding) throws FeedingNotFoundException;
    int numAnimalsByCageAndSpecies (int cage, String species) throws CageNotExistsException;
}
