package AlcoholIsInjuriousToHealth;

public class Test
{
  public static void main(String[] args)
  {
    Beer beer= new Beer();
    Bar bar = new Bar(5);
    Bartender bartender1= new Bartender(bar,beer,"Sachin");
    Bartender bartender2 = new Bartender(bar, beer,"Himal");

    Customer customer1 = new Customer("Marian", bar);
    Customer customer2 = new Customer("Emil",bar);
    Customer customer3 = new Customer("Adrian",bar);

    Thread[] threads = new Thread[5];
    threads[0]= new Thread(bartender1, bartender1.getName());
    //threads[0].start();
    //threads[0].setDaemon(true);
    threads[1]= new Thread(bartender2, bartender2.getName());
    //threads[1].start();
    //threads[1].setDaemon(true);
    threads[2]= new Thread(customer1,customer1.getName());
   // threads[2].start();
    threads[2].setDaemon(true);
    threads[3]= new Thread(customer2,customer2.getName());
   // threads[3].start();
    threads[3].setDaemon(true);
    threads[4]= new Thread(customer3,customer3.getName());
    //threads[4].start();**/
    threads[4].setDaemon(true);

    for (int i=0; i< threads.length;i++)
    {
      threads[i].start();
    }
  }
}
