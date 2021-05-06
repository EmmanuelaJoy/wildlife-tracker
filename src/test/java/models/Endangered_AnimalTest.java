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

    private Endangered_Animal newEndangeredAnimal(){
        return new Endangered_Animal("endangered", "rhino", "old", "okay");
    }
}