- CPU profiling collects data on method execution times, CPU consumption, and thread states to identify methods that consume excessive CPU resources

- How can you optimize CPU usage using a Java profiler?
  - By improving algorithmic efficiency, reducing unnecessary computations, or optimizing data structures

- By analyzing CPU profiling data, you can identify methods with high CPU consumption and optimize them by improving algorithmic efficiency, reducing unnecessary computations, or optimizing data structures.

- I/O profiling results helps to analyze and optimize input/output operations, such as file handling, network communication, or database queries, to improve application performance.

### Profiling tools:
- Visual VM
- Jprofiler
- toolkit

### Optimisation
- Release Objects: Once Objects are no longer needed, release them explicitly to make it eligible for garbage collection
  eg:
  ``` java
  Object obj=new Object();
  //perform Operation on obj
  obj=null;//when no longer needed
  ```
- Clear collections: clear collections when no longer needed.
  eg: collectionname.clear()
- Reassign/Reuse Object references: Reuse or Reassign reference to new instance once old instance is no longer needed. This will make old instance eligible for garbage collection
  -- eg:
  ```java 
  Object obj=new Object();
  //perform Operation on obj
  // Assign it to new instance once it is no longer needed
  obj=new Object();

  ```
  
  
