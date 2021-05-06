package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Endangered_AnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Endangered_Animal.clearAllEndangeredAnimals();
    }

    @Test
    public void endangeredAnimalObjectsInstantiateCorrectly_true() {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        assertTrue(endangered_animal instanceof Endangered_Animal);
    }

    @Test
    public void endangeredAnimalIdReturnsCorrectly_int() {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        assertEquals(1, endangered_animal.getId());
    }

    @Test
    public void endangeredAnimalTypeReturnsCorrectly_String() {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        assertEquals("endangered", endangered_animal.getType());
    }


    @Test
    public void endangeredAnimalNameReturnsCorrectly_String() {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        assertEquals("rhino", endangered_animal.getName());
    }

    @Test
    public void endangeredAnimalAgeReturnsCorrectly_String() {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        assertEquals("old", endangered_animal.getAge());
    }

    @Test
    public void endangeredAnimalHealthStatusReturnsCorrectly_int() {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        assertEquals("okay", endangered_animal.getHealth_status());
    }

    @Test
    public void allEndangeredAnimalsContainsAllEndangeredAnimalObjects_true() {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        Endangered_Animal endangered_animal1 = newEndangeredAnimal();
        assertTrue(Endangered_Animal.getEndangered_animals().contains(endangered_animal));
        assertTrue(Endangered_Animal.getEndangered_animals().contains(endangered_animal1));
    }

    @Test
    public void endangeredAnimalObjectsAreDeletedCorrectly_True() {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        Endangered_Animal endangered_animal1 = newEndangeredAnimal();
        Endangered_Animal.clearAllEndangeredAnimals();
        assertEquals(0, Endangered_Animal.getEndangered_animals().size());
    }

    private Endangered_Animal newEndangeredAnimal(){
        return new Endangered_Animal("endangered", "rhino", "old", "okay");
    }
}