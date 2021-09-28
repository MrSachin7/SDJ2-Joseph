package tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        final int PORT = 6789;
        System.out.println("Starting server.....");

        // create a server socket at port 6789 listening for clients

        ServerSocket listenSocket = new ServerSocket(PORT);
        while (true) {
            System.out.println("Waiting for a client ....");

            // We accept a client thus creating a new Socket
            Socket socket = listenSocket.accept();

            //create an input stream attached to the socket
            //InputStream , Input Stream reader , BufferedReader
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //create an output stream
            PrintWriter outWriter = new PrintWriter(socket.getOutputStream(), true);

            //read a line from the client
            String request = in.readLine();
            System.out.println("Client> " + request);
            String reply = request.toUpperCase();
              // send line to client
            System.out.println("Server> " + reply);
            outWriter.print(reply);
             //loop back and wait for another client connection

        }
    }
}
