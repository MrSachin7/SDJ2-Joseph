package Excercise1;

public class Test
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    CounterIncrementor c1 = new CounterIncrementor(counter, 20000);
    CounterIncrementor c2 = new CounterIncrementor(counter, 20000);

    Thread t1 = new Thread(c1);
    Thread t2 = new Thread(c2);
    t1.start();
    t2.start();
    System.out.println("Main Thread Ended");

  }
}
