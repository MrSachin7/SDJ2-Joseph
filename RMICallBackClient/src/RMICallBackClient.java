import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMICallBackClient implements RemoteSender {
    private RemoteMessageList serverStub;

    public RMICallBackClient() {
        try {
            UnicastRemoteObject.exportObject(this, 0);
            serverStub = (RemoteMessageList) Naming.lookup("rmi://localhost:1099/Add");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public void send(String text) {
        try {
            serverStub.addMessage(text, this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void replyMessage(String message) {
        System.out.println(message);
    }
}
