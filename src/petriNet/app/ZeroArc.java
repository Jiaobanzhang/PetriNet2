package petriNet.app;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 * @date: 08/11/2024
 */
public class ZeroArc extends ArcIn{

    public ZeroArc(Place place) {
        super(0, place);
    }

    @Override
    public boolean stepAble(){
        return this.getPlace().getToken() == 0;
    }
}
