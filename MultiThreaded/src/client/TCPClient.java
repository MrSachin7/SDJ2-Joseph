package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InetAddress host = InetAddress.getLocalHost();

        //create client socket and connect to server
        Socket socket = new Socket(host.getHostName(), 6789);

        // create input to read something from keyboard

        Scanner keyboard = new Scanner(System.in);
        ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());


        // read user input
        System.out.println("Write a secret code of the server in order to connect to this precious server......");
        String request = keyboard.nextLine();
        System.out.println(request + " has been send to the extremely precious server. Waiting for the response..");
        outToServer.writeObject(request);

        // read from the server
        String reply = (String) inFromServer.readObject();
        System.out.println("The server responded : " + reply);
        socket.close();

    }
}
