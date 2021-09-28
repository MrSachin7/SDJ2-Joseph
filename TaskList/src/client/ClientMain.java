package client;

import java.io.IOException;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        TaskListClient taskListClient = new TaskListClient("localhost",8908);
        taskListClient.execute();
    }
}
