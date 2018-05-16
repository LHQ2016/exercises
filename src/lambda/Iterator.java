package lambda;

import java.util.ArrayList;

/**
 * lambda表达式在集合中的应用
 */
public class Iterator<S> {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }//end for

        list.forEach(x-> System.out.print(x+", "));
        System.out.println();

//        list.forEach(System.out::println);
    }//end main
}
