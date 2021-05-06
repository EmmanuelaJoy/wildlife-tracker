package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Sighting.clearAllSightings();
    }

    @Test
    public void instantiatesSightingObjectsCorrectly_true() {
        Sighting sighting = newSighting();
        assertTrue(sighting instanceof Sighting);
    }

    @Test
    public void sightingIdReturnsCorrectly_int() {
        Sighting sighting = newSighting();
        assertEquals(1, sighting.getId());
    }

    @Test
    public void sightingRangerIdReturnsCorrectly_int() {
        Sighting sighting = newSighting();
        assertEquals(1, sighting.getRangerID());
    }

    @Test
    public void sightingAnimalIdReturnsCorrectly_int() {
        Sighting sighting = newSighting();
        assertEquals(2, sighting.getAnimalID());
    }

    @Test
    public void sightingLocationIdReturnsCorrectly_int() {
        Sighting sighting = newSighting();
        assertEquals(3, sighting.getLocationID());
    }

    @Test
    public void allSightingsContainsAllSightingObjects_true() {
        Sighting sighting = newSighting();
        Sighting sighting1 = new Sighting(2,2,2);
        assertTrue(Sighting.getSightings().contains(sighting));
        assertTrue(Sighting.getSightings().contains(sighting1));
    }

    @Test
    public void sightingObjectsDeletedCorrectly_int() {
        Sighting sighting = newSighting();
        Sighting sighting1 = newSighting();
        Sighting.clearAllSightings();
        assertEquals(0, Sighting.getSightings().size());
    }

    private Sighting newSighting(){
        return new Sighting(1,2,3);
    }
}