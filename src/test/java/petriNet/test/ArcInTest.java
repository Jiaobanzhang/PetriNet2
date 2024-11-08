package petriNet.test;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petriNet.app.ArcIn;
import petriNet.app.Place;

public class ArcInTest {
    private ArcIn arcIn;
    private Place place;

    @BeforeEach
    public void setUp() {
        place = new Place(5); // Initialize a Place with 5 tokens.
        arcIn = new ArcIn(3, place); // Initialize an Arc with weight 3, connected to the Place and Transition.
    }

    // Test Configution
    @Test
    public void testConfigution() {
        assertNotNull(arcIn);
    }

    @Test
    public void testExcuteTransition() {
        arcIn.executeTransition();
        place = arcIn.getPlace();
        assertEquals(2, place.getToken(), "executeTransition does not work");
    }

    @Test
    public void testFireAble() {
        assertEquals(true, arcIn.fireAble(), "The token is 5 bigger than weight(3).");
    }
}
