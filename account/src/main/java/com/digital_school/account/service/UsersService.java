package com.digital_school.account.service;

import com.digital_school.account.dto.*;


public interface UsersService {
    UserResponse create(UserRequest userRequest);
    UserResponse changePassword(ChangePasswordRequest changePasswordRequest,String id);
}
