package server;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException, UnknownHostException {
        final int PORT = 5678;
        final String HOST = "localhost";

        //create a scanner to get input from user
        Scanner keyboard = new Scanner(System.in);

        //create a client socket and connect to the server
        Socket clientSocket = new Socket(HOST, PORT);

        // create an input stream attached to the socket
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        // create an output stream attached to the socket
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

        // read a line from a user input
        System.out.println("Write a line for the server: ");

        // take a request from keyboard
        String request = keyboard.nextLine();
        System.out.println("Client> " + request);
        //send the line to server
        out.println(request);

        System.out.println(in.readLine());
        //read line from the server
        String reply = keyboard.nextLine();
        System.out.println(reply);
        //send to the server again
        out.println(reply);
        System.out.println(in.readLine());

        String username =keyboard.nextLine();
        System.out.println("Client> "+username);
        out.println(username);
        System.out.println(in.readLine());

       String password=keyboard.nextLine();
        out.println(password);


        System.out.println("Test "+in.readLine());
        if (in.readLine().equals("Approved"))
        {
            clientSocket.close();
        }

    }
}
