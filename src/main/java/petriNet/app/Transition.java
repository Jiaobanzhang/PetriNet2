package petriNet.app;

import java.util.List;

/**
 * Represents a Transition in a Petri Net.
 * Holds input and output arcs, and manages the firing conditions for the transition.
 *
 * @autor: JIAO Yongshun, ZHU Xinlei
 * @date: 08/11/2024
 * @version: v1.0
 */

public class Transition {
    private List<ArcIn> arcIn;
    private List<ArcOut> arcOut;

    public Transition() {
    }

    public Transition(List<ArcIn> arcIn, List<ArcOut> arcOut) {
        this.arcIn = arcIn;
        this.arcOut = arcOut;
    }

    /*
     * Executes the transition by adding or removing tokens from the connected Places.
     */

    public void doFire() {
        if (isFireAble()) {
            for (ArcIn arcIn : arcIn) {
                arcIn.executeTransition();
            }
            for (ArcOut arcOut : arcOut) {
                arcOut.executeTransition();
            }
        }
    }

    /*
     * Checks if the transition can occur by verifying all input arcs.
     * @return true if the transition can proceed, false otherwise
     */
    public boolean isFireAble() {
        for (ArcIn arc : arcIn) {
            if (! arc.fireAble()) {
                return false;
            }
        }
        return true;
    }
}
