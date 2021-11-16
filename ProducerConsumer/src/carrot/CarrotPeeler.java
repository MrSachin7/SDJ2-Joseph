package carrot;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class CarrotPeeler implements Runnable{

    private BlockingQueue<Carrot> queue;

    public CarrotPeeler(BlockingQueue<Carrot> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true){
               Carrot carrot = peelCarrot();
               queue.put(carrot);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Carrot peelCarrot() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Carrot("DK-carrot"+ ThreadLocalRandom.current().nextInt(1,99));
    }
}
