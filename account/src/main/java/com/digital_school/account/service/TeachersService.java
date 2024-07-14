package com.digital_school.account.service;

import com.digital_school.account.dto.TeachersRequest;
import com.digital_school.account.dto.TeachersResponse;

import java.util.List;

public interface TeachersService {
    TeachersResponse createTeachers(TeachersRequest teachersRequest);

    TeachersResponse getTeachersById(String id);

    TeachersResponse updateTeachers(TeachersRequest teachersRequest, String id);

    List<TeachersResponse> getAllTeachers();

    void deleteTearchers(String id);
}
