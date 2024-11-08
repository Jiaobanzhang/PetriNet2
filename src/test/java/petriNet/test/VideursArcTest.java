package petriNet.test;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petriNet.app.Place;
import petriNet.app.VideursArc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class VideursArcTest {
    private VideursArc videursArc;
    private Place place;

    @BeforeEach
    public void setUp() {
        place = new Place(5); // Initialize a Place with 5 tokens.
        videursArc = new VideursArc(place);
    }

    @Test
    public void testConfigution() {
        assertNotNull(videursArc);
    }

    @Test
    public void testFireAble() {
        assertEquals(true, videursArc.fireAble(), "the num is bigger than 0, return true");
    }

}
