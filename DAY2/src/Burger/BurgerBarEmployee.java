package Burger;

public class BurgerBarEmployee implements Runnable
{
  private String name;
  private BurgerBar burgerBar;

  public BurgerBarEmployee(String name, BurgerBar burgerBar)
  {
    this.name = name;
    this.burgerBar = burgerBar;
  }

  @Override public void run()
  {
      while (true)
      {

          burgerBar.makeBurger(name);

        sleepTimer(1000);
      }
  }

  private void sleepTimer(int i)
  {
    try
    {
      Thread.sleep(i);
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


