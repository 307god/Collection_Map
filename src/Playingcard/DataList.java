package Playingcard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 2016/10/11.
 * 扑克牌的数字
 */
public class DataList {

    /**
     * 扑克牌花色序列
     */
    private List<String> dataList;

    public List<String> getDataList() {
        return dataList;
    }

    public void setDataList(List<String> dataList) {
        this.dataList = dataList;
    }

    public DataList() {
        this.dataList = new ArrayList<String>();
        for (int i = 1; i < 10; i++){
            this.dataList.add((i+1) + "");
        }
        dataList.add("J");
        dataList.add("Q");
        dataList.add("K");
        dataList.add("A");
    }
}
