package petriNet.app;

/**
 * Represents an input arc in a Petri Net, connecting a Place to a Transition.
 * During the transition, tokens are removed from the Place based on the arc's weight.
 * Checks if the transition can occur by verifying the Place has enough tokens.
 *
 * @autor: JIAO Yongshun, ZHU Xinlei
 * @date: 08/11/2024
 * @version: v1.0
 */

class ArcIn extends Arc {
    public ArcIn(int weight, Place place) {
        super(weight, place);
    }

    /**
     * Executes the transition by removing tokens from the Place.
     */
    public void executeTransition() {
        this.getPlace().removeToken(this.getWeight());
    }

    /**
     * Checks if this arc allows the transition, ensuring the Place has enough tokens.
     * @return true if the transition can proceed, false otherwise
     */
    public boolean fireAble() {
        return this.getPlace().getToken() >= this.getWeight(); // 判断是否可以执行转换
    }
}
