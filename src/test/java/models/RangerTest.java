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
        Ranger.clearAllRangers();
    }

    @Test
    public void instantiatesRangerObjectsCorrectly_true() {
        Ranger ranger = newRanger();
        assertTrue(ranger instanceof Ranger);
    }

    @Test
    public void rangerIdReturnsCorrectly_int() {
        Ranger ranger = newRanger();
        assertEquals(1, ranger.getId());
    }

    @Test
    public void rangerNameReturnsCorrectly_String() {
        Ranger ranger = newRanger();
        assertEquals("Emma", ranger.getName());
    }

    @Test
    public void rangerBadgeNumberReturnsCorrectly_int() {
        Ranger ranger = newRanger();
        assertEquals(23, ranger.getBadge_number());
    }

    @Test
    public void rangerPhoneNumberReturnsCorrectly_int() {
        Ranger ranger = newRanger();
        assertEquals(555, ranger.getPhone_number());
    }

    @Test
    public void rangerEmailReturnsCorrectly_String() {
        Ranger ranger = newRanger();
        assertEquals("joy@gmail.com", ranger.getEmail());
    }

    @Test
    public void rangerObjectsAreDeletedCorrectly_True() {
        Ranger ranger = newRanger();
        Ranger ranger1 = newRanger();
        Ranger.clearAllRangers();
        assertEquals(0, Ranger.getRangers().size());
    }

    private Ranger newRanger(){
        return new Ranger("Emma", 23, 555, "joy@gmail.com");
    }

}