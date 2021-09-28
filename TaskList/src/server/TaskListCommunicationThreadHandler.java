package server;

import task.Task;
import task.TaskList;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TaskListCommunicationThreadHandler implements Runnable {

    private DataInputStream in;
    private DataOutputStream out;
    private String ip;
    private TaskList tasks;
    private Socket socket;

    public TaskListCommunicationThreadHandler(Socket socket, TaskList tasks) throws IOException {
        this.tasks = tasks;
        this.socket = socket;
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
    }


    @Override
    public void run() {

        while (true) {
            try {
                String request = in.readUTF();
                if (request.toUpperCase().equals("ADD")) {
                    System.out.println("The client wants to add a task");
                    out.writeUTF("Enter the task String");
                    String taskString = in.readUTF();                        // reads taskString from the client..
                    out.writeUTF(" Enter task time as long");
                    long taskTime = in.readLong();
                    tasks.add(new Task(taskString, taskTime));
                    System.out.println("New task is added");

                } else if (request.toUpperCase().equals("SIZE")) {
                    out.writeUTF("task size " + tasks.size());
                } else if (request.toUpperCase().equals("GET")) {
                    if (tasks.size()==0){
                        out.writeUTF("Error, nothing in the list");
                    }
                    else{
                        Task temp = tasks.getAndRemoveNextTask();
                        out.writeUTF("task String: " + temp.getText() + "\ntask time: " + temp.getEstimatedTime());
                    }

                } else {
                    out.writeUTF("Disconnecting......");
                    socket.close();
                    break;

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
