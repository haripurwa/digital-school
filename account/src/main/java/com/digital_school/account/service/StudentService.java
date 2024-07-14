package com.digital_school.account.service;

import com.digital_school.account.dto.Response;
import com.digital_school.account.dto.StudentCreateRequest;

public interface StudentService {
    Response create(StudentCreateRequest request);

}
