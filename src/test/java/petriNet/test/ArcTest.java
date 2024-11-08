package petriNet.test;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petriNet.app.Arc;
import petriNet.app.Place;

public class ArcTest {
    private Arc arc;
    private Place place;

    @BeforeEach
    public void setUp() {
        place = new Place(5); // Initialize a Place with 5 tokens.
        arc = new Arc(3, place); // Initialize an Arc with weight 3, connected to the Place and Transition.
    }

    // Test Configution, getPlace(), getWeight()
    @Test
    public void testConfigution() {
        assertNotNull(arc);
        assertEquals(3, arc.getWeight(), "Constructor should set the weight of the Arc.");
        assertEquals(place, arc.getPlace(), "Constructor should set the place of the Arc.");
    }

    @Test
    public void testSetWeight() {
        arc.setWeight(5);
        assertEquals(5, arc.getWeight(), "Constructor should set the place of the Arc.");
    }

}
