package Excercise1;

public class Counter
{
  private long value;

  public Counter()
  {
    value = 0;
  }

 /** public void increment()
  {
    value++;
  }

  public long getValue()
  {
    return value;
  }
  public synchronized void increment()                 //This synchronizes the entire method
  {
    value++;
  }

  public synchronized long getValue()
  {
    return value;
  }**/
 public void increment()
 {
   synchronized (this)                          //This synchronizes the block of code inside the brackets
   {
     value++ ;
   }

 }

  public long getValue()
  {
    synchronized (this)
    {
      return value;
    }

  }
}
