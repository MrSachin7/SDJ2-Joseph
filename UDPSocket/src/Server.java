import java.awt.desktop.UserSessionEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Locale;

public class Server {
    public static void main(String[] args) {
        final int PORT =9099;
        System.out.println("Starting server.....");

        try {
            DatagramSocket serverSocket = new DatagramSocket(PORT);
            while (true) {
                System.out.println("Waiting for client ....");

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);

                //recieve datagram from a client

                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData()).trim();
                InetAddress IPAdress = receivePacket.getAddress();
                int port =receivePacket.getPort();

                System.out.println("Client> "+sentence);
                String capitalizedSentence = sentence.toUpperCase();
                System.out.println("Server> "+capitalizedSentence);

                byte[] sendData = new byte[1024];
                sendData=capitalizedSentence.getBytes();

                // create datagram to send to the client
                DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAdress,port);
                serverSocket.send(sendPacket);
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
