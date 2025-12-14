## Java Features by Version (High-Level List)
### Java 5 Features
- Generics
- Enhanced for-loop
- Autoboxing/Unboxing
- Annotations
- Varargs
- Enum Types
- Static Import

---

### Java 6 Features
- Scripting API (JSR 223)
- Compiler API
- Improvements in Web Services
- JDBC 4.0

---

### Java 7 Features
- Try-with-resources
- Diamond Operator
- Switch on String
- Multi-catch Exception Handling
- Fork/Join Framework
- NIO.2 (New File I/O)

---

### Java 8 Features
- Lambda Expressions
- Functional Interfaces
- Stream API
- Default and Static Methods in Interfaces
- Optional Class
- New Date and Time API (`java.time`)
- Method References
- Base64 Encoding/Decoding
- Nashorn Engine (Deprecated in Java 11)

---

### Java 9 Features
- Module System (Project Jigsaw)
- JShell (REPL)
- Stream API Improvements
- Private Methods in Interfaces

---

### Java 10 Features
- Local Variable Type Inference (`var`)
- Application Class-Data Sharing

---

### Java 11 Features
- String Methods Enhancements
- HTTP Client API
- Local-Variable Syntax for Lambda Parameters
- Removal of Java EE and CORBA Modules

---

### Java 12 Features
- Switch Expressions (Preview)
- Compact Number Formatting

---

### Java 13 Features
- Text Blocks (Preview)
- Dynamic CDS Archives

---

### Java 14 Features
- Records (Preview)
- Pattern Matching for `instanceof` (Preview)
- Helpful NullPointerExceptions

---

### Java 15 Features
- Sealed Classes (Preview)
- Hidden Classes

---

### Java 16 Features
- Records (Standard)
- Pattern Matching for `instanceof` (Standard)

---

### Java 17 Features
- Pattern Matching for `switch` (Preview)
- Sealed Classes (Standard)
- Strongly Encapsulate JDK Internals

---

### Java 18 Features
- Simple Web Server
- UTF-8 by Default

---

### Java 19 Features
- Virtual Threads (Preview)
- Structured Concurrency (Preview)

---

### Java 20 Features
- Scoped Values (Incubator)
- Record Patterns (Preview)

---

### Java 21 Features
- String Templates (Preview)
- Sequenced Collections
- Unnamed Patterns and Variables

---

## Commonly Used Java Features with Examples and Details

### Lambda Expressions (Java 8)
*Enables functional programming with concise syntax.*
```java
Runnable r = () -> System.out.println("Hello Lambda");
```

---

### Functional Interfaces (Java 8)
*Interfaces with a single abstract method, used with lambdas.*
```java
@FunctionalInterface
interface MyFunc { void execute(); }
```

---

### Stream API (Java 8)
*Functional-style operations on collections.*
```java
List<String> list = Arrays.asList("a", "b");
list.stream().forEach(System.out::println);
```

---

### Default and Static Methods in Interfaces (Java 8)
*Interfaces can have default and static implementations.*
```java
interface MyInterface {
    default void show() { System.out.println("Default"); }
    static void print() { System.out.println("Static"); }
}
```

---

### Optional Class (Java 8)
*Avoids null checks and NullPointerExceptions.*
```java
Optional<String> opt = Optional.of("value");
opt.ifPresent(System.out::println);
```

---

### New Date and Time API (`java.time`) (Java 8)
*Modern, immutable, and thread-safe date/time handling.*
```java
LocalDate today = LocalDate.now();
```

---

### Method References (Java 8)
*Shorthand for calling methods via lambdas.*
```java
list.forEach(System.out::println);
```

---

### Base64 Encoding/Decoding (Java 8)
*Built-in support for Base64 operations.*
```java
String encoded = Base64.getEncoder().encodeToString("test".getBytes());
```

---

### Try-with-resources (Java 7)
*Automatic resource management for I/O operations.*
```java
try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
    br.readLine();
}
```

---

### Generics (Java 5)
*Type-safe collections and classes.*
```java
List<String> names = new ArrayList<>();
```

---

### Enhanced for-loop (Java 5)
*Simplified iteration over collections.*
```java
for (String name : names) { }
```

---

### Local Variable Type Inference (`var`) (Java 10)
*Simplifies variable declarations.*
```java
var list = new ArrayList<String>();
```

---

### Records (Java 14/16)
*Concise immutable data classes.*
```java
record Point(int x, int y) {}
```

---

### Pattern Matching for `instanceof` (Java 16/17)
*Simplifies type checks and casts.*
```java
if (obj instanceof String s) {
    System.out.println(s.length());
}
```

---

Let me know if you want more details or examples for any specific feature or version!
