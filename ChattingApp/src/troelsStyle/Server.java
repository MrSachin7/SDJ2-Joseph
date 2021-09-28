package troelsStyle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final int PORT = 2810;
        System.out.println("Server started.........");
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket socket = serverSocket.accept();
        String client = socket.getInetAddress().getHostAddress();
        System.out.println(client + " identified");

        ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream outTOClient = new ObjectOutputStream(socket.getOutputStream());

        String msg = (String) inFromClient.readObject();
        if (msg.equals("connect")) {
            System.out.println(client + " has now been given access to the server");
            outTOClient.writeObject("Server connected");
            while (!msg.toUpperCase().equals("EXIT")) {
                System.out.println(client+" sent "+msg);
                msg =(String) inFromClient.readObject();
            }
        }
        else
        {
            outTOClient.writeObject("Wrong secret code, you are disconnected");
            socket.close();
        }
    }
}
