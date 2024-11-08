package petriNet.test;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petriNet.app.ArcOut;
import petriNet.app.Place;

public class ArcOutTest {
    private ArcOut arcOut;
    private Place place;

    @BeforeEach
    public void setUp() {
        place = new Place(5); // Initialize a Place with 5 tokens.
        arcOut = new ArcOut(3, place); // Initialize an Arc with weight 3, connected to the Place and Transition.
    }

    // Test Configution
    @Test
    public void testConfigution() {
        assertNotNull(arcOut);
    }

    @Test
    public void testExcuteTransition() {
        arcOut.executeTransition();
        place = arcOut.getPlace();
        assertEquals(8, place.getToken(), "executeTransition does not work");
    }
}
