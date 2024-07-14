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
public class Enrolment extends DefaultModel implements Serializable {
    private String enrolmentId;
    private String attendanceId;
    private String courseId;
    private String semester;
}
