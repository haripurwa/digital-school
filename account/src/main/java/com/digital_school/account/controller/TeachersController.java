package com.digital_school.account.controller;

import com.digital_school.account.dto.TeachersRequest;
import com.digital_school.account.dto.TeachersResponse;
import com.digital_school.account.service.TeachersService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/teacher")
public class TeachersController {
    @Autowired
    private TeachersService teachersService;

    @PostMapping
    public ResponseEntity<TeachersResponse> createTeacher(@Valid @RequestBody TeachersRequest teachersRequest) {
        TeachersResponse response = teachersService.createTeachers(teachersRequest);
        return ResponseEntity.created(URI.create("/api/teachers/" + response.getId())).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeachersResponse> getTeacherById(@PathVariable String id) {
        TeachersResponse response = teachersService.getTeachersById(id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeachersResponse> updateTeacher(@Valid @PathVariable String id, @RequestBody TeachersRequest teachersRequest) {
        TeachersResponse response = teachersService.updateTeachers(teachersRequest, id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TeachersResponse>> getAllTeachers() {
        List<TeachersResponse> responses = teachersService.getAllTeachers();
        return ResponseEntity.ok(responses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeacher(@PathVariable String id) {
        teachersService.deleteTearchers(id);
        return ResponseEntity.noContent().build();
    }

}
