package basic.Threads.MultiThreading;

public class ThreadSleepExample extends Thread {
  public static void main(String[] args) {
    ThreadSleepExample ts = new ThreadSleepExample();
    ts.start();
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Thread name: "+Thread.currentThread().getName()+" Loop at i ="+i);
      if (i == 5) {
        try {
          System.out.println("Thread pausing for 2 sec");
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
