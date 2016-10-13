package Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by james on 2016/10/7.
 */
public class CollectionsTest {

    /**
     * 1、通过Collections.sort()方法，对Integer泛型的List进行排序；
     * 创建一个Integer泛型的List,插入十个100以内的不重复随机整数，
     * 调用Collections.sort()方法对其进行排序
     */
    public void testSort1(){
        List<Integer> integerList = new ArrayList<Integer>();
        //插入十个100以内的不重复随机整数
        Random random = new Random();
        Integer k;
        for (int i = 0; i < 10; i++){
            do {
                k = random.nextInt(100);
            }while (integerList.contains(k));
            integerList.add(k);
            System.out.println("成功添加整数：" + k);
        }
        System.out.println("--------排序前--------");
        for (Integer integer : integerList) {
            System.out.println("元素：" + integer);
        }
        Collections.sort(integerList);
        System.out.println("--------排序后--------");
        for (Integer integer : integerList) {
            System.out.println("元素：" + integer);
        }
    }

    /**
     * 2、对String泛型的List进行排序；
     * 创建String泛型的List，添加三个乱序的String元素，
     * 调用sort方法，再次输出排序后的顺序
     */
    public void testSort2(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("microsoft");
        stringList.add("google");
        stringList.add("lenovo");
        System.out.println("--------排序前--------");
        for (String string : stringList) {
            System.out.println("元素：" + string);
        }
        Collections.sort(stringList);
        System.out.println("--------排序后--------");
        for (String string : stringList) {
            System.out.println("元素：" + string);
        }
    }

    /**
     * 1、创建完List<String>之后，往其中添加十条随机字符串
     * 2、每条字符串的长度为10以内的随机整数
     * 3、每条字符串的每个字符都为随机生成的字符，字符可以重复
     * 4、每条随机字符串不可重复
     */
    public void testSort2_1(){
        List<String> stringList = new ArrayList<String>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            StringBuilder tempString = new StringBuilder();
            do {
                int k = random.nextInt(10);
                for (int j = 0; j <= k; j++){
                    int t = random.nextInt(3);
                    if (t == 0) {
                        tempString.append((char)('0' + random.nextInt(10)));
                    } else if (t == 1) {
                        tempString.append((char)('A' + random.nextInt(26)));
                    } else {
                        tempString.append((char)('a' + random.nextInt(26)));
                    }
                }
            } while(stringList.contains(tempString.toString()));
            stringList.add(tempString.toString());
        }
        System.out.println("--------排序前--------");
        for (String st : stringList) {
            System.out.println("将要添加字符串：'" + st + "'");
        }
        Collections.sort(stringList);
        System.out.println("--------排序后--------");
        for (String st : stringList) {
            System.out.println("元素：" + st);
        }
    }

    /**
     * 3、对其他类型泛型的List进行排序，以Student为例
     */
    public void testSort3(){
        List<Student> studentList = new ArrayList<Student>();
        Random random = new Random();
        List<Integer> integerList = new ArrayList<Integer>();
        Integer k;
        for (int i = 0; i < 3; i++){
            do {
                k = random.nextInt(1000);
            }while(integerList.contains(k));
            integerList.add(k);
        }
        studentList.add(new Student(integerList.get(0) + "", "Mike"));
        studentList.add(new Student(integerList.get(1) + "", "Angela"));
        studentList.add(new Student(integerList.get(2) + "", "小明"));
        studentList.add(new Student(10000 + "", "小明"));
        System.out.println("--------排序前--------");
        for (Student student : studentList) {
            System.out.println("学生：" + student.getId() + ":" + student .getName());
        }
        Collections.sort(studentList, new StudentComparator());
        System.out.println("--------排序后--------");
        for (Student student : studentList) {
            System.out.println("元素：" + student.getId() + ":" + student .getName());
        }
    }

    public static void main(String[] args){
        CollectionsTest ct = new CollectionsTest();
//        ct.testSort1();
//        ct.testSort2();
//        ct.testSort2_1();
        ct.testSort3();
    }
}
