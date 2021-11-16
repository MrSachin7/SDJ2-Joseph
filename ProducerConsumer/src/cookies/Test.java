package cookies;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    public static void main(String[] args) {
        BlockingQueue<Cookies> queue = new LinkedBlockingQueue<>(5);
        CookiesJar cookiesJar = new CookiesJar(queue,16);
        new Thread(new CookieBaker(cookiesJar)).start();
        for (int i = 0; i < 10; i++) {
            new Thread(new CookiesEater(cookiesJar)).start();
        }

    }


}
