import java.util.List;

/**
 * @autor: 我亦无他，唯手熟尔
 */
public class PetriNetImpl implements PetriNet{
    private List<Place> places; // 地点列表
    private List<Arc> arcs; // 弧列表
    private List<Transition> transitions; // 转换列表

    public PetriNetImpl(List<Place> places, List<Arc> arcs, List<Transition> transitions) {
        this.places = places; // 初始化地点列表
        this.arcs = arcs; // 初始化弧列表
        this.transitions = transitions; // 初始化转换列表
    }

    @Override
    public void addPlace(Place place) {
        places.add(place); // 添加地点
    }

    @Override
    public void deletePlace(Place place) {
        places.remove(place); // 删除地点
    }

    @Override
    public void addArc(Arc arc) {
        arcs.add(arc); // 添加弧
    }

    @Override
    public void deleteArc(Arc arc) {
        arcs.remove(arc); // 删除弧
    }

    @Override
    public void addTransition(Transition transition) {
        transitions.add(transition); // 添加转换
    }

    @Override
    public void deleteTransition(Transition transition) {
        transitions.remove(transition); // 删除转换
    }

    @Override
    public void step() {
        for (Transition transition : transitions) {
            if (transition.isFireAble()) {
                transition.doFire(); // 如果可以触发转换，执行它
            }
        }
    }
}
