package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextConverter extends Remote {
    String toUpperCase(String text) throws RemoteException;
    String capitalizeFirstCharacter(String text) throws RemoteException;
}
