import com.sun.management.HotSpotDiagnosticMXBean;

import java.io.IOException;
import java.net.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Handler;

public class Client {
    public static void main(String[] args) throws IOException {
        final int PORT =9099;
        final String HOST = "localhost";

        Scanner keyboard = new Scanner(System.in);

        // create a client socket
        DatagramSocket clientSocket = new DatagramSocket();

        //Translate the hostname to IP using DNS
        InetAddress IPAddress =InetAddress.getByName(HOST);
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        System.out.println("Write the line for the server...");
        String sentence = keyboard.nextLine();
        System.out.println("Client > "+sentence);
        sendData =sentence.getBytes();

        //create a datagram with data-to-send ,length IP Address and port
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,PORT);

        //send datagram to server
        clientSocket.send(sendPacket);

        //Read datagram fro server
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedString = new String(receivePacket.getData()).trim();
        System.out.println("Server > "+modifiedString);
        clientSocket.close();

    }
}
