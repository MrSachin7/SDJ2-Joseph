package cookies;

public class CookiesEater implements Runnable {
    private CookiesJar cookiesJar;

    public CookiesEater(CookiesJar cookiesJar) {
        this.cookiesJar = cookiesJar;
    }

    @Override
    public void run() {
        while (true) {
            cookiesJar.eat();
        }
    }
}
