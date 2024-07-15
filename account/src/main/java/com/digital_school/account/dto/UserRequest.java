package com.digital_school.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {
    @Schema(description = "username", example = "harip")
    private String username;
    @Schema(description = "email", example = "harip@gmail.com")
    private String email;
    @Schema(description = "role", example = "admin")
    private String role;
    @Schema(description = "password", example = "admin#123")
    private String password;
}
