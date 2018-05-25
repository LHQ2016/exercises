package reflection;

import java.lang.reflect.Method;

public class DumpMethods {
    public static void main(String[] args) {
        Class classType = null;
        try {
            classType = Class.forName(args[0]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method methods[] = classType.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].toString());
        }//end of for
    }//end of main
}
