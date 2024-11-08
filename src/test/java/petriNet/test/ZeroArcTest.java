package petriNet.test;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petriNet.app.Place;
import petriNet.app.ZeroArc;

public class ZeroArcTest {
    private ZeroArc zeroArc;
    private Place place;

    @BeforeEach
    public void setUp() {
        place = new Place(5); // Initialize a Place with 5 tokens.
        zeroArc = new ZeroArc(place);
    }

    @Test
    public void testConfigution() {
        assertNotNull(zeroArc);
    }

    @Test
    public void testFireAble() {
        assertEquals(false, zeroArc.fireAble(), "the num is not 0, return false");
    }
}
