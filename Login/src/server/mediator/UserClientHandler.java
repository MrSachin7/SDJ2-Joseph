package server.mediator;

import com.google.gson.Gson;
import server.model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UserClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader inFromClient;
    private PrintWriter outToClient;
    private boolean running;
    private Gson gson;
    private String clientIP;
    private Model model;

    public UserClientHandler(Socket socket, Model model) throws IOException {
        this.socket = socket;
        this.model = model;
        inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outToClient = new PrintWriter(socket.getOutputStream(), true);
        gson = new Gson();
    }

    @Override
    public void run() {
        try {
            String data = inFromClient.readLine();
            System.out.println("JSON received from client:"+data);
            UserPackage userPackage = gson.fromJson(data, UserPackage.class);
            try {
                model.addUser(userPackage.getUser(), userPackage.getPassword());
                String s ="Success : you are now logged in ";
                outToClient.println(s);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
                outToClient.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                outToClient.println(e.getMessage());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
