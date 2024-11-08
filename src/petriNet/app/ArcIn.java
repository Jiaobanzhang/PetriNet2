package petriNet.app;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 * @date: 08/11/2024
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
