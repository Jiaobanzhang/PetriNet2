package petriNet.app;
/**
 * @autor: 我亦无他，唯手熟尔
 */
// Arc 类（抽象类）
abstract class Arc {
    protected Place place; // 连接的地点

    public Arc(Place place) {
        this.place = place; // 构造函数，初始化连接的地点
    }

    public Place getPlace() {
        return place; // 获取连接的地点
    }

    public abstract int getWeight(); // 获取权重（抽象方法）
    public abstract void setWeight(int weight); // 设置权重（抽象方法）
}
