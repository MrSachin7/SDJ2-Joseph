

public class MailBox implements Runnable
{
  private long maxFrequency;
  private int count;
  private static long RUNTIME = 1000;

  public MailBox(int count)
  {
    this.count=count;
  }
  private void waitingForMails()
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
    for (int i=0; i<count;i++)
    {
      System.out.println("New mail in your mailbox");
      waitingForMails();
    }
  }
}
