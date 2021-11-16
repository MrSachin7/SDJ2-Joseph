package cookies;

import java.util.concurrent.BlockingQueue;

public class CookiesJar {
    private BlockingQueue<Cookies> queue;
    private int bakeAtATime;

    public CookiesJar(BlockingQueue<Cookies> queue, int bakeAtATime) {
        this.bakeAtATime = bakeAtATime;
        this.queue = queue;
    }

    public BlockingQueue<Cookies> getQueue() {
        return queue;
    }

    public void startBaking(int number) {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finishedBaking(number);

    }

    private void finishedBaking(int number) {
        for (int i = 0; i < number; i++) {
            Cookies cookies = new Cookies(i);
            System.out.println(cookies.getType() + " is made");
            try {
                queue.put(cookies);
                System.out.println("The current number of cookies :" + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void eat() {
        try {
            Cookies cookies = queue.take();
            System.out.println(cookies.getType() + " is being eaten");
            System.out.println("The current number of cookies :" + queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
