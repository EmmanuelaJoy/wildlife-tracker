package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LocationTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Location.clearAllLocations();
    }

    @Test
    public void instantiatesLocationObjectsCorrectly_true() {
        Location location = newLocation();
        assertTrue(location instanceof Location);
    }

    @Test
    public void locationIdReturnsCorrectly_int() {
        Location location = newLocation();
        assertEquals(1, location.getId());
    }

    @Test
    public void locationNameReturnsCorrectly_String() {
        Location location = newLocation();
        assertEquals("Zone A", location.getName());
    }

    @Test
    public void allLocationsContainsAllLocationObjects_true() {
        Location location = newLocation();
        Location location1 = newLocation();
        assertTrue(Location.getLocations().contains(location));
        assertTrue(Location.getLocations().contains(location1));
    }

    @Test
    public void locationObjectsDeletedCorrectly_int() {
        Location location = newLocation();
        Location location1 = newLocation();
        Location.clearAllLocations();
        assertEquals(0, Location.getLocations().size());
    }

    private Location newLocation(){
        return new Location("Zone A");
    }
}