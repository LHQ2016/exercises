package io.stream;

public class Name {
    public static void main(String[] args) {
        String string = "this is java";
        String name;
        name = removeCharAt(string,3);
        System.out.println(name);
    }
    public static String removeCharAt(String s, int pos) {
        return s.substring(0, pos) + s.substring(pos + 1);
    }
}
