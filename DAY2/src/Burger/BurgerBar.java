package Burger;

public class BurgerBar
{
  private int numberOfBurgers;
  private int maxNumberOfBurgers;

  public BurgerBar(int maxNumberOfBurgers)
  {
    this.maxNumberOfBurgers=maxNumberOfBurgers;
    numberOfBurgers=0;
  }
  public synchronized void makeBurger(String employeeName)
  {
    while (numberOfBurgers>=maxNumberOfBurgers)
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
    numberOfBurgers++;
    System.out.println(employeeName+"is making burgers (Number of burgers =)"+getNumberOfBurgers());
    notifyAll();
  }
  public synchronized void eatBurger(String who)
  {
    while (numberOfBurgers<=0)
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
    numberOfBurgers--;
    System.out.println(who+" is ready to eat a burger ("+getNumberOfBurgers()+" left)");
    notifyAll();
  }

  public int getNumberOfBurgers()
  {
    return numberOfBurgers;
  }
}
