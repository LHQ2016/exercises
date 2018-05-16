package interest;

public class TestTryFinally {
    public static void main(String[] args) {
        try{
            System.out.println("Hello World");
            System.exit(0);
        }finally{
            System.out.println("Goodbye World");
        }
    }
}
