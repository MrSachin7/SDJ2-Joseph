package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    private ServerSocket welcomeSocket;
    private CommunicationThreadHandler communicationThreadHandler;

    public ChatServer(int port) throws IOException {
        welcomeSocket= new ServerSocket(port);
        System.out.println("Server started.....");


    }

    public void execute() throws IOException {
        while(true){
            Socket clientSocket = welcomeSocket.accept();
            communicationThreadHandler = new CommunicationThreadHandler(clientSocket);
            System.out.println(clientSocket.getInetAddress().getHostAddress()+"  identified");
            Thread t1 = new Thread(communicationThreadHandler);
            t1.start();
        }

    }
}
