/**
 * @autor: 我亦无他，唯手熟尔
 */
public class ArcIn extends Arc{
    private int weight; // 权重

    public ArcIn(int weight, Place place) {
        super(place); // 调用父类构造函数
        this.weight = weight; // 初始化权重
    }

    @Override
    public int getWeight() {
        return weight; // 返回权重
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight; // 设置权重
    }

    public void executeTransition() {
        // 实现执行转换的逻辑
    }

    public boolean stepAble() {
        return place.getToken() >= weight; // 判断是否可以执行转换
    }
}
