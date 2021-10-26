import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RMIServer implements RemoteMessageList{
    private ArrayList<String> messageList;

    public RMIServer(){
        this.messageList= new ArrayList<>();
    }

    public void start() throws RemoteException, MalformedURLException {
        UnicastRemoteObject.exportObject(this,0);
        Naming.rebind("Add",this);

    }

    @Override
    public void addMessage(String message,RemoteSender sender) throws RemoteException {
        messageList.add(message);
        System.out.println(message+" has been added to the list");
        sender.replyMessage("Thanks for the message, The received message was :\n"+message);
    }
}
