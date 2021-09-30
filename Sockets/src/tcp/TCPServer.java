package tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 5678;
        System.out.println("Starting server.....");

        // create a server socket at port 6789 listening for clients

        ServerSocket listenSocket = new ServerSocket(PORT);
        while (true) {
            System.out.println("Waiting for a client ....");

            // We accept a client thus creating a new Socket
            Socket socket = listenSocket.accept();
            String client = socket.getInetAddress().getHostAddress();
            System.out.println(client+" identified");

            //create an input stream attached to the socket
            //InputStream , Input Stream reader , BufferedReader
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //create an output stream
            PrintWriter outWriter = new PrintWriter(socket.getOutputStream(), true);

            //read a line from the client
            String request = in.readLine();
            System.out.println("Client> " + request);

           if (request.equals("connect")) {
                outWriter.println("Username ??");
                System.out.println( client+" has typed    "+in.readLine());



                outWriter.println("Password ??");
                System.out.println(client+" has typed    "+in.readLine());

                outWriter.println("approved");

            }
           else
           {
               System.out.println("Disconnected.....");
           }

            socket.close();
        }
    }
}
