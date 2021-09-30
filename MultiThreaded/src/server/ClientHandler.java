package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private ObjectInputStream inFromClient ;
    private ObjectOutputStream outToClient;

    public ClientHandler (Socket socket) throws IOException {
        //create input and output streams attached to the socket
        inFromClient = new ObjectInputStream(socket.getInputStream());
        outToClient = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        // read from client
        try {
            String request = (String) inFromClient.readObject();
            System.out.println("Client> "+ request);
            String reply = request.toUpperCase();
            System.out.println("Server> "+reply);
            outToClient.writeObject(reply);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
