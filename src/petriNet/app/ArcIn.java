package petriNet.app;

/**
 * @autor: 我亦无他，唯手熟尔
 */
class ArcIn extends Arc {
    public ArcIn(int weight, Place place) {
        super(weight, place);
    }

    public void executeTransition() {
        this.getPlace().removeToken(this.getWeight());
    }

    public boolean stepAble() {
        return this.getPlace().getToken() >= this.getWeight(); // 判断是否可以执行转换
    }
}
