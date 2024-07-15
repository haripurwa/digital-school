package com.digital_school.reports.repository;

import com.digital_school.reports.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GradeRepository extends JpaRepository<Grade, String> {
}
