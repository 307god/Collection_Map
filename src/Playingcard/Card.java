package Playingcard;

/**
 * Created by james on 2016/10/11.
 * 扑克牌类
 */
public class Card {

    /**
     * 花色
     */
    private String design;

    /**
     * 大小
     */
    private String data;

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Card(String design, String data) {
        this.design = design;
        this.data = data;
    }
}
