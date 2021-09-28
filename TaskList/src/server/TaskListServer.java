package server;

import server.TaskListCommunicationThreadHandler;
import task.TaskList;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TaskListServer {
    private ServerSocket welcomeSocket;
    private int port;
    private TaskList taskList;

    public TaskListServer(TaskList taskList, int port) throws IOException {
        this.taskList=taskList;
        this.port=port;
        welcomeSocket = new ServerSocket(port);
        System.out.println("Server Started.........");
    }
    public void execute()
    {
        while (true){
            try {
                Socket clientSocket = welcomeSocket.accept();
                TaskListCommunicationThreadHandler taskListCommunicationThreadHandler = new TaskListCommunicationThreadHandler(clientSocket,taskList);
                Thread thread = new Thread(taskListCommunicationThreadHandler);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
