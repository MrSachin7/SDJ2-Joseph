package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteTaskList extends Remote {
    void addTask(Task task) throws RemoteException;
    Task get() throws  RemoteException;
    int size() throws RemoteException;
}
