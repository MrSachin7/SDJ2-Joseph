import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerClass {
    public static void main(String[] args) throws IOException {
        final int PORT = 5678;
        System.out.println("Starting the server.........");

        ServerSocket listenSocket = new ServerSocket(PORT);
        while (true) {
            System.out.println("Waiting for clients......");

            Socket socket = listenSocket.accept();
            String client = socket.getInetAddress().getHostAddress();
            System.out.println(client+" identified");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Writers are created");

            String request = in.readLine();// take the request from the clients
            System.out.println(client + " sends " + in.readLine() + " as a request");

            if (request.equals("connect")) {
                System.out.println(client+ " has been allowed the access to the server");
                out.println("Connected to the server");

            }
            else{
                System.out.println("Disconecting........");
            }
            socket.close();
        }
    }
}
