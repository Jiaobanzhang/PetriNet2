package petriNet.test;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 *
 *  ----------------------------------------------------------------------------------------------------------
 * ｜                                                PetriNet                                                 ｜
 * ｜                                                                                                         ｜
 * ｜  PlaceIn(5 tokens) --> ArcIn(weight 3) -->  transition --> ArcOut(weight 2) --> PlaceOut(0 tokens)      ｜
 * ｜                                                                                                         ｜
 * ｜                                                                                                         ｜
 * ｜  PlaceIn1(4 tokens) --> ArcIn1(weight 3) -->  transition1 --> ArcOut1(weight 2) --> PlaceOut1(0 tokens) ｜
 * ｜                                                                                                         ｜
 *  ----------------------------------------------------------------------------------------------------------
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import petriNet.app.*;

import static org.junit.jupiter.api.Assertions.*;

public class PetriNetTest {
    List<Transition> transitionList;
    List<Arc> arcList;
    List<Place> placeList;
    PetriNetImpl petriNet;

    @BeforeEach
    public void setUp() {
        arcList = new ArrayList<>();
        transitionList = new ArrayList<>();
        placeList = new ArrayList<>();
        petriNet = new PetriNetImpl(placeList, arcList, transitionList);
    }

    @Test
    public void testDefaultConfigution() {
        petriNet = new PetriNetImpl();
        assertNotNull(petriNet);
    }

    // Test addPlace and removePlace
    @Test
    public void testPlace() {
        Place placeIn = new Place(5);

        petriNet.addPlace(placeIn);
        assertTrue(placeList.contains(placeIn), "Ajouter_place should add the place to the list of places.");

        petriNet.deletePlace(placeIn);
        assertFalse(placeList.contains(placeIn), "Delete_place should delete the place to the list of places.");
    }

    // Test addArc and removeArc
    @Test
    public void testArc() {
        Place placeIn = new Place(5);
        ArcIn arcIn = new ArcIn(3, placeIn);

        petriNet.addArc(arcIn);
        assertTrue(arcList.contains(arcIn), "Ajouter arc should add the arc to the list of arcs.");

        petriNet.deleteArc(arcIn);
        assertFalse(arcList.contains(arcIn), "Delete_arc should delete the arc to the list of arcs.");
    }

    // Test addTransition and removeTransition
    @Test
    public void testTransition() {
        Transition transition = new Transition();

        petriNet.addTransition(transition);
        assertTrue(transitionList.contains(transition), "Ajouter_transition should add the transition to the list of transitions.");

        petriNet.deleteTransition(transition);
        assertFalse(arcList.contains(transition), "Delete_transition should delete the transition to the list of transitions.");
    }

    // Test fire
    @Test
    public void fire(){
        Place placeIn = new Place(5);
        Place placeOut = new Place(0);

        ArcIn arcIn = new ArcIn(3, placeIn);
        ArcOut arcOut = new ArcOut(2, placeOut);

        ArrayList<ArcIn> arcInList = new ArrayList<>();
        ArrayList<ArcOut> arcOutList = new ArrayList<>();

        arcInList.add(arcIn);
        arcOutList.add(arcOut);

        Transition transition = new Transition(arcInList, arcOutList);

        transitionList.add(transition);
        arcList.add(arcIn);
        placeList.add(placeIn);
        petriNet = new PetriNetImpl(placeList, arcList, transitionList);

        petriNet.fire(transition);

        assertEquals(2, placeIn.getToken(), "fire does not work");
        assertEquals(2, placeOut.getToken(), "fire does not work");
    }

    @Test
    public void fireAll(){
        // Transition:

        Place placeIn = new Place(5);
        Place placeOut = new Place(0);

        ArcIn arcIn = new ArcIn(3, placeIn);
        ArcOut arcOut = new ArcOut(2, placeOut);

        ArrayList<ArcIn> arcInList = new ArrayList<>();
        ArrayList<ArcOut> arcOutList = new ArrayList<>();

        arcInList.add(arcIn);
        arcOutList.add(arcOut);

        Transition transition = new Transition(arcInList, arcOutList);


        // Transition1:

        Place placeIn1 = new Place(4);
        Place placeOut1 = new Place(0);

        ArcIn arcIn1 = new ArcIn(3, placeIn1);
        ArcOut arcOut1 = new ArcOut(2, placeOut1);

        ArrayList<ArcIn> arcInList1 = new ArrayList<>();
        ArrayList<ArcOut> arcOutList1 = new ArrayList<>();

        arcInList1.add(arcIn1);
        arcOutList1.add(arcOut1);

        Transition transition1 = new Transition(arcInList1, arcOutList1);

        // sum up:
        transitionList.add(transition);
        transitionList.add(transition1);
        arcList.add(arcIn);
        arcList.add(arcIn1);
        arcList.add(arcOut);
        arcList.add(arcOut1);
        placeList.add(placeIn);
        placeList.add(placeOut);
        placeList.add(placeIn1);
        placeList.add(placeOut1);

        // new PetriNetImpl
        petriNet = new PetriNetImpl(placeList, arcList, transitionList);
        petriNet.fireAll();

        assertEquals(2, placeIn.getToken(), "fire does not work");
        assertEquals(2, placeOut.getToken(), "fire does not work");
        assertEquals(1, placeIn1.getToken(), "fire does not work");
        assertEquals(2, placeOut1.getToken(), "fire does not work");

    }
}

