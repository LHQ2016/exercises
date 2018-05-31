package expriment.expriment15.code;

public class SimpleClient {
    public static void main(String args[]) throws Exception {
        //创建静态代理类实例
        HelloService helloService1 = new HelloServiceProxy("localhost", 8000);
        System.out.println(helloService1.echo("hello"));
        System.out.println(helloService1.getTime());

    }
}