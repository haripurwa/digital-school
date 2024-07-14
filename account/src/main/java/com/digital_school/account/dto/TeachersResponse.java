package com.digital_school.account.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TeachersResponse {
    private String id;
    private String name;
    private String address;
    private String contactInformation;
    private String subject;
    private String qualification;
    private String experience;

}
