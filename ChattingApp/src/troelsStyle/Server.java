package troelsStyle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final int PORT = 2810;
        ArrayList<String> log = new ArrayList<>();
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
            while (!msg.toUpperCase().equals("EXIT")) {;

                msg =(String) inFromClient.readObject();
                log.add(msg);
                System.out.println(log.get(log.size()-1));
            }
        }
        else
        {
            outTOClient.writeObject("Wrong secret code, you are disconnected");
            serverSocket.close();
        }
    }
}
