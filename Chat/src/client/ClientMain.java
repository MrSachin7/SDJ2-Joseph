package client;

import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        ChatClient  chatClient= new ChatClient("localHost",9900);
        chatClient.execute();
    }


}
