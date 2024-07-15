package com.digital_school.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChangePasswordRequest {
    @Schema(description = "password", example = "admin#123")
    private String oldPassword;
    @Schema(description = "password", example = "admin#321")
    private String newPassword;

}
