package com.digital_school.account.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only be alpha")
    private String name;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9,.]+$", message = "")
    private String address;
    @NotEmpty
    @Pattern(regexp = "^\\d{10}$")
    private String phoneNumber;
    @NotEmpty
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    private String dob;
    private String gradeLevel;
    private String classInfo;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String parent;
}
