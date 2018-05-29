package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo01 {


    public static void main(String[] args) throws Exception {

        Class aClass = Class.forName("reflection.Studnets");
        //获取所有public的构造器
        Constructor[] cons = aClass.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
        System.out.println("********************");
        //获取所有的构造器
        Constructor[] constructors = aClass.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("********************");


        //通过反射创建类
        Constructor con1 = aClass.getDeclaredConstructor(int.class, String.class, String.class);
        System.out.println(con1);
        System.out.println("-------------------");
        Object object = con1.newInstance(1, "Alice", "111111111");
        System.out.println(object.toString());

        //通过反射调用私有的构造器创建类
        Constructor con2 = aClass.getDeclaredConstructor(int.class);
        con2.setAccessible(true);                   //对于私有变量进行可访问设置
        Object obj = con2.newInstance(1);
        System.out.println(obj.toString());
        System.out.println("********************");




        Class bClass = Class.forName("reflection.Studnets");
        //获取搜友public的属性
        Field[] fields1 = bClass.getFields();
        for (Field field : fields1) {
            System.out.println(field);
        }
       System.out.println("********************");

        Field[] fields2 = bClass.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field);
        }
        System.out.println("********************");

        Constructor con3 = bClass.getConstructor();
        Object obj2 = con3.newInstance();
        Field name = bClass.getDeclaredField("name");
        name.setAccessible(true);           //对于私有变量进行可访问设置
        name.set(obj2, "xi'an");
        System.out.println(obj2);



        //获取所有的public的方法
        Class cClass = Class.forName("reflection.Studnets");
        Constructor con4 = cClass.getConstructor();
        Object obj3 = con4.newInstance();
        Method[] methods1 = cClass.getMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        System.out.println("********************");
        //获取类中自己定义的方法
        Method[] methods2 = cClass.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }
        System.out.println("********************");
        Method m1 = cClass.getMethod("test", String.class);
        m1.invoke(obj3, "test");
        System.out.println("********************");

        Method m2 = cClass.getDeclaredMethod("fun", String.class);
        m2.invoke(obj3, "fun");
        System.out.println("********************");

        Method m3 = cClass.getDeclaredMethod("method", String.class);
        m3.setAccessible(true);
        m3.invoke(obj3, "Alice");
        System.out.println("===============================");
    }//end of main
}
