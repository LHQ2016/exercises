package stringDemo.regex;

import java.util.Arrays;

public class Replacing {
    public static String knights =
            "Then, when you have found the shrubbery, you must" +
                    " cut down the mighties tree the forst..." +
                    "with... a herring.";

    public static void main(String[] args) {
        System.out.println(knights.replaceFirst("f\\w+","located"));
        System.out.println(knights.replaceAll("f\\w+","located"));
        System.out.println(knights.replaceAll("shrubbery|tree|herring","banana"));
        System.out.println(knights.matches("^[A-Z].*[\\.]$"));
        //.为任意字符，\\.为句号
        System.out.println(knights.replaceAll("[aeiou]","_"));
        System.out.println(knights);
        String[] strings = knights.split("you|the");
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + "/");
        }
    }


}
