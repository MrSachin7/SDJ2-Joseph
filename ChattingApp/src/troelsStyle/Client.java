package troelsStyle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final int PORT = 2810;
        final String HOST = "localhost";

        Socket socket = new Socket(HOST, PORT);

        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Write the secret code to enter the server");
        String msg = keyboard.nextLine();
        outToServer.writeObject(msg);
        System.out.println(inFromServer.readObject());
        while (true)
        {
            System.out.println("Enter message if any");
            msg = keyboard.nextLine();
            outToServer.writeObject(msg);
        }
    }
}
