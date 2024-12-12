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
