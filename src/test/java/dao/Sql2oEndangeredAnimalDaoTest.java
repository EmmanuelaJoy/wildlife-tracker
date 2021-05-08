package dao;

import models.Endangered_Animal;
import org.sql2o.*;
import org.junit.*;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oEndangeredAnimalDaoTest {

    private static Sql2oEndangeredAnimalDao endangeredAnimalDao;
    private static Connection connection;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
        Sql2o sql2o = new Sql2o(connectionString, "emmanuela", "adminPass");
        endangeredAnimalDao = new Sql2oEndangeredAnimalDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        endangeredAnimalDao.clearAllEndangeredAnimals();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        connection.close();
        System.out.println("connection closed");
    }

    @Test
    public void endangeredAnimalIdIsSetCorrectly() throws Exception{
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        int endangeredAnimalId = endangered_animal.getId();
        endangeredAnimalDao.add(endangered_animal);
        assertNotEquals(endangeredAnimalId, endangered_animal.getId());
    }

    @Test
    public void existingEndangeredAnimalsCanBeFoundById() throws Exception{
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        endangeredAnimalDao.add(endangered_animal);
        Endangered_Animal foundEndangeredAnimal = endangeredAnimalDao.findById(endangered_animal.getId());
        assertEquals(endangered_animal, foundEndangeredAnimal);
    }

    @Test
    public void getsAllAnimals() throws Exception{
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        Endangered_Animal endangered_animal1 = new Endangered_Animal("endangered", "Lion", "old", "sick");
        endangeredAnimalDao.add(endangered_animal);
        endangeredAnimalDao.add(endangered_animal1);
        assertEquals(2, endangeredAnimalDao.getAll().size());
    }

    @Test
    public void noTasksReturnsEmptyList() throws Exception {
        assertEquals(0, endangeredAnimalDao.getAll().size());
    }

    @Test
    public void update() throws Exception {
        String initialName = "Leopard";
        String initialAge = "old";
        String initialHealth = "okay";
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        endangeredAnimalDao.add(endangered_animal);
        endangeredAnimalDao.update(endangered_animal.getId(),"endangered", "Bear", "young", "healthy");
        Endangered_Animal updatedEndangeredAnimal = endangeredAnimalDao.findById(endangered_animal.getId());
        assertNotEquals(initialName, updatedEndangeredAnimal.getName());
        assertNotEquals(initialAge, updatedEndangeredAnimal.getAge());
        assertNotEquals(initialHealth, updatedEndangeredAnimal.getHealth_status());
    }

    @Test
    public void deleteByIdDeletesCorrectAnimal() throws Exception {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        endangeredAnimalDao.add(endangered_animal);
        endangeredAnimalDao.deleteById(endangered_animal.getId());
        assertEquals(0, endangeredAnimalDao.getAll().size());
    }

    @Test
    public void clearAllEndangeredAnimals() throws Exception {
        Endangered_Animal endangered_animal = newEndangeredAnimal();
        Endangered_Animal endangered_animal1 = new Endangered_Animal("endangered", "Tiger", "young", "healthy");
        endangeredAnimalDao.add(endangered_animal);
        endangeredAnimalDao.add(endangered_animal1);
        int daoSize = endangeredAnimalDao.getAll().size();
        endangeredAnimalDao.clearAllEndangeredAnimals();
        assertTrue(daoSize > 0 && daoSize > endangeredAnimalDao.getAll().size());
    }

    private Endangered_Animal newEndangeredAnimal(){
        return new Endangered_Animal("endangered", "Leopard", "old", "okay");
    }
}