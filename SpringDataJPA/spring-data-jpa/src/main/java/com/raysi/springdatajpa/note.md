# Spring Data JPA Notes for Beginners

This note summarizes important concepts demonstrated in the provided code, including relationships, queries, and best practices in Spring Data JPA.

---

## 1. **Entity Relationships**

### One-to-One
- **Example**: `CourseMaterial` ↔ `Courses`
- Defined using `@OneToOne`.
- Use `mappedBy` for bidirectional mapping.
- Cascade operations to manage related entities automatically.
- Example:
  ```java
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
  @JoinColumn(name = "course_id", referencedColumnName = "courseId")
  private Courses course;

Many-to-One
•	Example: Courses ↔ Teacher
•	Preferred over OneToMany for efficiency.
•	Example:

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
private Teacher teacher;



Many-to-Many
•	Not in the code but important to understand:
•	Use @ManyToMany for entities like Student ↔ Courses.
•	Define a join table:

@ManyToMany
@JoinTable(
name = "student_courses",
joinColumns = @JoinColumn(name = "student_id"),
inverseJoinColumns = @JoinColumn(name = "course_id")
)
private List<Courses> courses;



Embeddable Objects
•	Example: Guardian in Student.
•	Use @Embeddable and @Embedded for objects reused across entities.

2. Repositories

JpaRepository
•	Provides built-in CRUD operations.
•	Custom Query Methods:
•	Derived queries: findByFirstNameContaining(String name)
•	JPQL: @Query("select s from Student s where s.emailId = ?1")
•	Native queries: @Query(value = "select * from students where email_address = ?1", nativeQuery = true)

Modifying Queries
•	Use @Modifying with @Transactional for updates or deletes.
•	Example:

@Modifying
@Transactional
@Query("update students set first_name = ?1 where email_address = ?2")
int updateNameByEmailAddress(String name, String email);

3. Paging and Sorting
   •	Add PagingAndSortingRepository or extend JpaRepository.
   •	Example:

Page<Student> findAll(Pageable pageable);
List<Student> findByFirstName(String name, Sort sort);


	•	Create pageable and sort instances:

Pageable pageable = PageRequest.of(0, 10, Sort.by("firstName").ascending());

4. Important Notes
    1.	Bidirectional Relationships:
          •	Avoid infinite recursion in toString(). Use @ToString(exclude = "field").
    2.	Cascade Types:
          •	ALL: Includes all operations (save, delete, etc.).
          •	Use cautiously to prevent unintended operations.
    3.	Unique Constraints:
          •	Use @UniqueConstraint to enforce unique fields (e.g., emailId).
    4.	Testing with Spring Boot:
          •	Use @SpringBootTest for integration testing.
          •	Example: Save and fetch entities in repository tests.

5. Additional Concepts to Learn
    1.	Lazy vs. Eager Fetching:
          •	Use fetch = FetchType.LAZY for better performance in large datasets.
    2.	DTOs and Projections:
          •	Use Data Transfer Objects (DTOs) for custom query results.
    3.	Validation:
          •	Add validation annotations (e.g., @NotNull, @Email) for data integrity.
    4.	Auditing:
          •	Enable auditing with @CreatedDate and @LastModifiedDate.
    5.	Spring Data Query DSL:
          •	Use dynamic queries with QuerydslPredicateExecutor.

Example Snippets

Saving Data

Teacher teacher = Teacher.builder().firstName("John").lastName("Doe").build();
Courses course = Courses.builder().courseTitle("Math").teacher(teacher).build();
CourseMaterial material = CourseMaterial.builder().url("math.com").course(course).build();
courseMaterialRepository.save(material);

Fetching with Paging

Pageable pageable = PageRequest.of(0, 5, Sort.by("courseTitle").ascending());
Page<Courses> courses = courseRepository.findAll(pageable);

Updating Data

studentRepository.updateNameByEmailAddress("NewName", "email@example.com");

Deleting Data

studentRepository.deleteStudentDetails("email@example.com");


