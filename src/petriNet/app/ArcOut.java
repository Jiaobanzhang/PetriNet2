package petriNet.app;
import javafx.scene.shape.Arc;

/**
 * @autor: 我亦无他，唯手熟尔
 */
class ArcOut extends Arc {
    private int weight; // 权重

    public ArcOut(int weight, Place place) {
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
        // 判断是否可以执行转换
        return true; // 简化处理
    }

    public void deleteTokens() {
        // 实现删除令牌的逻辑
    }
}
