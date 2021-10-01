package server.mediator;

import server.model.Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class UserServer implements Runnable {
    private static int PORT = 2910;
    private boolean running;
    private ServerSocket welcomeSocket;
    private Model model;

    public UserServer(Model model) throws IOException {
        this.model = model;
        welcomeSocket = new ServerSocket(PORT);
    }

    @Override
    public void run() {
        System.out.println("Waiting for clients....");
        while (true) {

            try {
                Socket clientSocket = welcomeSocket.accept();
                UserClientHandler userClientHandler = new UserClientHandler(clientSocket, model);
                System.out.println(clientSocket.getInetAddress().getHostAddress()+" identified");
                Thread t1 = new Thread(userClientHandler);
                t1.start();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
