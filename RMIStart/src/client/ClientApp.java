package client;

import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) throws RemoteException {
        RMICaseClient client = new RMICaseClient();

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a string to convert to uppercase");
        String text = keyboard.nextLine();
        System.out.println("Uppercase "+(client.convert(text,true)));

        System.out.println("Enter a string to capitalize the first letter");
        text= keyboard.nextLine();
        System.out.println("Capitalized first letter "+client.convert(text,false));
    }
}
