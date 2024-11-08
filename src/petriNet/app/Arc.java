package petriNet.app;
/**
 * @autor: 我亦无他，唯手熟尔
 */
// Arc 类（抽象类）
public class Arc {
    private Place place; // 连接的地点
    private int weight; // 权重

    public Arc(Place place) {
        this.place = place; // 构造函数，初始化连接的地点
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
