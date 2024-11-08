package petriNet.app;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 * @date: 08/11/2024
 */

class ArcOut extends Arc {

    public ArcOut(int weight, Place place) {
        super(weight, place);
    }

    public void executeTransition() {
        this.getPlace().addToken(this.getWeight());
    }
}
