package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TaskListClient {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner keyboard;

    public TaskListClient(String host, int port) {
        try {
            socket = new Socket(host, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            keyboard = new Scanner(System.in);
            execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void execute() throws IOException {
        while (true) {
            System.out.println("Enter the function you want to do on server");
            String request = keyboard.nextLine();
            out.writeUTF(request);

            if (request.toUpperCase().equals("ADD")) {
                try {
                    System.out.println(in.readUTF());
                    String taskString = keyboard.nextLine();
                    out.writeUTF(taskString);

                    System.out.println(in.readUTF());
                    long taskLong = keyboard.nextLong();
                    keyboard.nextLine();
                    out.writeLong(taskLong);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            else if (request.toUpperCase().equals("GET"))
            {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            else if (request.toUpperCase().equals("SIZE"))
            {
                try {
                    System.out.println(in.readUTF());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else{
                System.out.println(in.readUTF());
                socket.close();
                break;
            }
        }
    }
}
