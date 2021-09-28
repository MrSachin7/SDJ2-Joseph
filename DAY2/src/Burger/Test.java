package Burger;

public class Test
{
  public static void main(String[] args)
  {
    BurgerBar burgerBar = new BurgerBar(10);
    BurgerBarEmployee burgerBarEmployee1= new BurgerBarEmployee("Himal",burgerBar);
    BurgerBarEmployee burgerBarEmployee2 = new BurgerBarEmployee("Sachin",burgerBar);

    BurgerBarCustomer burgerBarCustomer1= new BurgerBarCustomer("Emil",burgerBar,1);
    BurgerBarCustomer burgerBarCustomer2 = new BurgerBarCustomer("Marian",burgerBar,2);
    BurgerBarCustomer burgerBarCustomer3= new BurgerBarCustomer("Andrea",burgerBar,3);
    BurgerBarCustomer burgerBarCustomer4 = new BurgerBarCustomer("Alexandra",burgerBar,2);
    BurgerBarCustomer burgerBarCustomer5 = new BurgerBarCustomer("Magnus",burgerBar,3);

    Thread t1 = new Thread(burgerBarEmployee1);
    t1.setDaemon(true);
    Thread t2 = new Thread(burgerBarEmployee2);
    t2.setDaemon(true);
    Thread t3 = new Thread(burgerBarCustomer1);
    Thread t4 = new Thread(burgerBarCustomer2);
    Thread t5 = new Thread(burgerBarCustomer3);
    Thread t6 = new Thread(burgerBarCustomer4);
    Thread t7 = new Thread(burgerBarCustomer5);


    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();
    t1.start();
    t2.start();
  }
}
