package Practise;
public class Count implements Runnable
{
  int value;

  public synchronized void increment()
  {
    value++;
  }
  public void run()
  {
    for (int i =0; i<0; i++)
    {
      increment();
      System.out.println(Thread.currentThread().getName()+" added one , new value :"+ value);
    }

  }

  public static void main(String[] args)
  {
    Count c1 = new Count();
    Thread t1 = new Thread(c1,"Thread 1 ");
    Thread t2 = new Thread(c1,"Thread 2");
    t1.start();
    t2.start();
  }
}
