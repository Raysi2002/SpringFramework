package com.raysi.allrequesthandeling.services;

import com.raysi.allrequesthandeling.models.Students;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StudentService{
    List<Students> fetchStudents();
    String uploadStudent(Students students);
    boolean deleteStudent(Long id);

    String updateStudent(Long id, Students updatedStudent);
}
