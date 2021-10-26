package client.model;

import client.mediator.UserClient;

import java.io.IOException;
import java.net.InetAddress;

public class ModelManager implements Model {
    private UserClient userClient;

    public ModelManager() throws IOException {
        userClient = new UserClient(InetAddress.getLocalHost().getHostName(), 2910);
    }

    @Override
    public void login(String userName, String password) throws IllegalStateException, IllegalArgumentException {
        userClient.login(userName, password);
    }
}
