package server;

import server.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPMultiThreadedServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 6789;
        System.out.println("Server has been started ....");

        // create the listening/Server socket at port 6789
        ServerSocket welcomeSocket = new ServerSocket(PORT);
        System.out.println("Waiting for clients........");

        while (true) {
            //wait, on listening socket for contact by client
            Socket socket = welcomeSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket);
            Thread t = new Thread(clientHandler);
            t.start();
        }

    }
}
