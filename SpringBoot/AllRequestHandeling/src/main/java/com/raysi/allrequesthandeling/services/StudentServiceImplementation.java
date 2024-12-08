package com.raysi.allrequesthandeling.services;

import com.raysi.allrequesthandeling.models.Students;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImplementation implements StudentService{

    List<Students> stdList = new ArrayList<>();

    @Override
    public List<Students> fetchStudents() {
        return stdList;
    }

    @Override
    public String uploadStudent(Students std) {
        stdList.add(std);
        return "Student Uploaded";
    }

    @Override
    public boolean deleteStudent(Long id) {
        int intId = id.intValue();
        boolean removed = stdList.removeIf(x->x.getId() == intId);
        return removed ? true : false;
    }

    @Override
    public String updateStudent(Long id, Students updatedStudent) {
        for(Students std : stdList){
            if(std.getId() == id){
                std.setName(updatedStudent.getName());
                std.setDomain(updatedStudent.getDomain());
                std.setMarks(updatedStudent.getMarks());
                return "Student updated successfully: " + std;
            }
        }
        return "Student with id: " + id + "not found";
    }
}

