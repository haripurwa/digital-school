package com.digital_school.reports.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError {
    private int status;
    private String message;
}
