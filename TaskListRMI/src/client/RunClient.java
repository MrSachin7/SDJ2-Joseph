package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RunClient {
    public static void main(String[] args) throws NotBoundException, RemoteException {
        String host = "localhost";
        if (args.length > 0) {
            host = args[0];
        }
        RMITaskClient client = new RMITaskClient(host);
        client.start();
    }
}
