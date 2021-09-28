package Adding;

import java.util.ArrayList;

public class ThreadMain
{
  public static void main(String[] args)
  {
    ArrayList<String> list = new ArrayList<>();
    Adding a1 = new Adding(list, "A", 1000);
  a1.start();
    Adding a2 = new Adding(list, "B", 1000);

   a2.start();
    Adding a3 = new Adding(list, "C", 1000);

 a3.start();
    try
    {
      a1.join();
      a2.join();
      a3.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }

    System.out.println("\n\nFinal List :"+list+" Number of elements :"+list.size());

  }
}
