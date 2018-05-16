package stringDemo;

/**
 *
 */
public class SimpleFormat {
    public static void main(String[] args) {
        int x = 5;
        double y = 5.123456789;
        String string ="123456789";
        System.out.printf("[%.10s]\n",string);
        System.out.println("Row 1 : [" + x + " " + y + "]");
        System.out.printf("Row 1 : [%d %f]\n", x, y);
        System.out.format("Row 1 : [%d %5.2f]\n", x, y);
        System.out.format("Row 1 : [%d %-5.2f]\n", x, y);

    }
}
