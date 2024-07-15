package com.digital_school.reports.controller;

import com.digital_school.reports.dto.AttandanceRequest;
import com.digital_school.reports.dto.AttandanceResponse;
import com.digital_school.reports.service.AttandanceService;
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
@RequestMapping("/api/attandance")
@Tag(name = "Attandance", description = "Attandance management APIs")
public class AttandanceController {
    @Autowired
    private AttandanceService attandanceService;

    @PostMapping
    @Operation(summary = "create new attandance")
    public ResponseEntity<AttandanceResponse> createAttandance(@Valid @RequestBody AttandanceRequest request) {
        AttandanceResponse response = attandanceService.create(request);
        return ResponseEntity.created(URI.create("/api/attandance/" + response.getId())).body(response);
    }


}
