package petriNet.app;

/**
 * @autor: 我亦无他，唯手熟尔
 */
class ArcOut extends Arc {

    public ArcOut(int weight, Place place) {
        super(weight, place);
    }

    public void executeTransition() {
        this.getPlace().addToken(this.getWeight());
    }
}
