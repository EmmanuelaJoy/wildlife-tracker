package dao;

import models.Common_Animal;
import org.sql2o.*;
import org.junit.*;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oAnimalDaoTest {

    private static Sql2oAnimalDao animalDao;
    private static Connection connection;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
        Sql2o sql2o = new Sql2o(connectionString, "emmanuela", "adminPass");
        animalDao = new Sql2oAnimalDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        animalDao.clearAllAnimals();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        connection.close();
        System.out.println("connection closed");
    }

    @Test
    public void animalIdIsSetCorrectly() throws Exception{
        Common_Animal common_animal = newCommonAnimal();
        int commonAnimalId = common_animal.getId();
        animalDao.add(common_animal);
        assertNotEquals(commonAnimalId, common_animal.getId());
    }

    @Test
    public void existingAnimalsCanBeFoundById() throws Exception{
        Common_Animal common_animal = newCommonAnimal();
        animalDao.add(common_animal);
        Common_Animal foundCommonAnimal = animalDao.findById(common_animal.getId());
        assertEquals(common_animal, foundCommonAnimal);
    }

    @Test
    public void getsAllAnimals() throws Exception{
        Common_Animal common_animal = newCommonAnimal();
        Common_Animal common_animal1 = new Common_Animal("common", "Deer", "young");
        Common_Animal common_animal2 = new Common_Animal("common", "Gazelle", "adult");
        animalDao.add(common_animal);
        animalDao.add(common_animal1);
        animalDao.add(common_animal2);
        assertEquals(3, animalDao.getAll().size());
    }

    @Test
    public void noTasksReturnsEmptyList() throws Exception {
        assertEquals(0, animalDao.getAll().size());
    }

    @Test
    public void updateAnimal() throws Exception {
        String initialName = "Zebra";
        String initialAge = "young";
        Common_Animal common_animal = newCommonAnimal();
        animalDao.add(common_animal);
        animalDao.update(common_animal.getId(),"common", "Elephant", "old");
        Common_Animal updatedCommonAnimal = animalDao.findById(common_animal.getId());
        assertNotEquals(initialName, updatedCommonAnimal.getName());
        assertNotEquals(initialAge, updatedCommonAnimal.getAge());
    }

    @Test
    public void deleteByIdDeletesCorrectAnimal() throws Exception {
        Common_Animal common_animal = newCommonAnimal();
        animalDao.add(common_animal);
        animalDao.deleteById(common_animal.getId());
        assertEquals(0, animalDao.getAll().size());
    }

    @Test
    public void clearAllClearsAll() throws Exception {
        Common_Animal common_animal = newCommonAnimal();
        Common_Animal common_animal1 = new Common_Animal("common", "Rhino", "newborn");
        animalDao.add(common_animal);
        animalDao.add(common_animal1);
        int daoSize = animalDao.getAll().size();
        animalDao.clearAllAnimals();
        assertTrue(daoSize > 0 && daoSize > animalDao.getAll().size());
    }

    private Common_Animal newCommonAnimal() {
        return new Common_Animal("common", "Zebra", "young");
    }
}