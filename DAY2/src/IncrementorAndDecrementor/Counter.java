package IncrementorAndDecrementor;

public class Counter
{
  private long value;
  private long max;
  private long min;

  public Counter(long min,long max)
  {
    this.min=min;
    this.max=max;
    value=0;
  }
  public synchronized void increment()
  {
    while (value>=max)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

    }
    value++;
    notifyAll();
    System.out.println(value+": "+Thread.currentThread().getName());
  }
  public synchronized void decrement()
  {
    while(value<=min)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    value=value-1;
    notifyAll();
    System.out.println(value+": "+Thread.currentThread().getName());
  }

  public long getValue()
  {
    return value;
  }
}
