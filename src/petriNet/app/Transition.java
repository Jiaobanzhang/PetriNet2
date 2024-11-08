package petriNet.app;
import petriNet.app.ArcIn;

import java.util.List;

/**
 * @autor: 我亦无他，唯手熟尔
 */

class Transition {
    private List<Arc> arcIn; // 输入弧
    private List<Arc> arcOut; // 输出弧

    public Transition(List<Arc> arcIn, List<Arc> arcOut) {
        this.arcIn = arcIn; // 初始化输入弧
        this.arcOut = arcOut; // 初始化输出弧
    }

    public void doFire() {
        // 实现触发转换的逻辑
    }

    public boolean isFireAble() {
        // 判断转换是否可以触发
        for (Arc arc : arcIn) {
            if (!((ArcIn) arc).stepAble()) {
                return false; // 如果任何输入弧不满足条件，返回false
            }
        }
        return true; // 所有输入弧都满足条件，返回true
    }

    public List<Arc> getArcIn() {
        return arcIn; // 获取输入弧列表
    }

    public void setArcIn(List<Arc> arcIn) {
        this.arcIn = arcIn; // 设置输入弧列表
    }

    public List<Arc> getArcOut() {
        return arcOut; // 获取输出弧列表
    }

    public void setArcOut(List<Arc> arcOut) {
        this.arcOut = arcOut; // 设置输出弧列表
    }
}
