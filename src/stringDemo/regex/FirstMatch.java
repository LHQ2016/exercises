package stringDemo.regex;
import java.util.regex.*;

public class FirstMatch {
    public static void main(String[] args) {
        String strings = "123456789";
        System.out.println(strings.matches("[0-9]*"));

    }
}
