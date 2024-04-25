# JAVA THREADS

### Concurrency:
In programming, when multiple functions can be performed at the same time, its known as concurrency.
Java facilitates concurrent programming by allowing to create threads.

Process: Instance of a running program, They run in isolation with private memory

Thread: subprocess or smallest process under execution, may run concurrently. Unlike processes, threads share data & memory with other threads within its own process.

### MultiThreading: Switching between threads
Benefits:
- Better CPU and I/O utlization
- Tasks can run in parallel
- Improved responsiveness
- Long tasks can run in a thread


### Multitasking: Switching between applications

MainThread:
``` java
public class MainThread {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
    }
}
```
There are two kinds of threads, daemon threads and non-daemon or user threads

### DaemonThread:
A daemon thread can be thought of as an infrastructure thread that runs in the background to perform tasks like garbage collection or GUI event dispatching. JVM gives low priority

### Non DaemonThread:
example: Main thread, JVM treats it with high priority compared to daemon threads

Convert UserThread to Daemon Thread:
- Using setDaemon(true) method, this method should be called after creating the thread and before starting the thread
- Use isDaemon() method to check if a thread is a daemon or non daemon

The JVM waits until all non-daemon threads have finished their execution before stopping itself. The JVM terminates any daemon threads that are running and then stops itself.

### Thread Class:
- Job: Encapsulated attributes and behaviour of a thread
- Attributes: id, name, priority, state
- behaviour: start(), sleep(), join(), interrupt()


### Thread States: New, Runnable, Running, Blocked, Waiting, TimedWaiting, Terminated
use Thread.currentThread.getState() or t1.getState to get current state of a thread
New->Runnable->Running

- start() method:
Moves thread state from new to runnable, It causes thread to begin execution and trigger the running behaviour of the thread

- run() method: start method internally call run() method
Moves thread state from runnable to running

Note: Although we could call run() method directly on a thread, It is suggested to not call run() method instead of start() method as it would not exhibit multi thread behaviour.

- sleep() method: is a blocking operation. It will keep a hold on the monitor and lock the shared object for a set number of milliseconds.
Moves thread from running to sleeping state fro specified milliseconds and moves state back to runnable at the end of wait.

- interrupt() method:Interrupt the thread
- join() method: Current thread to wait for atmost menthioned milliseconds


### Thread Interuption in java:
Internal Flag: boolean interrupted status
Instance methods: void interrupt(),  boolean isInterrupted()
static method: boolean interrupted()


### Runnable Vs Callable



-wait() pauses the thread until the specified number of milliseconds has passed or it receives a notification from another thread, whichever instance occurs first. This function does not keep a hold on the monitor or lock the shared object.



## Recap:
- An instance of the Thread class or its sub class represents a separate path of execution. The Runnable interface represents the running behaviour of a thread. The Thread super class implements the Runnable interface, allowing it to implement the run() method, so that it provides the runnable behaviour to its instances.

- The Thread class has a method named start() that takes no arguments. When you call this method on a thread object, it causes that thread to begin execution. In other words, the running behavior of the thread is triggered by the JVM, by internally calling the run() method of the thread.

- If you call run() method directly, The threads would run one after the other, but not at the same time. They won't behave like threads, therefore, there will be no multithreading happening there.

### Extending vs Implementing:
Note: Extending class is inheritance, Parent child or Is-a relation and tight coupling
Implementing interface is Aggregation, Whole Part or Has-a relation and loose coupling

- When to use which approach: Since class in java supports extending single class, when our class has to extend another class prefer implementing Runnable approach, else extending Thread class is much readable and suggested


### Thread States:  
- NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING & TERMINATED
- The getState() instance method returns the status of the thread on which it’s invoked. The return value is an Enum constant defined in Enum class Thread.State. It can return any of these state values.

### Boolean Methods:
- isAlive()
- static currentThread()
- isInterupted()
- isDaemon()

- All threads are assigned a priority value. This value is assigned at the time of thread creation and its value falls within the range of 1 to 10. 1 is the minimum priority and 10 is the maximum priority. The priority of a thread can be retrieved using the getPriority() instance method that returns an int value between 1 and 10.

- Sometimes you'll need to make sure that a thread waits until another thread(s) finishes its task. This is because threads access the same data concurrently and it could lead to synchronization issues. For instance, there could be one thread storing data in a variable and another thread running concurrently reading that data. If the first thread hasn't finished storing the data before the other thread tries to read it, it’s going to cause a problem

- Threads need to communicate with each other. A thread could request other threads to wait until it finishes execution. The Thread class has a method named join() that does this.

- Interrupting a thread means indicating to the thread that it should stop what it’s doing. When a thread is in the middle of its execution, the program might request the thread to finish doing its task early, even if the task is not complete. This could be because the program wants to terminate. Interuption requests don't actually interrupt the thread. The program is requesting that the thread interrupts itself at the next available opportunity. If at the time of invoking the interrupt() method, the thread is blocked, the interrupted status flag is set to false. In other words, cleared. And an InterruptedException is also thrown by the blocking method.

- Calling the interrupted() method, clears the interrupted status flag value, if it’s set, before returning the original value. It’s a static method that can simply be invoked as Thread.interrupted(), without a thread reference. Internally, the interrupted() method obtains a reference to the current thread and reads its status flag and returns it.

- In the Thread class, there’s a static method named sleep() that allows you to pause a running thread for a while, wait for some time, and then continue to perform the rest of the task. You can pass the amount of time you want the current thread to pause its task for.
