package client;

import server.RMITaskServer;
import shared.RemoteTaskList;
import shared.Task;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RMITaskClient {
    private RemoteTaskList server;

    public RMITaskClient(String host) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(host,1099);
        server = (RemoteTaskList) registry.lookup("TaskServer");
    }

    public void start() throws RemoteException {
        Scanner keyboard = new Scanner(System.in);
        while (true){
            System.out.println("What do you want to do ?? Enter ....");
            System.out.println("\"add\" to add task,\"size\" to get Size of the taskList, \"get\" to get and remove the first task,\"exit\" to exit....");
            String input = keyboard.nextLine();

            if (input.equalsIgnoreCase("exit")){
                break;
            }
            else if (input.equalsIgnoreCase("add")){
                System.out.println("Enter a task you want to add");
                String text = keyboard.nextLine();
                System.out.println("Enter the estimated time(long)");
                long estimatedTime = 0;
                try {
                    estimatedTime = keyboard.nextLong();
                } catch (InputMismatchException e) {
                    System.out.println("Enter a value that is long");
                }
                keyboard.nextLine();
                try {
                    server.addTask(new Task(text,estimatedTime));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            else if (input.equalsIgnoreCase("size")){
                try {
                    System.out.println(server.size());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            else if (input.equalsIgnoreCase("get")){
                System.out.println(server.get());
            }

        }
        keyboard.close();
        System.exit(0);
    }

}
