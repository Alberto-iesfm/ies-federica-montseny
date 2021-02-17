package org.iesfm.zoo;

import org.iesfm.zoo.exceptions.CageNotExistsException;
import org.iesfm.zoo.exceptions.FeedingNotFoundException;

public interface IZoo{

    /** Devuelve el numero de animales que existen en una jaula dada.
     *
     * @param cage numero de jaula de la que se quiere conocer el numero de animales.
     * @return numero de animales que contiene dicha jaula.
     * @throws CageNotExistsException si la jaula no existe (no la tiene ningun animal asignada).
     */
    int numAnimalsByCage(int cage) throws CageNotExistsException;

    /** Devuelve el numero de animales que tienen una determinada alimentacion (hervivoro, omnivoro o carnivoro).
     *
     * @param feeding tipo de alimentacion de la que se quiere conocer el numero de animales (hervivoro, omnivoro o carnivoro).
     * @return numero de animales que poseen la alimentacion dada.
     * @throws FeedingNotFoundException si la alimentacion proporcionada no es ni carnivoro ni omnivoro ni hervivoro.
     */
    int numAnimalsByFeeding (String feeding) throws FeedingNotFoundException;

    /** Devuelve el numero de animales que existen en una jaula de una determinada especie.
     *
     * @param cage numero de jaula en la que se desea buscar.
     * @param species especie que se desea buscar en la jaula.
     * @return numero de animales de la especie determinada que se encuentran en la jaula dada.
     * @throws CageNotExistsException si la jaula no existe (no la tiene ningun animal asignada).
     */
    int numAnimalsByCageAndSpecies (int cage, String species) throws CageNotExistsException;
}
