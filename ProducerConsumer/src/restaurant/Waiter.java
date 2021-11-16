package restaurant;

import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable {
    private BlockingQueue<Customer> queue;

    public Waiter(BlockingQueue<Customer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Customer customer = new Customer("");
            while (!customer.getName().equalsIgnoreCase("Receptionist")){
                //take --waits if it is empty
                customer= queue.take();
                if (customer !=null){
                    System.out.println(customer.getName()+" is received. Taking him to table ...");
                    System.out.println("---------------------------------------------------");
                }
            }
            System.out.println("All customers have been received..");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
