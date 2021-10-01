package server.mediator;

import server.model.Model;
import server.model.ModelManager;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException {

        Model model = new ModelManager();
        UserServer userServer = new UserServer(model);
        Thread thread = new Thread(userServer);
        thread.start();
    }
}
