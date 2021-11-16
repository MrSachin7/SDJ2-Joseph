package cookies;

import java.util.concurrent.BlockingQueue;

public class CookieBaker implements Runnable{


    private CookiesJar cookiesJar;

    public CookieBaker(CookiesJar cookiesJar) {
        this.cookiesJar=cookiesJar;
    }


    @Override
    public void run() {
        while (true){
          cookiesJar.startBaking(16);
        }
    }
}
