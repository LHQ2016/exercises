package interest;

public class ReturnValue {
    public static void main(String[] args) {
        System.out.println(decision());
    }

    private static boolean decision() {
        try{
            return true;
        }finally{
            return false;
        }
    }


}
