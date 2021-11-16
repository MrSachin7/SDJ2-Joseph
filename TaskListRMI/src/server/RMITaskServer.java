package server;

import shared.RemoteTaskList;
import shared.Task;
import shared.TaskList;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMITaskServer implements RemoteTaskList {

    private TaskList taskList;

    public RMITaskServer() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        taskList = new TaskList();
    }

    @Override
    public void addTask(Task task) throws RemoteException {
        taskList.add(task);
    }

    @Override
    public Task get() throws RemoteException {
        return taskList.getAndRemoveNextTask();
    }

    @Override
    public int size() throws RemoteException {
        return taskList.size();
    }
}
