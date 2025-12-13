/*
write a code to start two thread T1 and T2, T1 thread will print only odd numbers,
T2 will print only event numbers.
Print the numbers is in sequence as 1,2,3,4...till 50?
 */

//Solution: Using synchronized, wait(), and notify()
//Explanation: We use a shared object for synchronization. Each thread checks if it’s their turn (odd/even), prints, and then notifies the other thread.

public class TwoThreadsusingSynchronised {
    private static final int MAX = 50;
    private int number = 1;
    private final Object lock = new Object();

    public static void main(String[] args) {

        TwoThreadsusingSynchronised approach1 = new TwoThreadsusingSynchronised();

        Thread oddThread = new Thread(approach1::printOdd);
        Thread evenThread = new Thread(approach1::printEven);
        oddThread.start();
        evenThread.start();

    }

    public void printOdd() {
        while (number < 50) {
            synchronized (lock) {
                if (number % 2 == 1) {
                    System.out.println(number);
                    number++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }

        }
    }

    public void printEven() {
        while (number <= 50) {
            synchronized (lock) {
                if (number % 2 == 0) {
                    System.out.println(number);
                    number++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }
    }
}
