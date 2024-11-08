package petriNet.app;
import petriNet.app.ArcIn;

import java.util.List;

/**
 * @autor: 我亦无他，唯手熟尔
 */

class Transition {
    private List<ArcIn> arcIn; // 输入弧
    private List<ArcOut> arcOut; // 输出弧

    public Transition() {
    }

    public Transition(List<ArcIn> arcIn, List<ArcOut> arcOut) {
        this.arcIn = arcIn; // 初始化输入弧
        this.arcOut = arcOut; // 初始化输出弧
    }

    public void doFire() {
        // 如果能够转换
        if(isFireAble()){
            for(ArcIn arcIn : arcIn){
                arcIn.executeTransition();
            }
            for(ArcOut arcOut : arcOut){
                arcOut.executeTransition();
            }
        }
    }

    public boolean isFireAble() {
        // 判断转换是否可以触发
        for (ArcIn arc : arcIn) {
            if (!((ArcIn) arc).stepAble()) {
                return false; // 如果任何输入弧不满足条件，返回false
            }
        }
        return true; // 所有输入弧都满足条件，返回true
    }

    public List<ArcIn> getArcIn() {
        return arcIn; // 获取输入弧列表
    }

    public void setArcIn(List<ArcIn> arcIn) {
        this.arcIn = arcIn; // 设置输入弧列表
    }

    public List<ArcOut> getArcOut() {
        return arcOut; // 获取输出弧列表
    }

    public void setArcOut(List<ArcOut> arcOut) {
        this.arcOut = arcOut; // 设置输出弧列表
    }
}
