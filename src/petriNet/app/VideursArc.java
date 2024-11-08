package petriNet.app;

/**
 * @autor: JIAO Yongshun, ZHU Xinlei
 * @date: 08/11/2024
 */
public class VideursArc extends ArcIn{

    public VideursArc(Place place) {
        super(0, place);
    }

    @Override
    public boolean stepAble() {
        return this.getPlace().getToken() > 0;
    }

    @Override
    public void executeTransition(){
        int allToken = this.getPlace().getToken();
        this.getPlace().removeToken(allToken);
    }
}
