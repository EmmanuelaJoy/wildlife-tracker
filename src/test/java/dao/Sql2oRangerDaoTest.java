package dao;

import models.Ranger;
import org.sql2o.*;
import org.junit.*;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oRangerDaoTest {

    private static Sql2oRangerDao rangerDao;
    private static Connection connection;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
        Sql2o sql2o = new Sql2o(connectionString, "emmanuela", "adminPass");
        rangerDao = new Sql2oRangerDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        rangerDao.clearAllRangers();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        connection.close();
        System.out.println("connection closed");
    }

    @Test
    public void rangerIdIsSetCorrectly() throws Exception{
        Ranger ranger = newRanger();
        int rangerId = ranger.getId();
        rangerDao.add(ranger);
        assertNotEquals(rangerId, ranger.getId());
    }

//    @Test
//    public void existingRangersCanBeFoundById() throws Exception{
//        Ranger ranger = newRanger();
//        rangerDao.add(ranger);
//        Ranger foundRanger = rangerDao.findById(ranger.getId());
//        assertEquals(ranger, foundRanger);
//    }

    @Test
    public void getsAllRangers() throws Exception{
        Ranger ranger = newRanger();
        Ranger ranger1 = newRanger();
        Ranger ranger2 = newRanger();
        rangerDao.add(ranger);
        rangerDao.add(ranger1);
        rangerDao.add(ranger2);
        assertEquals(3, rangerDao.getAll().size());
    }

    @Test
    public void noTasksReturnsEmptyList() throws Exception {
        assertEquals(0, rangerDao.getAll().size());
    }

    @Test
    public void updateRanger() throws Exception {
        String initialName = "Emma";
        int initialBadgeNumber = 23;
        Ranger ranger = newRanger();
        rangerDao.add(ranger);
        rangerDao.update(ranger.getId(),"Joy", 32, 123, "emma@yahoo.com");
        Ranger updatedRanger = rangerDao.findById(ranger.getId());
        assertNotEquals(initialName, updatedRanger.getName());
        assertNotEquals(initialBadgeNumber, updatedRanger.getBadge_number());
    }

    @Test
    public void deleteByIdDeletesCorrectRager() throws Exception {
        Ranger ranger = newRanger();
        rangerDao.add(ranger);
        rangerDao.deleteById(ranger.getId());
        assertEquals(0, rangerDao.getAll().size());
    }

    @Test
    public void clearAllClearsAll() throws Exception {
        Ranger ranger = newRanger();
        Ranger ranger1 = new Ranger("Alice", 12, 985, "alice@gmail.com");
        rangerDao.add(ranger);
        rangerDao.add(ranger1);
        int daoSize = rangerDao.getAll().size();
        rangerDao.clearAllRangers();
        assertTrue(daoSize > 0 && daoSize > rangerDao.getAll().size());
    }

    private Ranger newRanger(){
        return new Ranger("Emma", 23, 555, "joy@gmail.com");
    }
}