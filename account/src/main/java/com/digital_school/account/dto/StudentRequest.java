package com.digital_school.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequest {
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Name can only be alpha")
    @Schema(description = "name", example = "hari purwanto")
    private String name;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9,.]+$", message = "")
    @Schema(description = "address", example = "bekasi utara,tambun")
    private String address;
    @NotEmpty
    @Pattern(regexp = "^\\d{10}$")
    @Schema(description = "phone number", example = "081211863278")
    private String phoneNumber;
    @NotEmpty
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$")
    @Schema(description = "dob", example = "12/12/1997")
    private String dob;
    @Schema(description = "gradeLevel", example = "S1")
    private String gradeLevel;
    @Schema(description = "class info", example = "12Mp2")
    private String classInfo;
    @NotEmpty
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Schema(description = "parent", example = "ambyar")
    private String parent;
}
