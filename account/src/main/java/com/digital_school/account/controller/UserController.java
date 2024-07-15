package com.digital_school.account.controller;

import com.digital_school.account.dto.*;
import com.digital_school.account.service.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/user")
@Tag(name = "Users", description = "Users management APIs")
public class UserController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    @Operation(summary = "create new Users")
    public ResponseEntity<UserResponse> createTeacher(@Valid @RequestBody UserRequest userRequest) {
        UserResponse response = usersService.create(userRequest);
        return ResponseEntity.created(URI.create("/api/teachers/" + response.getId())).body(response);
    }

    @PutMapping("/{id}")
    @Operation(summary = "change password")
    public ResponseEntity<UserResponse> updateTeacher(@Valid @PathVariable String id, @RequestBody ChangePasswordRequest request) {
        UserResponse response = usersService.changePassword(request, id);
        if (response != null) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.notFound().build();
    }

}
