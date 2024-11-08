package petriNet.test;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import petriNet.app.Place;

public class PlaceTest {
    private Place place;

    @BeforeEach
    public void setUp() {
        place = new Place(5); // Initialize a Place with 5 tokens.
    }

    @Test
    public void testConfigution() {
        assertNotNull(place);
    }

    @Test
    public void testGetTokens() {
        int tokens = place.getToken();
        assertEquals(5, tokens, "Place should return the current number of tokens.");
    }

    @Test
    public void testRemoveTokens() {
        place.removeToken(2); // Remove 2 tokens .
        Assertions.assertEquals(3, place.getToken(), "Place should remove the number of tokens.");
    }

    @Test
    public void testAddTokens() {
        place.addToken(2); // add 2 token.
        Assertions.assertEquals(7, place.getToken(), "Place should add the number of tokens.");
    }

}
