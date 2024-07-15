package com.digital_school.account.service;

import com.digital_school.account.dto.ChangePasswordRequest;
import com.digital_school.account.dto.UserRequest;
import com.digital_school.account.dto.UserResponse;
import com.digital_school.account.model.Users;
import com.digital_school.account.repository.UsersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserResponse create(UserRequest userRequest) {
        Users users = new Users();
        users.setUsername(userRequest.getUsername());
        Users savedUser = usersRepository.save(users);
        return objectMapper.convertValue(savedUser, UserResponse.class);
    }

    @Override
    public UserResponse changePassword(ChangePasswordRequest changePasswordRequest, String id) {
        Users user = usersRepository.findById(id).orElse(null);
        if (user != null) {
            if (user.getPassword().equals(changePasswordRequest.getOldPassword())) {
                user.setPassword(changePasswordRequest.getOldPassword());
                return objectMapper.convertValue(user, UserResponse.class);
            }
            return null;
        }
        return null;
    }
}
