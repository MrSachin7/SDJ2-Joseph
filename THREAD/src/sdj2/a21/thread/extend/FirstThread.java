package sdj2.a21.thread.extend;

public class FirstThread extends Thread
{
  private String stringParam;

  public FirstThread(String stringParam)
  {
    this.stringParam=stringParam;
  }

  public static void main(String[] args)
  {
    FirstThread t1 = new FirstThread("One");
    t1.start();
    FirstThread t2 = new FirstThread("Two");
    t2.setDaemon(true);
    t2.start();
    sleepASecond();
    t1.setStringParam("exit");

  }

  private void setStringParam(String stringParam)
  {
    this.stringParam=stringParam;
  }

  @Override public void run()
  {
    while (!"exit".equals(stringParam))
    {
      System.out.println(
          (isDaemon() ? "daemon" : "user") + "thread" + this.getName() + "[ID="
              + this.getId() + "] passed parameter :" + stringParam);
      sleepASecond();
    }

  }

  private static void sleepASecond()
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
}
