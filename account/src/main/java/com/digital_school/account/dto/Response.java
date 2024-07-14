package com.digital_school.account.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;


@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Response<T> {
    @JsonIgnore
    private Integer httpCode;
    private String responseCode;
    private String responseDesc;
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private T responseData;
}
