package collection.Demo01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("abc1");
        list.add("abc2");
        list.add("abc3");
        list.add("abc4");
        list.add("abc5");
        list.add("abc6");

        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if ("abc1".equals(listIterator.next())) {
                listIterator.add("abc7");
            }
        }
        list.trimToSize();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
