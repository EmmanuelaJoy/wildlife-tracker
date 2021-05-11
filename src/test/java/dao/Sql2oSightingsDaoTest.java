package dao;

import models.Sighting;
import org.sql2o.*;
import org.junit.*;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oSightingsDaoTest {

    private static Sql2oSightingsDao sightingsDao;
    private static Connection connection;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://ec2-54-163-254-204.compute-1.amazonaws.com:5432/de2jr153rr5f6k?sslmode=require";
        Sql2o sql2o = new Sql2o(connectionString, "swgavudvlixczf", "2948abef64b5819012a8e053e492dede708185e8e553b16645179cb21356ed72");
//        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker";
//        Sql2o sql2o = new Sql2o(connectionString, "emmanuela", "adminPass");
        sightingsDao = new Sql2oSightingsDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        sightingsDao.clearAllSightings();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        connection.close();
        System.out.println("connection closed");
    }

    @Test
    public void sightingsIdIsSetCorrectly() throws Exception{
        Sighting sighting = newSighting();
        int sightingId = sighting.getId();
        sightingsDao.add(sighting);
        assertNotEquals(sightingId, sighting.getId());
    }

    @Test
    public void getsAllSightings() throws Exception {
        Sighting sighting = newSighting();
        Sighting sighting1 = new Sighting(3,3,3);
        sightingsDao.add(sighting);
        sightingsDao.add(sighting1);
        assertEquals(2, sightingsDao.getAll().size());
    }

    @Test
    public void noSightingsReturnsEmptyList() throws Exception {
        assertEquals(0, sightingsDao.getAll().size());
    }

    @Test
    public void deleteByIdDeletesCorrectSighting() throws Exception {
        Sighting sighting = newSighting();
        sightingsDao.add(sighting);
        sightingsDao.deleteById(sighting.getId());
        assertEquals(0, sightingsDao.getAll().size());
    }

    @Test
    public void clearAllClearsAll() throws Exception {
        Sighting sighting = newSighting();
        Sighting sighting1 = new Sighting(4,4,4);
        sightingsDao.add(sighting);
        sightingsDao.add(sighting1);
        int daoSize = sightingsDao.getAll().size();
        sightingsDao.clearAllSightings();
        assertTrue(daoSize > 0 && daoSize > sightingsDao.getAll().size());
    }


    private Sighting newSighting(){
        return new Sighting(2, 2, 2);
    }
}