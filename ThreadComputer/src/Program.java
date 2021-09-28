public class Program implements Runnable
{
  private String program;
  private long maxFrequency;
  private String action;
  private int count;
 private static long RUNTIME = 1000;

  public Program(String program, String action, int count)
  {
    this.action=action;
    this.program=program;
    this.count=count;
  }

  private void normalOperation()
  {
    try
    {
      Thread.sleep(RUNTIME);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
  @Override public void run()
  {
    for (int i=0; i<count ; i++)
    {
      System.out.println(program+" wants to "+action);
      normalOperation();
    }

  }
}
