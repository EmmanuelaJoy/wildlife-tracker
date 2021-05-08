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
    public void instantiatesRangerObjectsCorrectly_true() throws Exception{
        Ranger ranger = newRanger();
        assertTrue(ranger instanceof Ranger);
    }

    @Test
    public void rangerNameReturnsCorrectly_String() throws Exception{
        Ranger ranger = newRanger();
        assertEquals("Emma", ranger.getName());
    }

    @Test
    public void rangerBadgeNumberReturnsCorrectly_int() throws Exception{
        Ranger ranger = newRanger();
        assertEquals(23, ranger.getBadge_number());
    }

    @Test
    public void rangerPhoneNumberReturnsCorrectly_int() throws Exception{
        Ranger ranger = newRanger();
        assertEquals(555, ranger.getPhone_number());
    }

    @Test
    public void rangerEmailReturnsCorrectly_String() throws Exception{
        Ranger ranger = newRanger();
        assertEquals("joy@gmail.com", ranger.getEmail());
    }

    private Ranger newRanger(){
        return new Ranger("Emma", 23, 555, "joy@gmail.com");
    }

}