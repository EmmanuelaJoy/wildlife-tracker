package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Common_AnimalTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instantiatesCommonAnimalObjectsCorrectly_true() {
        Common_Animal common_animal = newCommonAnimal();
        assertTrue(common_animal instanceof Common_Animal);
    }

    @Test
    public void commonAnimalTypeReturnsCorrectly_int() {
        Common_Animal common_animal = newCommonAnimal();
        assertEquals("common", common_animal.getType());
    }

    @Test
    public void commonAnimalNameReturnsCorrectly_String() {
        Common_Animal common_animal = newCommonAnimal();
        assertEquals("zebra", common_animal.getName());
    }

    @Test
    public void commonAnimalAgeReturnsCorrectly_int() {
        Common_Animal common_animal = newCommonAnimal();
        assertEquals("young", common_animal.getAge());
    }

    private Common_Animal newCommonAnimal(){
        return new Common_Animal("common", "zebra", "young");
    }
}