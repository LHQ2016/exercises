package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("172.20.66.55");
        String name = inetAddress.getHostName();
        String ip = inetAddress.getHostAddress();
        String ip1 = inetAddress.getCanonicalHostName();
//        byte[] bytes = inetAddress.getAddress();
        System.out.println(name+"---"+ip+"---"+ip1);
    }

}
