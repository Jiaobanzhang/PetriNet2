package petriNet.app;

/**
 * Interface representing the basic structure of a Petri Net.
 * Defines methods for managing places, arcs, and transitions.
 *
 * @autor: JIAO Yongshun, ZHU Xinlei
 * @date: 08/11/2024
 * @version: v1.0
 * 
 */

interface PetriNet {
    void addPlace(Place place);
    void deletePlace(Place place);
    void addArc(Arc arc);
    void deleteArc(Arc arc);
    void addTransition(Transition transition);
    void deleteTransition(Transition transition);
    void fireAll();
}