package client.mediator;

import client.model.Model;
import client.model.ModelManager;

import java.io.IOException;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) throws IOException {
        Model model = new ModelManager();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter your name");
        String username = keyboard.nextLine();

        System.out.println("Enter the password");
        String password = keyboard.nextLine();
        try {
            model.login(username, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Do you want to enter again ??");
            if (keyboard.nextLine().toUpperCase().equals("YES"))
            {
                main(null);
            }
        }
    }
}
