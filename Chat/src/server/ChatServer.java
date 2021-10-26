package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private ServerSocket welcomeSocket;

    public ChatServer(int port) throws IOException {
        welcomeSocket= new ServerSocket(port);
        System.out.println("Server started.....");


    }

    public void execute() throws IOException {
        List<CommunicationThreadHandler> handlers = new ArrayList<>();
        while(true){
            Socket clientSocket = welcomeSocket.accept();
            CommunicationThreadHandler communicationThreadHandler = new CommunicationThreadHandler(clientSocket, handlers);
            handlers.add(communicationThreadHandler);
            System.out.println(clientSocket.getInetAddress().getHostAddress()+"  identified");
            Thread t1 = new Thread(communicationThreadHandler);
            t1.start();
        }

    }
}
