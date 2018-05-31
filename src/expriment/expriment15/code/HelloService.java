package expriment.expriment15.code;

import java.util.Date;

public interface HelloService {
    public String echo(String msg) throws RemoteException;

    public Date getTime() throws RemoteException;
}

