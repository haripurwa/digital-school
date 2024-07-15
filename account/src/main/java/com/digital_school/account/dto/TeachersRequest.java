package com.digital_school.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeachersRequest {

    @Schema(description = "name teachers", example = "hari purwanto")
    private String name;
    @Schema(description = "address", example = "jl.ahmad yani,perum telaga anyar blok K4 no 12,bekasi")
    private String address;
    @Schema(description = "contact information", example = "081211863278")
    private String contactInformation;
    @Schema(description = "subject", example = "kalkulus")
    private String subject;
    @Schema(description = "qualification", example = "S2")
    private String qualification;
    @Schema(description = "experience", example = "samar university")
    private String experience;

}
