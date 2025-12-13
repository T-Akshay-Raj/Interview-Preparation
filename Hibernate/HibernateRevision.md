## Detailed at https://akshay-gitbook.gitbook.io/springboot-review-series/hibernate

# Hibernate Revision Notes

---

## 1. What is Hibernate?

**Hibernate** is a popular Java ORM (Object-Relational Mapping) framework that maps Java objects to database tables, allowing developers to interact with databases using Java objects instead of SQL queries.

**Key Benefits:**
- Reduces boilerplate JDBC code
- Handles object-relational impedance mismatch
- Supports caching, transactions, and lazy loading

---

## 2. Hibernate Architecture

- **Configuration**: Loads settings from `hibernate.cfg.xml` or annotations.
- **SessionFactory**: Heavy, thread-safe object created once per application; used to create sessions.
- **Session**: Lightweight, not thread-safe; represents a single unit of work with the database.
- **Transaction**: Manages atomic operations.
- **Query/Criteria**: For querying the database.

---

## 3. Entity Mapping with @Entity and @Table

**Explanation:**  
`@Entity` marks a class as a persistent entity. `@Table` specifies the table name.

**Example:**

```java
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
```

---

## 4. Primary Key with @Id and @GeneratedValue

**Explanation:**  
`@Id` marks the primary key. `@GeneratedValue` defines how the key is generated.

**Example:**

```java
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
```

---

## 5. @Embeddable and @Embedded

**Explanation:**  
Use `@Embeddable` for value types (e.g., address) that are not entities. Use `@Embedded` to include them in an entity.

**Example:**

```java
@Embeddable
public class Address {
    private String city;
    private String state;
}

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address address;
}
```

---

## 6. Relationships

### a. One-to-Many and Many-to-One

**Explanation:**  
A department has many employees; each employee belongs to one department.

**Example:**

```java
@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();
}

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
```

### b. mappedBy Attribute

**Explanation:**  
`mappedBy` tells Hibernate which side owns the relationship. In the above example, `Department`'s `employees` list is mapped by the `department` field in `Employee`.

---

## 7. Cascade Operations

**Explanation:**  
Cascade operations define how actions on a parent entity affect child entities (e.g., saving a department also saves its employees).

**Example:**

```java
@OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
private List<Employee> employees;
```

**Common Cascade Types:**
- `PERSIST`: Save child when parent is saved
- `REMOVE`: Delete child when parent is deleted
- `MERGE`, `REFRESH`, `DETACH`, `ALL`

---

## 8. Fetch Strategies

**Explanation:**  
Controls when related entities are loaded.

- **LAZY**: Loads related entities on demand (default for collections)
- **EAGER**: Loads related entities immediately

**Example:**

```java
@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
private List<Employee> employees;
```

---

## 9. Hibernate Query Language (HQL)

**Explanation:**  
HQL is an object-oriented query language similar to SQL but operates on entity objects.

**Example:**

```java
// Get all employees in a department
String hql = "FROM Employee e WHERE e.department.id = :deptId";
List<Employee> employees = session.createQuery(hql, Employee.class)
    .setParameter("deptId", 1L)
    .getResultList();
```

---

## 10. Criteria API

**Explanation:**  
A type-safe, programmatic way to build queries.

**Example:**

```java
CriteriaBuilder cb = session.getCriteriaBuilder();
CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
Root<Employee> root = cq.from(Employee.class);
cq.select(root).where(cb.equal(root.get("department").get("id"), 1L));
List<Employee> employees = session.createQuery(cq).getResultList();
```

---

## 11. Transactions

**Explanation:**  
Transactions ensure atomicity of database operations.

**Example:**

```java
Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();

Department dept = new Department();
dept.setName("HR");
session.save(dept);

tx.commit();
session.close();
```

---

## 12. Caching

**Explanation:**  
- **First Level Cache**: Session-level, enabled by default.
- **Second Level Cache**: SessionFactory-level, needs configuration.

---

## 13. Other Useful Annotations

- `@Transient`: Field is not persisted.
- `@Temporal`: For date/time fields.
- `@Lob`: For large objects (BLOB/CLOB).
- `@Version`: For optimistic locking.

**Example:**

```java
@Entity
public class Employee {
    // ... other fields ...

    @Transient
    private int tempValue;

    @Temporal(TemporalType.DATE)
    private Date hireDate;

    @Lob
    private String bio;

    @Version
    private int version;
}
```

---

## 14. Example: Complete Employee-Department Mapping

```java
@Entity
public class Department {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();
}

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}

@Embeddable
public class Address {
    private String city;
    private String state;
}
```

---

## 15. Common Interview Questions & Answers

### 1. **What is the difference between get() and load()?**

- `get()`: Returns `null` if the entity is not found; hits the database immediately.
- `load()`: Throws `ObjectNotFoundException` if not found; returns a proxy and hits the database only when needed.

---

### 2. **What is the N+1 select problem?**

When fetching a parent entity (e.g., Department), Hibernate issues one query for the parent and N queries for each child (e.g., Employee), leading to performance issues.  
**Solution:** Use `fetch join` in HQL or set fetch type to `EAGER` if appropriate.

---

### 3. **How does Hibernate handle transactions?**

Hibernate uses the `Transaction` API to manage transactions. All operations between `beginTransaction()` and `commit()` are atomic.

---

### 4. **What is the difference between save(), persist(), and merge()?**

- `save()`: Returns the generated identifier; can be used outside a transaction.
- `persist()`: Does not return the identifier; must be used within a transaction.
- `merge()`: Updates a detached entity and returns the managed instance.

---

### 5. **How to implement soft delete in Hibernate?**

Add a boolean field (e.g., `isDeleted`) and filter queries to exclude deleted records.  
Optionally, use Hibernate’s `@SQLDelete` and `@Where` annotations.

**Example:**

```java
@Entity
@SQLDelete(sql = "UPDATE employee SET is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Employee {
    // ... fields ...
    private boolean isDeleted = false;
}
```

---

### 6. **What is the use of the mappedBy attribute?**

`mappedBy` defines the inverse side of a bidirectional relationship, indicating which entity owns the relationship.

---

### 7. **What is the default fetch type for @ManyToOne and @OneToMany?**

- `@ManyToOne`: EAGER
- `@OneToMany`: LAZY

---

### 8. **How do you handle cascading deletes?**

Use `cascade = CascadeType.REMOVE` or `CascadeType.ALL` on the parent entity’s relationship field.

---

