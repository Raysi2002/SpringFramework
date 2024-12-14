# Spring Data JPA: Quick Revision Guide

## **Entities**

### **1. Student Entity**
- **Annotations:**
    - `@Entity`: Maps the class to the `students` table in the database.
    - `@Table`: Specifies the table name and a unique constraint on `email_address`.
    - `@Id`: Marks `studentId` as the primary key.
    - `@SequenceGenerator`: Configures a sequence for generating `studentId` values.
    - `@GeneratedValue`: Links the sequence generator with `studentId`.
    - `@Column`: Maps `emailId` to `email_address` in the database with `nullable = false`.
    - `@Embedded`: Represents the `Guardian` entity relationship.

- **Fields:**
    - `studentId`: Auto-generated primary key.
    - `firstName` and `lastName`: Strings for student names.
    - `emailId`: Stores the student's email address.
    - `guardian`: An embedded field representing the `Guardian` entity.

---

### **2. Guardian Entity**
- **Annotations:**
    - `@Embeddable`: Allows this entity to be embedded in other entities.

- **Fields:**
    - `guardianName`: Guardian's name.
    - `guardianEmail`: Guardian's email address.
    - `guardianPhone`: Guardian's phone number.

---

## **Repository**

### **StudentRepository**
- **Extends:** `JpaRepository<Student, Long>`
- **Custom Query Methods:**
    1. `List<Student> findStudentByFirstName(String firstName)`: Fetches students with an exact `firstName`.
    2. `List<Student> findByFirstNameContaining(String name)`: Fetches students whose `firstName` contains a substring.

---

## **Practical Examples**

### **1. Save a Student**
```java
@Test
public void saveStudent() {
    Student student = Student.builder()
            .firstName("Aashish")
            .lastName("Ray")
            .emailId("20002raysi@gmail.com")
            .build();
    studentRepository.save(student);
}

2. Retrieve All Students

@Test
public void getStudents() {
    List<Student> students = studentRepository.findAll();
    System.out.println(students);
}

3. Add Guardian to a Student

@Test
public void updateStudentWithGuardian() {
    Guardian guardian = Guardian.builder()
            .guardianName("Sadajiv")
            .guardianEmail("sParent@yahoo.com")
            .guardianPhone("9810109080")
            .build();
    Student student = Student.builder()
            .firstName("Sonu")
            .lastName("Ahir")
            .emailId("sonu@gmail.com")
            .guardian(guardian)
            .build();
    studentRepository.save(student);
}

4. Find Students by Exact firstName

@Test
public void findStudentByFirstName() {
    List<Student> studentList = studentRepository.findStudentByFirstName("Aashish");
    System.out.println(studentList);
}

5. Find Students by Name Containing Substring

@Test
public void findByNameContaining() {
    List<Student> studentList = studentRepository.findByFirstNameContaining("kan");
    System.out.println(studentList);
}

Key Concepts
	•	Annotations in JPA:
	•	@Entity, @Table, @Id, @Column, @GeneratedValue, @SequenceGenerator, @Embeddable, @Embedded.
	•	Custom Queries in Spring Data JPA:
	•	Derived query methods using naming conventions (e.g., findBy, Containing).
	•	Builder Pattern:
	•	Used for creating objects cleanly (e.g., Student.builder()).
Checklist for Revision
	•	Understand the role of each annotation.
	•	Practice defining entity relationships (@Embedded, @Embeddable).
	•	Use derived query methods in JpaRepository.
	•	Ensure sequence generators are correctly defined for primary keys.
	•	Build and execute unit tests for CRUD operations.

Relationships Between Entities in JPA

In JPA (Java Persistence API), relationships define how entities (tables in the database) are connected. Relationships are crucial for designing a well-structured and efficient database schema.

Types of Relationships

1. One-to-One Relationship
	•	Definition: Each entity is associated with only one other entity.
	•	Example: A user has exactly one profile.

Implementation
	•	Use @OneToOne annotation.
	•	Define ownership using mappedBy in the non-owning side.

Example Code

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profile profile;
}

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "profile")
    private User user;
}

Use Case
	•	Scenarios where an entity has exactly one dependent entity (e.g., User and Address).

2. One-to-Many Relationship
	•	Definition: One entity is related to multiple other entities.
	•	Example: A department has many employees.

Implementation
	•	Use @OneToMany annotation.
	•	Often combined with @JoinColumn for unidirectional relationships or mappedBy for bidirectional ones.

Example Code

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();
}

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}

Use Case
	•	Scenarios where a parent entity has multiple children (e.g., Blog and Comments).

3. Many-to-One Relationship
	•	Definition: Many entities are associated with one entity.
	•	Example: Many employees belong to one department.

Implementation
	•	Use @ManyToOne annotation on the owning side.

Example Code

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}

Use Case
	•	Scenarios where multiple child entities are related to a single parent (e.g., Orders and Customers).

4. Many-to-Many Relationship
	•	Definition: Many entities are associated with many other entities.
	•	Example: A student can enroll in multiple courses, and a course can have multiple students.

Implementation
	•	Use @ManyToMany annotation.
	•	Typically requires a join table.

Example Code

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();
}

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
}

Use Case
	•	Scenarios where two entities have a many-to-many association (e.g., Authors and Books).

Key Annotations

Annotation	Description
@OneToOne	Maps a one-to-one relationship.
@OneToMany	Maps a one-to-many relationship.
@ManyToOne	Maps a many-to-one relationship.
@ManyToMany	Maps a many-to-many relationship.
@JoinColumn	Specifies the foreign key column.
@JoinTable	Defines the join table for many-to-many relationships.
mappedBy	Indicates the inverse side of the relationship.

Why is Many-to-One Preferred Over One-to-Many?
	1.	Query Performance: Queries involving ManyToOne are simpler and often more efficient as they use a single join.
	2.	Mapping Complexity: OneToMany requires maintaining a collection, which can lead to additional overhead.
	3.	Use Cases: In most real-world scenarios, child entities reference their parent, making ManyToOne a more natural choice.

Best Practices
	1.	Use CascadeType cautiously to manage related entities.
	2.	Prefer lazy fetching (FetchType.LAZY) to avoid performance issues.
	3.	Use bidirectional relationships only when necessary to prevent complexity.
	4.	Choose the right relationship type based on the use case.

Let me know if you’d like this documentation in .md format or need further clarifications!
