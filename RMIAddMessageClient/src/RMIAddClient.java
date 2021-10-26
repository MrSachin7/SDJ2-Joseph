import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RMIAddClient {
    private RemoteMessageList serverStub;

    public RMIAddClient (){
        try {
            serverStub=(RemoteMessageList) Naming.lookup("rmi://localhost:1099/Add");

        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
    public void send(String text) {
        try {
            serverStub.addMessage(text);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
