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


## Spring Data JPA: Quick Revision Guide (Continued)

Repository Annotations and Queries

1. JPQL (Java Persistence Query Language) Queries
	•	Custom Methods:
	•	@Query("select s from Student s where s.emailId = ?1")
Retrieves the entire Student entity by email address.
	•	@Query("select s.firstName from Student s where s.emailId = ?1")
Retrieves only the firstName of a student by email address.

2. Native Queries
	•	Native Query Annotations:
	•	@Query(value = "query", nativeQuery = true)
Enables writing SQL queries directly instead of JPQL.
	•	Examples:
	•	Retrieve student entity:
select * from students s where s.email_address = ?1
	•	Retrieve firstName:
select first_name from students s where s.email_address = ?1
	•	Retrieve guardian email:
select guardian_email from students s where s.first_name = ?1

3. Update and Delete Operations
	•	Annotations:
	•	@Modifying: Indicates an update/delete query.
	•	@Transactional: Ensures the operation is performed within a transaction.
	•	Examples:
	•	Update:

@Modifying
@Transactional
@Query("update students set first_name = ?1 where email_address = ?2")
int updateNameByEmailAddress(String updatingName, String email);


	•	Delete:

@Modifying
@Transactional
@Query("delete from students where email_address = ?1")
int deleteStudentDetails(String emailId);

Test Methods

1. JPQL Queries
	•	Find by Email Address:

@Test
public void findStudentByEmailAddressQueryMethod() {
    Student student = studentRepository.findStudentByEmailAddress("2002raysi@gmail.com");
}


	•	Get First Name by Email:

@Test
public void getFirstName() {
    String student = studentRepository.getFirstNameByEmailAddress("2002raysi@gmail.com");
}



2. Native Queries
	•	Get First Name (Native Query):

@Test
public void getFirstNameNativeQuery() {
    String student = studentRepository.getFirstNameByEmailAddressNativeQuery("2002raysi@gmail.com");
}


	•	Get Guardian Email by Student First Name:

@Test
public void getParentNameByFirstName() {
    String parentEmail = studentRepository.getParentEmailByStudentFirstName("Kanxu");
}



3. Update and Delete Operations
	•	Update Student Name:

@Test
public void updateFirstName() {
    int rowsAffected = studentRepository.updateNameByEmailAddress("Kanxa", "2002raysi@gmail.com");
    if (rowsAffected > 0) System.out.println("Name updated successfully");
}


	•	Delete Student:

@Test
public void deleteStudent() {
    int rowsAffected = studentRepository.deleteStudentDetails("20002raysi@gmail.com");
    if (rowsAffected > 0) System.out.println("Student data deleted successfully");
}

Key Concepts and Checklist

Annotations and Usage
	•	Core Annotations:
	•	@Query: For JPQL/SQL queries.
	•	@NativeQuery: Native SQL with minimal boilerplate.
	•	@Modifying and @Transactional: For data modification operations.

Queries
	•	Derived Query Methods:
Utilize method names to define simple queries (e.g., findByFirstNameContaining).
	•	JPQL:
Close to SQL but operates on Java entities.
	•	Native Queries:
Directly interact with the database.

Testing
	•	Use @Test to validate repository methods:
	•	CRUD operations.
	•	JPQL and native queries.

Practical Tips
	•	Always test for expected results and edge cases.
	•	Ensure @Transactional is applied where required for data consistency.
	•	Familiarize yourself with JPQL syntax for flexibility over native queries.

This continuation covers repository-level queries, their implementation, and testing practices to deepen your Spring Data JPA understanding.
