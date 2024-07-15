package com.digital_school.account.controller;

import com.digital_school.account.dto.StudentRequest;
import com.digital_school.account.dto.StudentResponse;
import com.digital_school.account.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/students")
@Tag(name = "Student", description = "Student management APIs")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    @Operation(summary = "get all student")
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        List<StudentResponse> responses = studentService.getAllStudents();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{id}")
    @Operation(summary = "get student by id")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable String id) {
        StudentResponse response = studentService.getStudentById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Operation(summary = "create new student")
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        StudentResponse response = studentService.createStudent(studentRequest);
        return ResponseEntity.created(URI.create("/api/students/" + response.getId())).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "update student")
    public ResponseEntity<StudentResponse> updateStudent(@Valid @PathVariable String id, @RequestBody StudentRequest studentRequest) {
        StudentResponse response = studentService.updateStudent(studentRequest, id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "delete student")
    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
