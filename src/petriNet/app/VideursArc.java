package petriNet.app;

/**
 * @autor: 我亦无他，唯手熟尔
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
