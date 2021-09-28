package troelsStyle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.SerializablePermission;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final int PORT =2910;
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();

        ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream outTOClient = new ObjectOutputStream(socket.getOutputStream());

        String msg =(String) inFromClient.readObject();
        System.out.println("Recieved:"+msg);
        msg=msg.toUpperCase();
        System.out.println("Sending msg: "+msg);
        outTOClient.writeObject(msg);
        System.out.println("Client disconected......");
    }
}
