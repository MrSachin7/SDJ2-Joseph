package server;

import task.TaskList;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();
        try {
            TaskListServer taskListServer = new TaskListServer(taskList,8908);
            taskListServer.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
