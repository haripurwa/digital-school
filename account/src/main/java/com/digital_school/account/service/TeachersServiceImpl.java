package com.digital_school.account.service;


import com.digital_school.account.dto.TeachersRequest;
import com.digital_school.account.dto.TeachersResponse;
import com.digital_school.account.model.Teachers;
import com.digital_school.account.repository.TeachersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeachersServiceImpl implements TeachersService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TeachersRepository teachersRepository;

    @Override
    public TeachersResponse createTeachers(TeachersRequest teachersRequest) {
        Teachers teachers = new Teachers();
        teachers.setName(teachersRequest.getName());
        teachers.setAddress(teachersRequest.getAddress());
        teachers.setSubject(teachersRequest.getSubject());
        teachers.setContactInformation(teachersRequest.getContactInformation());
        teachers.setQualification(teachersRequest.getQualification());
        teachers.setExperience(teachersRequest.getExperience());
        Teachers savedTeachers = teachersRepository.save(teachers);
        return objectMapper.convertValue(savedTeachers, TeachersResponse.class);
    }

    @Override
    public TeachersResponse getTeachersById(String id) {
        Teachers teacher = teachersRepository.findById(id).orElse(null);
        if (teacher != null) {
            return objectMapper.convertValue(teacher, TeachersResponse.class);
        }
        return null;
    }

    @Override
    public TeachersResponse updateTeachers(TeachersRequest teachersRequest, String id) {
        Teachers existingTeacher = teachersRepository.findById(id).orElse(null);
        if (existingTeacher != null) {
            existingTeacher.setName(teachersRequest.getName());
            existingTeacher.setAddress(teachersRequest.getAddress());
            existingTeacher.setSubject(teachersRequest.getSubject());
            existingTeacher.setContactInformation(teachersRequest.getContactInformation());
            existingTeacher.setQualification(teachersRequest.getQualification());
            existingTeacher.setExperience(teachersRequest.getExperience());
            teachersRepository.save(existingTeacher);
            return objectMapper.convertValue(existingTeacher, TeachersResponse.class);
        }
        return null;
    }

    @Override
    public List<TeachersResponse> getAllTeachers() {
        List<Teachers> teachers = teachersRepository.findAll();
        List<TeachersResponse> responses = new ArrayList<>();
        for (Teachers teacher : teachers) {
            responses.add(objectMapper.convertValue(teacher, TeachersResponse.class));
        }
        return responses;
    }

    @Override
    public void deleteTearchers(String id) {
        teachersRepository.deleteById(id);
    }
}
