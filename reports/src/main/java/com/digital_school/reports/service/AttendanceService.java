package com.digital_school.reports.service;

import com.digital_school.reports.dto.AttendanceRequest;
import com.digital_school.reports.dto.AttendanceResponse;

public interface AttendanceService {

    AttendanceResponse create(AttendanceRequest attendanceRequest);
}
