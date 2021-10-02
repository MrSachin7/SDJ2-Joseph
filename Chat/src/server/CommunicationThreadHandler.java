package server;

import client.Message;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CommunicationThreadHandler implements Runnable {

    private BufferedReader inFromClient;
    private PrintWriter outToClient;
    private Socket socket;
    private String ip;
    private Gson gson;

    public CommunicationThreadHandler(Socket socket) throws IOException {
        this.socket = socket;
        inFromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        outToClient = new PrintWriter(socket.getOutputStream(), true);
        ip = socket.getInetAddress().getHostAddress();
        gson = new Gson();
    }

    @Override
    public void run() {

        while (true) {

            try {
                String json = inFromClient.readLine();
                System.out.println("JSON from " + ip + " " + json);
                Message message = gson.fromJson(json, Message.class);
                System.out.println(message.getBody());
                if (message.getBody().toUpperCase().equals("EXIT")) {
                    outToClient.println("Disconecting......");
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
     /*  try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }**/
    }
}

