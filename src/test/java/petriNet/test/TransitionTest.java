package petriNet.test;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 *
 * the graph of the transition :
 *
 * PlaceIn(5 tokens) ----> ArcIn(weight 3)              ArcIn(weight 2) <---- PlaceIn2(4 tokens)
 *                                        \           /
 *                                          transition
 *                                        /           \
 * PlaceOut(0 tokens) <---- ArcOut(weight 2)           ArcOut(weight 1) ----> PlaceOut2(0 tokens)
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import petriNet.app.ArcIn;
import petriNet.app.ArcOut;
import petriNet.app.Place;
import petriNet.app.Transition;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class TransitionTest {
    List<ArcIn> arcInList;
    List<ArcOut> arcOutList;
    Place placeIn;
    Place placeIn2;
    Place placeOut;
    Place placeOut2;
    Transition transition;

    @BeforeEach
    public void setUp() {
        arcInList = new ArrayList<>();
        arcOutList = new ArrayList<>();

        placeIn = new Place(5); // Initialize a Place with 5 tokens.
        placeIn2 = new Place(4); // Initialize a Place with 4 tokens.
        placeOut = new Place(0); // Initialize a PlaceOut with 0 tokens.
        placeOut2 = new Place(0); // Initialize a PlaceOut with 0 tokens.

        arcInList.add(new ArcIn(3, placeIn));
        arcInList.add(new ArcIn(2, placeIn2));
        arcOutList.add(new ArcOut(2, placeOut));
        arcOutList.add(new ArcOut(1, placeOut2));


        transition = new Transition(arcInList, arcOutList);
    }

    @Test
    public void testConfigution() {
        assertNotNull(transition);
    }

    @Test
    public void testIsFireAble() {
        boolean isFireAble = transition.isFireAble();
        assertEquals(true, isFireAble, "For the transition, all the place's token should bigger than it's weight correspondant, return true");
    }

    @Test
    public void testDoFire() {
        transition.doFire();
        assertEquals(2, placeIn.getToken(), "placeIn not success");
        assertEquals(2, placeIn2.getToken(), "placeIn2 not success");
        assertEquals(2, placeOut.getToken(), "placeOut not success");
        assertEquals(1, placeOut2.getToken(), "placeOut2 not success");
    }
}
