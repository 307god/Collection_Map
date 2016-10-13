package Playingcard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 2016/10/11.
 * 扑克牌的花色
 */
public class DesignList {

    /**
     * 扑克牌花色序列
     */
    private List<String> designList;

    public List<String> getDesignList() {
        return designList;
    }

    public void setDesignList(List<String> designList) {
        this.designList = designList;
    }

    public DesignList() {
        this.designList = new ArrayList<String>();
        designList.add("梅花");
        designList.add("方块");
        designList.add("红桃");
        designList.add("黑桃");
    }
}
