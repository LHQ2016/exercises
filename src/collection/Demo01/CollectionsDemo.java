package collection.Demo01;

import java.util.ArrayList;

public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList();
        list1.add("abc1");
        list1.add("abc2");
        list1.add("abc3");
        list1.add("abc4");

        ArrayList list2 = new ArrayList();
        list2.add("abc1");
        list2.add("abc2");
        list2.add("abc3");
        list2.add("abc4");
        list2.add("abc5");
        list2.add("abc5");
        list2.add("abc6");
        list2.add("abc7");
        //retainAll:元素有改变返回true,否则返回false;
//        System.out.println("retainAll:" + list1.retainAll(list2));
//        System.out.println(list1);

        Object[] objs = list2.toArray();
        for (int i = 0; i < objs.length; i++) {
//            System.out.println(objs[i]);
            String s = (String)objs[i];
            System.out.println(s+"--"+s.length());
        }
    }
}
