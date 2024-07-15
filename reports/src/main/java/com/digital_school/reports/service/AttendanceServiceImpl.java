package com.digital_school.reports.service;

import com.digital_school.reports.dto.AttendanceRequest;
import com.digital_school.reports.dto.AttendanceResponse;
import com.digital_school.reports.dto.model.Student;
import com.digital_school.reports.model.Attendance;
import com.digital_school.reports.repository.AttendanceRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AttendanceServiceImpl implements AttendanceService {
    @Value("${base.url.student}")
    private String baseUrlStudent;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public AttendanceResponse create(AttendanceRequest req) {
        String url = baseUrlStudent + "/api/students/" + req.getStudentId();
        try {
            ResponseEntity<Student> response = restTemplate.getForEntity(url, Student.class);
            if (response.getStatusCode() != HttpStatus.OK) {
                throw new RuntimeException("Failed to get student with status code: " + response.getStatusCode());
            }
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            log.info("Error response from server: " + e.getStatusCode() + " " + e.getResponseBodyAsString());
            throw e;
        } catch (Exception e) {
            log.info("An error occurred: " + e.getMessage());
            throw e;
        }
        Attendance attendance = new Attendance();
        attendance.setStudentId(req.getStudentId());
        attendance.setCourseId(req.getCourseId());
        attendance.setSemester(req.getSemester());
        Attendance savedTeachers = attendanceRepository.save(attendance);
        return objectMapper.convertValue(savedTeachers, AttendanceResponse.class);
    }
}
