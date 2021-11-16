import java.util.Scanner;

public class ClientApp {
    public static void main(String[] args) {
        RMICallBackClient client = new RMICallBackClient();

        Scanner keyboard = new Scanner(System.in);
        while(true){
            System.out.println("Enter a message you want to send to the server.\"exit\" to exit the program");
            String text = keyboard.nextLine();
            if (text.equals("exit")){
                System.out.println("Disconnecting......");
                break;
            }
            client.send(text);
        }
        keyboard.close();
        System.exit(0);
    }
}
