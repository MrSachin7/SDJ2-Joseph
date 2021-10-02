package client;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private Scanner keyboard;
    private BufferedReader inFromServer;
    private PrintWriter outToServer;
    private Socket socket;
    private Gson gson;

    public ChatClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outToServer = new PrintWriter(socket.getOutputStream(), true);
        keyboard = new Scanner(System.in);
        gson= new Gson();

    }

    public void execute() throws IOException {
        while (true) {
            System.out.println("Enter the message body to send to the server...");
            String messageBody = keyboard.nextLine();
            Message message = new Message(messageBody);
            System.out.println(message);
            String messageJSON = gson.toJson(message);
            outToServer.println(messageJSON);
            if (messageBody.toUpperCase().equals("EXIT"))
            {

                break;
            }
        }
        close();
    }

    public void close() throws IOException {
        socket.close();
        keyboard.close();
    }
}
