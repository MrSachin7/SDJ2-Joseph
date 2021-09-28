import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server
{
    public static void main(String[] args)
    {
        try {
            ServerSocket welcomeSocket = new ServerSocket(9089);
            System.out.println("Server started");

            Socket socket = welcomeSocket.accept();

            ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());

            ArrayList<String> list = new ArrayList<String>();

            String connect = (String) inFromClient.readObject();
            if ("connect".equals(connect))
            {
                System.out.println("Received from client: " + connect);
                outToClient.writeObject("Connected");

                while (true)
                {
                    Scanner keyboard = new Scanner(System.in);
                    String msg = (String) inFromClient.readObject();
                    System.out.println(msg);
                    list.add(msg);
                    System.out.println(list);
                    if("exit".equals(msg))
                    {
                        socket.close();
                    }
                }
            }

            else
            {
                outToClient.writeObject("Disconnected");
                socket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
