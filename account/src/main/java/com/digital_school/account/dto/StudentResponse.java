package com.digital_school.account.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class StudentResponse {
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String dob;
    private String gradeLevel;
    private String classInfo;
    private String parent;
}
