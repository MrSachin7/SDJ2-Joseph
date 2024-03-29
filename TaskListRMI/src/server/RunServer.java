package server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        RMITaskServer server = new RMITaskServer();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("TaskServer",server);
        System.out.println("Server has been started....");
    }

}
