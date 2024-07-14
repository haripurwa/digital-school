package com.digital_school.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeachersRequest {
    private String name;
    private String address;
    private String contactInformation;
    private String subject;
    private String qualification;
    private String experience;

}
