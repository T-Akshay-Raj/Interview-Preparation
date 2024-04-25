package basic.Threads.MultiThreading;

public class ImplementingRunnableExample implements Runnable {
  @Override
  public void run() {
    System.out.println("Thread is running by implementing Runnable interface.");
  }

  public static void main(String[] args) {
    ImplementingRunnableExample implementingRunnableExample = new ImplementingRunnableExample();
    Thread t1 = new Thread(implementingRunnableExample);
    t1.start();
  }
}
