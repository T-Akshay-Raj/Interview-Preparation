package basic.Threads.MultiThreading;

public class ExtendingThreadExample extends Thread {

  @Override
  public void run() {
    System.out.println("Thread is running by extending Thread class.");
    System.out.println(Thread.currentThread().getName());
  }

  public static void main(String[] args) {
    ExtendingThreadExample t1 = new ExtendingThreadExample();
    ExtendingThreadExample t2 = new ExtendingThreadExample();
    ExtendingThreadExample t3 = new ExtendingThreadExample();
    t1.start();
    t2.start();
    t3.start();
  }
}
