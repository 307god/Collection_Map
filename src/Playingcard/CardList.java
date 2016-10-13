package Playingcard;

import java.util.*;

/**
 * Created by james on 2016/10/11.
 * 关于牌组的相关操作
 */
public class CardList implements Comparator<Card>{

    /**
     * 扑克牌牌组序列
     */
    private List<Card> cardList;

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public CardList() {
        this.cardList = new ArrayList<Card>();
    }

    /**
     * 构造一副牌
     */
    public void createCard(){
        DesignList designList = new DesignList();
        DataList dataList = new DataList();

        for (int i = 0; i < 13; i++)
            for (int j = 0;j < 4; j++){
                Card card = new Card(designList.getDesignList().get(j), dataList.getDataList().get(i));
                cardList.add(card);
            }
    }

    /**
     * 洗牌操作
     * @return 洗牌结果
     */
    public List<Card> shuffle(){
        List<Card> cl = new ArrayList<Card>();
        Random random = new Random();
        int i = 0;
        while (i < 52){
            Card card = cardList.get(random.nextInt(52));
            if (!cl.contains(card)){
                cl.add(card);
                i++;
            }
        }
        return cl;
    }

    /**
     * 发牌操作
     * @return 所发的牌
     */
    public Card deal(){
        Random random = new Random();
        return shuffle().get(random.nextInt(52));
    }

    /**
     * 比大小
     * @param c1 牌1
     * @param c2 牌2
     * @return c1,c2的大者
     */
    @Override
    public int compare(Card c1, Card c2) {
        DataList dataList = new DataList();
        DesignList designList = new DesignList();
        Integer i1 = dataList.getDataList().indexOf(c1.getData());
        Integer i2 = dataList.getDataList().indexOf(c2.getData());
        int i = i1.compareTo(i2);

        if (i != 0){
            return i;
        } else {
            Integer i3 = designList.getDesignList().indexOf(c1.getDesign());
            Integer i4 = designList.getDesignList().indexOf(c2.getDesign());
            return i3.compareTo(i4);
        }
    }


    public static void main(String args[]){
        CardList cardList = new CardList();
        cardList.createCard();
        for (Card c : cardList.shuffle()){
            System.out.println("<" + c.getDesign() + c.getData() + ">");
        }
//        int i = 0;
//        List<Card> cl1 = new ArrayList<Card>();
//        while (i < 2){
//            Card c1 = cardList.deal();
//            if (!cl1.contains(c1)){
//                cl1.add(c1);
//                i++;
//            }
//        }
//        i = 0;
//        List<Card> cl2 = new ArrayList<Card>();
//        while (i < 2){
//            Card c2 = cardList.deal();
//            if (!cl2.contains(c2) && !cl1.contains(c2)){
//                cl2.add(c2);
//                i++;
//            }
//        }
        List<Card> cl1 = new ArrayList<Card>();
        List<Card> cl2 = new ArrayList<Card>();
        for (int i = 0; i < 2; i++){
            Card c = null;
            do {
                c = cardList.deal();
            }while (cl1.contains(c) && cl2.contains(c));
            cl1.add(c);
            System.out.println("牌组1新加：<" + c.getDesign() + c.getData() + ">");
            do {
                c = cardList.deal();
            }while (cl1.contains(c) && cl2.contains(c));
            cl2.add(c);
            System.out.println("牌组2新加：<" + c.getDesign() + c.getData() + ">");
        }
        System.out.println("牌组1：");
        for (Card c : cl1){
            System.out.println("<" + c.getDesign() + c.getData() + ">");
        }
        System.out.println("牌组2：");
        for (Card c : cl2){
            System.out.println("<" + c.getDesign() + c.getData() + ">");
        }
        Collections.sort(cl1, new CardList());
        System.out.println("排序后牌组1：");
        for (Card c : cl1){
            System.out.println("<" + c.getDesign() + c.getData() + ">");
        }
        System.out.println("最大牌：<" + cl1.get(1).getDesign() + cl1.get(1).getData() + ">");
        Collections.sort(cl2, new CardList());
        System.out.println("排序后牌组2：");
        for (Card c : cl2){
            System.out.println("<" + c.getDesign() + c.getData() + ">");
        }
        System.out.println("最大牌：<" + cl2.get(1).getDesign() + cl2.get(1).getData() + ">");
    }
}
