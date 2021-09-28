import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        try
        {
            Socket socket = new Socket("localhost", 9089);

            ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());



            outToServer.writeObject("connect");
            while (true)
            {
                Scanner keyboard = new Scanner(System.in);
                String msg = keyboard.next();
                outToServer.writeObject(msg);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
