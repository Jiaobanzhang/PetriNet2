package petriNet.app;

import java.util.List;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 * @date: 08/11/2024
 */

 class PetriNetImpl implements PetriNet {
    private List<Place> places;
    private List<Arc> arcs;
    private List<Transition> transitions;

    public PetriNetImpl() {
    }

    public PetriNetImpl(List<Place> places, List<Arc> arcs, List<Transition> transitions) {
        this.places = places;
        this.arcs = arcs;
        this.transitions = transitions;
    }

    @Override
    public void addPlace(Place place) {
        places.add(place);
    }

    @Override
    public void deletePlace(Place place) {
        places.remove(place);
    }

    @Override
    public void addArc(Arc arc) {
        arcs.add(arc);
    }

    @Override
    public void deleteArc(Arc arc) {
        arcs.remove(arc);
    }

    @Override
    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    @Override
    public void deleteTransition(Transition transition) {
        transitions.remove(transition);
    }

    @Override
    public void step() {
        for (Transition transition : transitions) {
            fire(transition);
        }
    }

    public void fire(Transition transition){
        if(transition.isFireAble()){
           transition.doFire();
        }
    }
}