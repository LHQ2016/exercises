package reflection.proxytest;
/**
 * 动态代理模式
 */

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        UserDao user = new UserImpl();
        user.add();
        user.delete();
        user.update();
        user.find();
        System.out.println("===============================");

        MyInvocationHandler handler = new MyInvocationHandler(user);
        UserDao proxy = (UserDao) Proxy.newProxyInstance(user.getClass().getClassLoader(), user.getClass().getInterfaces(), handler);
        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.find();


    }//end of main

}
