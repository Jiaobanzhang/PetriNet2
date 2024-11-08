package petriNet.app;

/**
 * @autor: 我亦无他，唯手熟尔
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
