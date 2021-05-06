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
    }

    @Test
    public void instantiatesSightingObjectsCorrectly_true() {
        Sighting sighting = newSighting();
        assertTrue(sighting instanceof Sighting);
    }

    private Sighting newSighting(){
        return new Sighting(1,1,1);
    }
}