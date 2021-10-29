import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerApp {
    public static void main(String[] args) throws MalformedURLException, RemoteException {
        startRegistry();
        RMIServer server = new RMIServer();
        server.start();
        System.out.println("Server started....");
    }

    private static void startRegistry() {
        try {
            LocateRegistry.createRegistry(1099);
        } catch (RemoteException e) {
            System.out.println("Registry already exists");
        }
    }
}
