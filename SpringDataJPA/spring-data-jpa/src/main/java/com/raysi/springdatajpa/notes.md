package com.raysi.springdatajpa.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courseMaterial")
@ToString(exclude = "course")
public class CourseMaterial {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long courseMaterialId;
private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false // It will force you to add course in the CourseMaterial other wise it will throw error
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Courses course;
}


package com.raysi.springdatajpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "course")
public class Courses {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long courseId;
private String courseTitle;
private Integer credit;

    @OneToOne(
            mappedBy = "course" //Bidirectional mapping
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;
}

package com.raysi.springdatajpa.entities;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Guardian {
private String guardianName;
private String guardianEmail;
private String guardianPhone;
}

package com.raysi.springdatajpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
name = "students",
uniqueConstraints = @UniqueConstraint(
name ="emailid_unique",
columnNames = "email_address"
)
)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
@Id
@SequenceGenerator(
name = "student_sequence",
sequenceName = "student_sequence",
allocationSize = 1
)
@GeneratedValue(
strategy = GenerationType.SEQUENCE,
generator = "student_sequence"
)
private Long studentId;
private String firstName;
private String lastName;
@Column(
name = "email_address",
nullable = false
)
private String emailId;
@Embedded
private Guardian guardian;
}

package com.raysi.springdatajpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long teacherId;
private String firstName;
private String lastName;

//    @OneToMany( // JPA always suggests you to create @ManyToOne relationship instead of @OneToMany
//            cascade = CascadeType.ALL
//
//    )
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private List<Courses> courses;
}

package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Long> {
}

package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

interface StudentRepository extends JpaRepository<Student, Long> {
List<Student> findStudentByFirstName(String firstName);
List<Student> findByFirstNameContaining(String name);

     //JPQL (Java Persistence Query Language) to fetch all the data
     @Query("select s from Student s where s.emailId = ?1")
     Student findStudentByEmailAddress(String emailAddress);

     //JPQL to fetch only first name using email address
     @Query("select s.firstName from Student s where s.emailId = ?1")
     String getFirstNameByEmailAddress(String email);

     //Native Query
     @Query(
             value = "select * from students s where s.email_address = ?1",
             nativeQuery = true
     )
     Student getFirstNameByEmailAddressNative(String emailId);

     //Native Query
     @NativeQuery("select first_name from students s where s.email_address = ?1")
     String getFirstNameByEmailAddressNativeQuery(String email);

     //Native Query for retrieving parent email
     @NativeQuery("select guardian_email from students s where s.first_name = ?1")
     String getParentEmailByStudentFirstName(String firstName);

     //Native Query for retrieving parent email
     @NativeQuery("select guardian_email from students s where s.last_name = ?1")
     String getParentEmailByStudentLastName(String firstName);


//     ---------------Update operation---------------
@Modifying
@Transactional
@NativeQuery("update students set first_name = ?1 where email_address = ?2")
int updateNameByEmailAddress(String updatingName, String email);

     //----------Delete operation
     @Modifying
     @Transactional
     @NativeQuery("delete from students where email_address = ?1")
     int deleteStudentDetails(String emailId);

}
package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Courses;
import com.raysi.springdatajpa.entities.CourseMaterial;
import com.raysi.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CoursesMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    public void saveData(){
        Teacher teacher = Teacher.builder()
                .firstName("Sonu")
                .lastName("Ray")
                .build();
        Courses course = Courses.builder()
                .courseTitle("ADS")
                .teacher(teacher)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("sonu/pages/education.edu")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }

}package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Courses;
import com.raysi.springdatajpa.entities.CourseMaterial;
import com.raysi.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CoursesMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;


    @Test
    public void saveData(){
        Teacher teacher = Teacher.builder()
                .firstName("Sonu")
                .lastName("Ray")
                .build();
        Courses course = Courses.builder()
                .courseTitle("ADS")
                .teacher(teacher)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("sonu/pages/education.edu")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void getCourseMaterials(){
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }

}
package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.Guardian;
import com.raysi.springdatajpa.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
@Autowired
private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
//        Student student = new Student("Kanxu", "Ydv", "kanxu@gmail.com", "xyz", "xyz@gmail.com", "9899263738");

        Student student = Student.builder()
                        .firstName("Aashish")
                        .lastName("Ray")
                        .emailId("20002raysi@gmail.com")
                        .build();
        studentRepository.save(student);
    }

    @Test
    public void getStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println(students);
    }

    @Test
    public void updateStudentWithGuardian(){
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

    @Test
    public void findStudentByFirstName(){
        List<Student> studentList = studentRepository.findStudentByFirstName("Aashish");
//        System.out.println(studentList);
}

    @Test
    public void findByNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("kan");
//        System.out.println(studentList);
}

    @Test
    public void findStudentByEmailAddressQueryMethod(){
        Student student = studentRepository.findStudentByEmailAddress("2002raysi@gmail.com");
//        System.out.println(student.toString());

    }

    @Test
    public void getFirstName(){
        String student = studentRepository.getFirstNameByEmailAddress("2002raysi@gmail.com");
//        System.out.println("First Name: " + student);
}

    @Test
    public void getFirstNameNative(){
        Student student = studentRepository.getFirstNameByEmailAddressNative("2002raysi@gmail.com");
//        System.out.println("First Name : " + student);
}

    @Test
    public void getFirstNameNativeQuery(){
        String student = studentRepository.getFirstNameByEmailAddressNativeQuery("2002raysi@gmail.com");
        System.out.println("First Name : " + student);
    }

    @Test
    public void getParentNameByFirstName(){
        String parentEmail = studentRepository.getParentEmailByStudentFirstName("Kanxu");
        System.out.println("Parent Email: " + parentEmail);
    }

    @Test
    public void getParentNameByLastName(){
        String parentEmail = studentRepository.getParentEmailByStudentFirstName("Kanxu");
        System.out.println("Parent Email: " + parentEmail);
    }

    @Test
    public void updateFirstName(){
        int rowsAffected = studentRepository.updateNameByEmailAddress("Kanxa", "2002raysi@gmail.com");
        if(rowsAffected > 0)
            System.out.println("Name updated successfully");
    }

    @Test
    public void deleteStudent(){
        int rowsAffected = studentRepository.deleteStudentDetails("20002raysi@gmail.com");
        if(rowsAffected > 0){
            System.out.println("Student data deleted successfully");
        }else{
            System.out.println("No data found");
        }
    }
}


package com.raysi.springdatajpa.repositories;

import com.raysi.springdatajpa.entities.CourseMaterial;
import com.raysi.springdatajpa.entities.Courses;
import com.raysi.springdatajpa.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void getTeachers(){

    }

    @Test
    public void saveTeachers(){
//        CourseMaterial courseMaterial = CourseMaterial.builder()
//                .url("raysi.com")
//                .build();
//        Courses course = Courses.builder()
//                .courseTitle("DSA")
//                .credit(100)
//                .build();
//        Teacher teacher = Teacher.builder()
//                .firstName("Preeti")
//                .lastName("Yadav")
////                .courses(List.of(course))
//                .build();
//        teacherRepository.save(teacher);
}
}
