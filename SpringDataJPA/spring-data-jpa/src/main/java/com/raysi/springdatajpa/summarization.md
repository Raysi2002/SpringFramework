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

