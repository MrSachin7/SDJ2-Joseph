package server;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer(9900);
        chatServer.execute();
    }


}
