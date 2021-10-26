import java.rmi.Remote;

public interface RemoteSender extends Remote {
    void replyMessage(String message);
}
