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


