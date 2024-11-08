package petriNet.app;

// PetriNet接口
interface PetriNet {
    void addPlace(Place place); // 添加地点
    void deletePlace(Place place); // 删除地点
    void addArc(Arc arc); // 添加弧
    void deleteArc(Arc arc); // 删除弧
    void addTransition(Transition transition); // 添加转换
    void deleteTransition(Transition transition); // 删除转换
    void step(); // 执行一步
}