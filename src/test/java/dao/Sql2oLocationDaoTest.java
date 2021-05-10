package dao;

import models.  Location;
import models.Ranger;
import org.sql2o.*;
import org.junit.*;
import org.sql2o.Sql2o;

import static org.junit.Assert.*;

public class Sql2oLocationDaoTest {

    private static Sql2oLocationDao locationDao;
    private static Connection connection;

    @BeforeClass
    public static void setUp() throws Exception {
        String connectionString = "jdbc:postgresql://ec2-54-163-254-204.compute-1.amazonaws.com:5432/de2jr153rr5f6k";
        Sql2o sql2o = new Sql2o(connectionString, "swgavudvlixczf", "2948abef64b5819012a8e053e492dede708185e8e553b16645179cb21356ed72");
//        String connectionString = "jdbc:postgresql://localhost:5432/wildlife_tracker_test";
//        Sql2o sql2o = new Sql2o(connectionString, "emmanuela", "adminPass");
        locationDao = new Sql2oLocationDao(sql2o);
        connection = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        locationDao.clearAllLocations();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        connection.close();
        System.out.println("connection closed");
    }

    @Test
    public void locationIdIsSetCorrectly() throws Exception{
        Location location = newLocation();
        int locationId = location.getId();
        locationDao.add(location);
        assertNotEquals(locationId, location.getId());
    }

    @Test
    public void getsAllLocations() throws Exception{
        Location location = newLocation();
        Location location1 = new Location("Zone C");
        locationDao.add(location);
        locationDao.add(location1);
        assertEquals(2, locationDao.getAll().size());
    }

    @Test
    public void noTasksReturnsEmptyList() throws Exception {
        assertEquals(0, locationDao.getAll().size());
    }

    @Test
    public void updateLocation() throws Exception {
        String initialLocation = "Zone B";
        Location location = newLocation();
        locationDao.add(location);
        locationDao.update(location.getId(),"Zone D");
        Location updatedLocation = locationDao.findById(location.getId());
        assertNotEquals(initialLocation, updatedLocation.getName());
    }

    @Test
    public void deleteByIdDeletesCorrectLocation() throws Exception {
        Location location = newLocation();
        locationDao.add(location);
        locationDao.deleteById(location.getId());
        assertEquals(0, locationDao.getAll().size());
    }

    @Test
    public void clearAllClearsAll() throws Exception {
        Location location = newLocation();
        Location location1 = new Location("Near the river");
        locationDao.add(location);
        locationDao.add(location1);
        int daoSize = locationDao.getAll().size();
        locationDao.clearAllLocations();
        assertTrue(daoSize > 0 && daoSize > locationDao.getAll().size());
    }

    private Location newLocation(){
        return new Location("Zone B");
    }
}