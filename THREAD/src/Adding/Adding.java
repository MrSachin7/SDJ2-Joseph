package Adding;

import java.util.ArrayList;

public class Adding extends Thread
{
  private String id;
  private long sleepTime;
  private ArrayList<String> list;

  public Adding(ArrayList<String> list, String id, long sleepTime)
  {
    this.list = list;
    this.id = id;
    this.sleepTime = sleepTime;
  }

  public static void sleep(long sleepTime)
  {
    try
    {
      Thread.sleep(sleepTime);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }

  @Override public synchronized void run()
  {

      for (int i = 1; i < 6; i++)
      {
        String temp = id + "#" + i;
        list.add(temp);
        System.out.println(" id=" + id + ",  list=" + list);
      }


  }

}
