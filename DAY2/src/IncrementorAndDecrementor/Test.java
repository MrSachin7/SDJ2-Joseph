package IncrementorAndDecrementor;

public class Test
{
  public static void main(String[] args)
  {
    Counter counter= new Counter(0,10);
    CounterIncrementer ci1= new CounterIncrementer(counter,200);
    CounterIncrementer ci2= new CounterIncrementer(counter,200);
    CounterDecrementer cd1 = new CounterDecrementer(counter,200);
    CounterDecrementer cd2 = new CounterDecrementer(counter,200);
    Thread t1= new Thread(ci1,"FirstIncrementer");
    Thread t2 = new Thread(ci2,"SecondIncrementer");
    Thread t3 = new Thread(cd1, "FirstDecrementer");
    Thread t4 = new Thread(cd2 ,"SecondDecrementer");


    t3.start();
    t4.start();
    t1.start();
    t2.start();
  }
}
