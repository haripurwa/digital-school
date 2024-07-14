package com.digital_school.reports.repository;
import com.digital_school.reports.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttendanceRepository  extends JpaRepository<Attendance, UUID> {
}
