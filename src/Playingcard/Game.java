package Playingcard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by james on 2016/10/13.
 * 扑克牌游戏类
 */
public class Game {

    public static void main(String args[]){
        System.out.println("--------游戏开始--------");

        System.out.println("--------创建玩家--------");
        Scanner console = new Scanner(System.in);
        System.out.println("创建第一位玩家");
        System.out.println("请输入玩家ID：");
        String strID1 = console.next();
        System.out.println("请输入玩家姓名：");
        String strName1 = console.next();
        System.out.println("创建第二位玩家");
        System.out.println("请输入玩家ID：");
        String strID2 = console.next();
        System.out.println("请输入玩家姓名：");
        String strName2 = console.next();
        Person person1 = new Person(strID1, strName1);
        Person person2 = new Person(strID2, strName2);
        System.out.println("--------创建玩家成功--------");
        System.out.println("欢迎玩家一:" + person1.getID() + "--" + person1.getName());
        System.out.println("欢迎玩家二:" + person2.getID() + "--" + person2.getName());


        System.out.println("--------创建扑克牌--------");
        CardList cardList = new CardList();
        cardList.createCard();
        System.out.println("--------创建扑克牌成功--------");
        System.out.println("扑克牌为：");
        for (Card c : cardList.getCardList()){
            System.out.print("<" + c.getDesign() + c.getData() + ">");
        }
        System.out.println();

        System.out.println("--------开始洗牌--------");
        CardList newCardList = new CardList();
        newCardList.setCardList(cardList.shuffle());
        System.out.println("--------洗牌完成--------");
        System.out.println("扑克牌为：");
        for (Card c : newCardList.getCardList()){
            System.out.print("<" + c.getDesign() + c.getData() + ">");
        }
        System.out.println();

        System.out.println("--------开始发牌--------");
        List<Card> cl1 = new ArrayList<Card>();
        List<Card> cl2 = new ArrayList<Card>();
        for (int i = 0; i < 2; i++){
            Card c = null;
            do {
                c = cardList.deal();
            }while (cl1.contains(c) && cl2.contains(c));
            cl1.add(c);
            System.out.println("玩家" + person1.getName() + "拿牌：<" + c.getDesign() + c.getData() + ">");
            do {
                c = cardList.deal();
            }while (cl1.contains(c) && cl2.contains(c));
            cl2.add(c);
            System.out.println("玩家" + person2.getName() + "拿牌：<" + c.getDesign() + c.getData() + ">");
        }
        person1.setCardList(cl1);
        person2.setCardList(cl2);
        System.out.println("--------发牌结束--------");

        System.out.println("--------开始游戏--------");
        cl1 = person1.getCardList();
        cl2 = person2.getCardList();
        Collections.sort(cl1, new CardList());
        Collections.sort(cl2, new CardList());
        System.out.println("玩家" + person1.getName() + "最大的手牌为：" + cl1.get(1).getDesign() + cl1.get(1).getData());
        System.out.println("玩家" + person2.getName() + "最大的手牌为：" + cl2.get(1).getDesign() + cl2.get(1).getData());

        int i = cardList.compare(cl1.get(1), cl2.get(1));
        if (i > 0)
            System.out.println("--------" + person1.getName() + "获胜！--------");
        else
            System.out.println("--------" + person2.getName() + "获胜！--------");

        System.out.println("玩家各自的手牌为：");
        System.out.print(person1.getName() + "：");
        for (Card c : cl1){
            System.out.print("<" + c.getDesign() + c.getData() + ">");
        }
        System.out.println();

        System.out.print(person2.getName() + "：");
        for (Card c : cl2){
            System.out.print("<" + c.getDesign() + c.getData() + ">");
        }
        System.out.println();
    }
}
