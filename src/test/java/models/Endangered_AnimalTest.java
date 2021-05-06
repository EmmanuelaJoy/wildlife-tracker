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
    }

    @Test
    public void endangeredAnimalObjectsInstantiateCorrectly_true() {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        assertTrue(endangered_animal instanceof Endangered_Animal);
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

    private Endangered_Animal newEndangeredAnimal(){
        return new Endangered_Animal("endangered", "rhino", "old", "okay");
    }
}