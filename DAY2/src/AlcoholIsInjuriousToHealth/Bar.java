package AlcoholIsInjuriousToHealth;

import java.util.ArrayList;

public class Bar
{
  private ArrayList<Beer> beerList;
  private int maxNoOfBeers;

  public Bar( int maxNoOfBeers)
  {
    beerList=new ArrayList<Beer>();
    this.maxNoOfBeers=maxNoOfBeers;
  }

  public synchronized void placeBeer(Beer b)
  {
    while (beerList.size()>=maxNoOfBeers)
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

      beerList.add(b);
      System.out.println(Thread.currentThread().getName()
          + " has added a beer,   Number of beers :" + beerList.size());
      notifyAll();

  }

  public synchronized void takeBeer()
  {
    while (beerList.size()<=0)
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
    beerList.remove(beerList.size()-1);
    System.out.println(Thread.currentThread().getName()+" has taken a beer,    Number of beers :"+beerList.size());
    notifyAll();
  }

  public ArrayList<Beer> getBeerList()
  {
    return beerList;
  }

  public int getMaxNoOfBeers()
  {
    return maxNoOfBeers;
  }
}
