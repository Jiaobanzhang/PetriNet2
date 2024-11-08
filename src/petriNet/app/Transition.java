package petriNet.app;

import java.util.List;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 * @date: 08/11/2024
 */

class Transition {
    private List<ArcIn> arcIn;
    private List<ArcOut> arcOut;

    public Transition() {
    }

    public Transition(List<ArcIn> arcIn, List<ArcOut> arcOut) {
        this.arcIn = arcIn;
        this.arcOut = arcOut;
    }

    public void doFire() {
        if(isFireAble()){
            for(ArcIn arcIn : arcIn){
                arcIn.executeTransition();
            }
            for(ArcOut arcOut : arcOut){
                arcOut.executeTransition();
            }
        }
    }

    public boolean isFireAble() {
        for (ArcIn arc : arcIn) {
            if (!((ArcIn) arc).stepAble()) {
                return false;
            }
        }
        return true;
    }

    public List<ArcIn> getArcIn() {
        return arcIn;
    }

    public void setArcIn(List<ArcIn> arcIn) {
        this.arcIn = arcIn;
    }

    public List<ArcOut> getArcOut() {
        return arcOut;
    }

    public void setArcOut(List<ArcOut> arcOut) {
        this.arcOut = arcOut;
    }
}
