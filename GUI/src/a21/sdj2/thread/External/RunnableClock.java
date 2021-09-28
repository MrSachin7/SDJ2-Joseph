package a21.sdj2.thread.External;


import a21.sdj2.thread.view.TemperatureViewController;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RunnableClock implements Runnable
{
  private String timeString;
  TemperatureViewController temperatureViewController;

  public RunnableClock(TemperatureViewController temperatureViewController)
  {
    timeString="";
    this.temperatureViewController=temperatureViewController;
  }

  @Override public void run()
  {
    while (true)
    {
      LocalTime time = LocalTime.now();
      DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
      timeString = time.format(timeFormatter);
      System.out.println(timeString);
      temperatureViewController.showTime(timeString);
      sleep();

    }
  }
  public void sleep()
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
