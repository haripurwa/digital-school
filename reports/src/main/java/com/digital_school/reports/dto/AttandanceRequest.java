package com.digital_school.reports.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AttandanceRequest {
    @Schema(description = "studentId", example = "310b1a07-39c8-43bd-867b-470c6cbda77a")
    private String studentId;
    @Schema(description = "courseid", example = "310b1a07-39c8-43bd-867b-470c6cbda77a")
    private String courseId;
    @Schema(description = "semester", example = "IV")
    private String semester;
}
