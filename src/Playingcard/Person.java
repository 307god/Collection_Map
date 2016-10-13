package Playingcard;

import java.util.List;

/**
 * Created by james on 2016/10/11.
 * 玩家类
 */
public class Person {

    /**
     * 编号
     */
    private String ID;

    /**
     * 姓名
     */
    private String name;

    /**
     * 所拥有的扑克牌组
     */
    private List<Card> cardList;

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String ID, String name) {
        this.ID = ID;
        this.name = name;
    }

    public Person(String ID, String name, List<Card> cardList) {
        this.ID = ID;
        this.name = name;
        this.cardList = cardList;
    }
}
