package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangerTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void instantiatesRangerObjectsCorrectly_true() {
        Ranger ranger = newRanger();
        assertTrue(ranger instanceof Ranger);
    }

    private Ranger newRanger(){
        return new Ranger("Emma", 23, 555, "joy@gmail.com");
    }
}