package AlcoholIsInjuriousToHealth;

public class Customer implements Runnable
{
  private String name;
  private Bar bar;

  public Customer(String name , Bar bar)
  {
    this.name = name;
    this.bar= bar;
}
  public void run()
  {
    while(true)
    {
      bar.takeBeer();
      sleepATimer();
    }

  }
private void sleepATimer()
{
  try
  {
    Thread.sleep(2000);
  }
  catch (InterruptedException e)
  {
    e.printStackTrace();
  }
}
  public String getName()
  {
    return name;
  }
}
