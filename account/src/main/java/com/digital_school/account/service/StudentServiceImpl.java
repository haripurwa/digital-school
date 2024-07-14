package com.digital_school.account.service;

import com.digital_school.account.dto.StudentRequest;
import com.digital_school.account.dto.StudentResponse;
import com.digital_school.account.model.Student;
import com.digital_school.account.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> responses = new ArrayList<>();
        for (Student student : students) {
            responses.add(objectMapper.convertValue(student, StudentResponse.class));
        }
        return responses;
    }

    @Override
    public StudentResponse getStudentById(String id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            return objectMapper.convertValue(student, StudentResponse.class);
        }
        return null;
    }

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAddress(studentRequest.getAddress());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setDob(studentRequest.getDob());
        student.setGradeLevel(studentRequest.getGradeLevel());
        student.setClassInfo(studentRequest.getClassInfo());
        student.setParent(studentRequest.getParent());
        Student savedStudent = studentRepository.save(student);
        return objectMapper.convertValue(savedStudent, StudentResponse.class);
    }

    @Override
    public StudentResponse updateStudent(StudentRequest studentRequest, String id) {
        Student existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(studentRequest.getName());
            existingStudent.setAddress(studentRequest.getAddress());
            existingStudent.setPhoneNumber(studentRequest.getPhoneNumber());
            existingStudent.setDob(studentRequest.getDob());
            existingStudent.setGradeLevel(studentRequest.getGradeLevel());
            existingStudent.setClassInfo(studentRequest.getClassInfo());
            existingStudent.setParent(studentRequest.getParent());
            studentRepository.save(existingStudent);
            return objectMapper.convertValue(existingStudent, StudentResponse.class);
        }
        return null;
    }

    @Override
    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }
}