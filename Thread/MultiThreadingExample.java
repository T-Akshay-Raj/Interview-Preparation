package basic.Threads.MultiThreading;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultiThreadingExample {
  //Get Number of Threads
  private static final int NUM_THREADS = Runtime.getRuntime()
      .availableProcessors();

  public static void main(String[] args) {
    System.out.println(
        "Number of Threads: " + MultiThreadingExample.NUM_THREADS);

    //Define Executor service
    ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
    //Note Start Time
    long startTime = System.currentTimeMillis();

    //Step 1: split the workload across multiple threads
    int chunkSize = 100000000 / NUM_THREADS;

    for (int i = 0; i < NUM_THREADS; i++) {
      int start = i * chunkSize;
      int end = start + chunkSize;
      executorService.submit(new CPUIntensiveTask(start, end));
    }

    executorService.shutdown();

    try {
      executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


    long endTime = System.currentTimeMillis();
    long executionTime = endTime - startTime;
    System.out.println("Execution Time: " + executionTime);

    //Step 2: Validate if code is truly multithreaded using actual validation logic
    boolean isMultiThreaded = isMultithreadedEnvironment();
    if (isMultiThreaded) {
      System.out.println(
          "Success! Code is executing in a multiThreaded environment");
    } else {
      System.out.println("Not a multiThreaded environment");
    }


  }

  private static boolean isMultithreadedEnvironment() {
    int activeThreads = Thread.activeCount();
    return activeThreads > NUM_THREADS;
  }

  static class CPUIntensiveTask implements Runnable {
    private final int start;

    private final int end;

    CPUIntensiveTask(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public void run() {
      //perform cpu intensive task
      for (int i = start; i < end; i++) {
        //perform some computation
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}


