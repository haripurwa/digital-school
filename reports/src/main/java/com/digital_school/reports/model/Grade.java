package com.digital_school.reports.model;

import jakarta.persistence.Entity;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class Grade extends DefaultModel implements Serializable {
    private String gradeId;
    private String studentId;
    private String courseId;
    private String GradePoint;
    private String GradeLatter;
}
