package experiment10;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String lt = new String("联通".getBytes("GBK"),"iso-8859-1");
        System.out.println(lt);
        String lt2 = new String(lt.getBytes("iso-8859-1"),"GBK");
        System.out.println(lt2);
    }//end main
}
