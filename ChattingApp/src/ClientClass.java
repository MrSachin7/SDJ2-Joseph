import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientClass {
    public static void main(String[] args) throws IOException {
        final int PORT = 5678;
        final String HOST = "localhost";

        Scanner keyboard = new Scanner(System.in);

        Socket clientSocket = new Socket(HOST, PORT);

        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        PrintWriter outToServer = new PrintWriter(clientSocket.getOutputStream());

        System.out.println("Write a secret line to access the server");
        String request = keyboard.nextLine();

        System.out.println("Client -> " + request);
        outToServer.println(request); // sending the request to the server to verify

        System.out.println(inFromServer.readLine()); // in.readline () is the response from server

        String message = "";

        while (!message.toUpperCase().equals("EXIT")) {
            System.out.println("Enter the messsage for server");
            message = keyboard.nextLine();
            outToServer.println(message);
        }
    }
}
