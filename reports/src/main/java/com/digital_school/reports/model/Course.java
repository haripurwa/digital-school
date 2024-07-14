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
public class Course extends DefaultModel implements Serializable {
    private String CourseId;
    private String name;
    private String description;
    private String credit;

}
