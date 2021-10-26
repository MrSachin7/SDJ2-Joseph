package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

public class ServerApp {

    public static void main(String[] args) throws RemoteException {
        // start the RMI Registry
        startRegistry();
        RMICaseServer server = new RMICaseServer();
        server.start();
        System.out.println("Server started...");
    }

    private static void startRegistry() throws RemoteException {
        try {
           Registry registry= LocateRegistry.createRegistry(1099);
        } catch (ExportException e) {
            System.out.println("Registry is already started"+e.getMessage());
        }

    }
}
