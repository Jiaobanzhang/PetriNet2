package petriNet.app;
/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 * @date: 08/11/2024
 */

public class Arc {
    private Place place;
    private int weight;

    public Arc(Place place) {
        this.place = place;
    }

    public Arc(int weight, Place place) {
        this.place = place;
        this.weight = weight;
    }

    public Place getPlace() {
        return place;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
