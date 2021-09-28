package AlcoholIsInjuriousToHealth;

public class Bartender implements Runnable
{
  private Bar bar;
  private Beer beer;
  private String name;

  public Bartender(Bar bar, Beer beer, String name)
  {
    this.bar = bar;
    this.beer = beer;
    this.name = name;
  }

  public void run()
  {
   while (bar.getMaxNoOfBeers()>bar.getBeerList().size())
    {
      bar.placeBeer(beer);
      sleepASecond();
    }

  }
  public void sleepASecond()
  {
    try
    {
      Thread.sleep(1000);
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
