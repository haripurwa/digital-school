package com.digital_school.reports.controller;

import com.digital_school.reports.dto.AttendanceRequest;
import com.digital_school.reports.dto.AttendanceResponse;
import com.digital_school.reports.service.AttendanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/attendance")
@Tag(name = "Attendance", description = "Attendance management APIs")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @PostMapping
    @Operation(summary = "create new attendance")
    public ResponseEntity<AttendanceResponse> createAttendance(@Valid @RequestBody AttendanceRequest request) {
        AttendanceResponse response = attendanceService.create(request);
        return ResponseEntity.created(URI.create("/api/attendance/" + response.getId())).body(response);
    }


}
