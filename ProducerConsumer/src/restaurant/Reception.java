package restaurant;

import java.util.concurrent.BlockingQueue;

public class Reception implements Runnable {
    BlockingQueue<Customer> queue;

    public Reception(BlockingQueue<Customer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        String[] customers = {"Alfonso", "Adrian", "Benjamin","Receptionist", "Christopher", "Emil", "Juraj", "Khaled",  "Mihai", "Sachin","a","b"};
        System.out.println(customers.length+" customers waiting initially");
        for (String c : customers
        ) {
            Customer customer = new Customer(c);
            try {
                Thread.sleep(1000);
                queue.put(customer);
                System.out.println(customer.getName()+" is put in the queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // no more customers to put in the queue , receptionist can go and eat...
        System.out.println("No more customers to put in the queue");
    }
}
