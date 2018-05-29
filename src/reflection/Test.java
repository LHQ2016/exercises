package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 西安ArrayList<Integer>中添加一个字符串
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        list.add(1);
        list.add(2);
        System.out.println(list);

        Class aClass = list.getClass();
        Method method = aClass.getMethod("add", Object.class);
        method.invoke(list, "string");
        method.invoke(list, 4.3);
        method.invoke(list, true);
        System.out.println(list);

    }//end of main
}
