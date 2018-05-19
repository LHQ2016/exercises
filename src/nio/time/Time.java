package nio.time;

public class Time {
    public static void main(String[] args) {
        int port = 8000;
        if (args != null && args.length > 0){
            try{
                port  = Integer.valueOf(args[0]);
            }catch(NumberFormatException e){

            }
        }
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);
        new Thread(timeServer).start();


    }//end of main
}
