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
    }

    @Test
    public void instantiatesLocationObjectsCorrectly_true() {
        Location location = newLocation();
        assertTrue(location instanceof Location);
    }

    @Test
    public void locationNameReturnsCorrectly_String() {
        Location location = newLocation();
        assertEquals("Zone A", location.getName());
    }

    private Location newLocation(){
        return new Location("Zone A");
    }
}