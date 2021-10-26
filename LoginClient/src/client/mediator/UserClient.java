package client.mediator;

import client.mediator.User;
import client.model.Model;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class UserClient implements Model {
    private Socket socket;
    private BufferedReader inFromServer;
    private PrintWriter outToServer;
    private Gson gson;
    private Scanner keyboard;

    public UserClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outToServer = new PrintWriter(socket.getOutputStream(), true);
        gson = new Gson();
        keyboard = new Scanner(System.in);

    }

    public void disconnect() throws IOException {
        System.out.println("Disconnected....");
        socket.close();
        keyboard.close();
    }

    @Override
    public void login(String userName, String password) {
        User user = new User(userName, password);
        String json = gson.toJson(user);
        outToServer.println(json);

        try {
            String replyFromServer = inFromServer.readLine();
            if (replyFromServer.startsWith("Success"))
            {
                System.out.println(replyFromServer);
                socket.close();
            }
            else
            {
                throw new IllegalStateException(replyFromServer);

            }

        } catch (IOException e) {
            System.out.println(e.getStackTrace());
        }


    }
    }

