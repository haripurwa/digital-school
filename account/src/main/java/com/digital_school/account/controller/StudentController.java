package com.digital_school.account.controller;

import com.digital_school.account.dto.Response;
import com.digital_school.account.dto.StudentCreateRequest;
import com.digital_school.account.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    public ResponseEntity<?> create(@RequestBody StudentCreateRequest request) {
        Response response = studentService.create(request);
        return new ResponseEntity<>(response, HttpStatus.resolve(HttpStatus.OK.value()));
    }
}
