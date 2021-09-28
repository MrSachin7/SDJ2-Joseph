package troelsStyle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final int PORT = 2910;
        final String HOST ="localhost";

        Socket socket = new Socket(HOST,PORT);

        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

        Scanner keyboard = new Scanner(System.in);
        String msg = keyboard.nextLine();

        outToServer.writeObject(msg);
        String response =(String) inFromServer.readObject();
        System.out.println(response);

    }
}
