package client;

import server.TextConverter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMICaseClient {
    private TextConverter serverStub;

    public RMICaseClient(){
        try {
           serverStub= (TextConverter) Naming.lookup("rmi://localhost:1099/Case");
        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public String convert(String text, boolean upper)throws RemoteException{
        if (upper){
            return serverStub.toUpperCase(text);
        }
        return serverStub.capitalizeFirstCharacter(text);
    }
}
