package com.digital_school.account.service;

import com.digital_school.account.dto.StudentRequest;
import com.digital_school.account.dto.StudentResponse;

import java.util.List;

public interface StudentService {
    List<StudentResponse> getAllStudents();
    StudentResponse getStudentById(String id);
    StudentResponse createStudent(StudentRequest studentRequest);
    StudentResponse updateStudent(StudentRequest studentRequest, String id);
    void deleteStudent(String id);
}
