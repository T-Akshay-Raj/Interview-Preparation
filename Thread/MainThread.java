package basic.Threads.MultiThreading;

public class MainThread {
  public static void main(String[] args) {
    System.out.println("Thread Name: " + Thread.currentThread().getName());

    System.out.println("Active Thread Count :" + Thread.activeCount());
  }
}
